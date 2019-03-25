package br.com.uol.platcorpv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uol.platcorpv1.domain.ClienteEventos;

@Repository
public interface ClienteEventosRepository extends JpaRepository<ClienteEventos, Long> {    
}
