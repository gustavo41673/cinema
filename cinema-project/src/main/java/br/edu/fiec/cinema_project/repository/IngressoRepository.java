package br.edu.fiec.cinema_project.repository;

import br.edu.fiec.cinema_project.model.entity.Ingressos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngressoRepository extends JpaRepository<Ingressos, Integer> {

    Optional <Ingressos> findByNameCliente(String nome_cliente);
}
