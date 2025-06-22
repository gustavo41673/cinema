package br.edu.fiec.cinema_project.repository;


import br.edu.fiec.cinema_project.model.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

}
