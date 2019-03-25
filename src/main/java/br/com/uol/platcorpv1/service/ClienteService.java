package br.com.uol.platcorpv1.service;

import br.com.uol.platcorpv1.domain.Cliente;
import br.com.uol.platcorpv1.domain.ClienteEventos;
import br.com.uol.platcorpv1.dto.MetaWeatherDTO;
import br.com.uol.platcorpv1.repository.ClienteEventosRepository;
import br.com.uol.platcorpv1.repository.ClienteRepository;
import br.com.uol.platcorpv1.service.exception.ObjectNotFoundException;
import br.com.uol.platcorpv1.utils.Generics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Import({ Generics.class })
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteEventosRepository clienteEventoRepository;

	@Autowired
	private ClienteEventosService clienteEventosService;

	@Autowired
	private Generics generics;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente find(Long id) {
		Cliente cliente = clienteRepository.getById(id);
		if (cliente == null) throw new ObjectNotFoundException("Id: " + id + " Not found");
		return cliente;
	}

	public Cliente insert(Cliente cliente) {
		try {
			LocalDate localDate = LocalDate.now();
			String ipCountry = clienteEventosService.buscaGeolocalizacao().getData().getSubdivision_1_name().toLowerCase();
			String latlong = clienteEventosService.buscaGeolocalizacao().getData().latitude + ","+ clienteEventosService.buscaGeolocalizacao().getData().longitude;

			MetaWeatherDTO result = clienteEventosService.buscaClima("location/search/?lattlong=" + latlong).stream()
					.filter(vf -> generics.removeAccents(vf.getTitle()).equals(ipCountry)).findAny().orElse(null);

			List<MetaWeatherDTO> temperature = clienteEventosService.buscaClima(
					"location/" + result.getWoeid() + "/" + generics.convertToLocalDate("yyy/MM/dd", localDate));

			cliente.setId(null);
			clienteRepository.save(cliente);
			ClienteEventos evt = new ClienteEventos(null, cliente, temperature.get(0).getMax_temp(), temperature.get(0).getMin_temp(), clienteEventosService.ipMaquina(), clienteEventosService.IpInterno()); clienteEventoRepository.save(evt);
		} catch (Exception e) {
		}
		return cliente;

	}

	public Cliente update(Cliente cliente) {
		find(cliente.getId());
		return clienteRepository.save(cliente);
	}

	public void delete(Long id) throws EmptyResultDataAccessException {
		Long idDeleted = id;
		try {
			clienteEventoRepository.deleteById(idDeleted);
			clienteRepository.deleteById(idDeleted);
		} catch (EmptyResultDataAccessException e) {
			throw new br.com.uol.platcorpv1.service.exception.EmptyResultDataAccessException("Não é possivel excluir um registro que não existe");
		}
	}
}
