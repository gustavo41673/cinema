package br.edu.fiec.cinema_project.repository;


import br.edu.fiec.cinema_project.model.entity.Sessoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessoes, Integer> {

    List<Sessoes> findByHorario(LocalTime horario);

    List<Sessoes> findByPrecoBase(BigDecimal precoBase);
}
