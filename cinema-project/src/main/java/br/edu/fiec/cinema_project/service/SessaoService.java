package br.edu.fiec.cinema_project.service;

import br.edu.fiec.cinema_project.model.dto.SessaoDTO;
import br.edu.fiec.cinema_project.model.entity.Sessoes;
import br.edu.fiec.cinema_project.repository.SessaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class SessaoService {

    private final SessaoRepository sessaoRepository;

    public Sessoes createSessao(Sessoes dto) {

        Sessoes sessoes = new Sessoes();
        sessoes.setId_filme(dto.getId_filme());
        sessoes.setId_sala(dto.getId_sala());
        sessoes.setData(dto.getData());
        sessoes.setHorario(dto.getHorario());
        sessoes.setPrecoBase(dto.getPrecoBase());

        return sessaoRepository.save(sessoes);
    }


    public Sessoes getById(Integer id) {
        return sessaoRepository.findById(id)
                .map(sessoes -> new Sessoes(
                        sessoes.getId_sessao(),
                        sessoes.getId_filme(),
                        sessoes.getId_sala(),
                        sessoes.getData(),
                        sessoes.getHorario(),
                        sessoes.getPrecoBase()
                ))
                .orElse(null);
    }

    public Stream<SessaoDTO> getByHorario(LocalTime horario) {
        return sessaoRepository.findByHorario(horario)
                .stream()
                .map(sessao -> new SessaoDTO(
                        sessao.getId_sessao(),
                        sessao.getId_filme(),
                        sessao.getId_sala(),
                        sessao.getData(),
                        sessao.getHorario(),
                        sessao.getPrecoBase()
                ));
    }

    public Stream<SessaoDTO> getByPrecoBase(BigDecimal preco_base) {
        return sessaoRepository.findByPrecoBase(preco_base)
                .stream()
                .map(sessao -> new SessaoDTO(
                        sessao.getId_sessao(),
                        sessao.getId_filme(),
                        sessao.getId_sala(),
                        sessao.getData(),
                        sessao.getHorario(),
                        sessao.getPrecoBase()
                ));
    }

    public Sessoes update(Integer id, SessaoDTO dto) {
        return sessaoRepository.findById(id)
                .map(sessao -> {
                    sessao.setId_filme(dto.getId_filme());
                    sessao.setId_sala(dto.getId_sala());
                    sessao.setData(dto.getData());
                    sessao.setHorario(dto.getHorario());
                    sessao.setPrecoBase(dto.getPrecoBase());
                    return sessaoRepository.save(sessao);
                })
                .orElse(null);
    }


    public void delete(Integer id) {
        sessaoRepository.findById(id).ifPresent(sessaoRepository::delete);
    }

    public void deleteAll() {
        sessaoRepository.deleteAll();
    }

}
