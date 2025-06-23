package br.edu.fiec.cinema_project.repository;

import br.edu.fiec.cinema_project.model.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmeRepository extends JpaRepository<Filmes, Integer> {
    List<Filmes> findByGenero(String genero);
    List<Filmes> findByAnoLancamento(Integer anoLancamento);
}

