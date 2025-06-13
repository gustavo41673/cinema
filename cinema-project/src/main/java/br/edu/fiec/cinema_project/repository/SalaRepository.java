package br.edu.fiec.cinema_project.repository;

import br.edu.fiec.cinema_project.model.enty.Ingressos;
import br.edu.fiec.cinema_project.model.enty.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaRepository extends JpaRepository<Salas, Integer> {

}
