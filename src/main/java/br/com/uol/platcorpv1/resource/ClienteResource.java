package br.com.uol.platcorpv1.resource;

import java.util.List;

import javax.validation.Valid;

import br.com.uol.platcorpv1.domain.ClienteEventos;
import br.com.uol.platcorpv1.repository.ClienteEventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.platcorpv1.domain.Cliente;
import br.com.uol.platcorpv1.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(value = "API REST Clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteEventosRepository clienteEventosRepository;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Clientes")
	public ResponseEntity<List<ClienteEventos>> findAll() {
		List<ClienteEventos> list = clienteEventosRepository.findAll();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Cria um novo Ciente")
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente cliente) {
		Cliente result = clienteService.insert(cliente);
		return new ResponseEntity(result, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um unico Cliente")
	public ResponseEntity<Cliente> find(@PathVariable Long id) {
		Cliente result = clienteService.find(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um unico Cliente")
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
		cliente.setId(id);
		Cliente result = clienteService.update(cliente);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um unico Cliente")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
