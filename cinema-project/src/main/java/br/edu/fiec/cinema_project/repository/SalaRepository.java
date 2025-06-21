package br.edu.fiec.cinema_project.repository;

import br.edu.fiec.cinema_project.model.entity.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Salas, Integer> {

    List<Salas> findByNome(String nome);

    Salas[] findByCapacidade(int capacidade);


}
