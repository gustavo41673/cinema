package br.edu.fiec.cinema_project.service;

import br.edu.fiec.cinema_project.model.dto.SessaoDTO;
import br.edu.fiec.cinema_project.model.entity.Filme;
import br.edu.fiec.cinema_project.model.entity.Salas;
import br.edu.fiec.cinema_project.model.entity.Sessao;
import br.edu.fiec.cinema_project.repository.FilmeRepository;
import br.edu.fiec.cinema_project.repository.SalaRepository;
import br.edu.fiec.cinema_project.repository.SessaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final FilmeRepository filmeRepository;
    private final SalaRepository salaRepository;

    public Sessao create(SessaoDTO dto) {
        Filme filme = filmeRepository.findById(dto.getId_filme())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        Salas sala = salaRepository.findById(dto.getId_sala())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        Sessao sessao = new Sessao();
        sessao.setId_sessao(dto.getId_sessao());
        sessao.setId_filme(filme);
        sessao.setId_sala(sala);
        sessao.setData(dto.getData());
        sessao.setHorario(dto.getHorario());
        sessao.setPreco_base(dto.getPreco_base());

        return sessaoRepository.save(sessao);
    }


    public Sessao getById(Integer id) {
        return sessaoRepository.findById(id)
                .map(sessao -> new Sessao(
                        sessao.getId_sessao(),
                        sessao.getId_filme(),
                        sessao.getId_sala(),
                        sessao.getData(),
                        sessao.getHorario(),
                        sessao.getPreco_base()
                ))
                .orElse(null);
    }

}
