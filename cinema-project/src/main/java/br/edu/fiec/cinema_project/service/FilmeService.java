package br.edu.fiec.cinema_project.service;

import br.edu.fiec.cinema_project.model.dto.FilmeDTO;
import br.edu.fiec.cinema_project.model.entity.Filmes;
import br.edu.fiec.cinema_project.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public Filmes createFilme(Filmes dto) {
        Filmes filme = new Filmes();
        filme.setId_filme(dto.getId_filme());
        filme.setTitulo(dto.getTitulo());
        filme.setDuracao_min(dto.getDuracao_min());
        filme.setAnoLancamento(dto.getAnoLancamento());
        filme.setClassificacaoEtaria(dto.getClassificacaoEtaria());
        filme.setGenero(dto.getGenero());

        return filmeRepository.save(filme);
    }

    public Filmes getById(Integer id) {
        return filmeRepository.findById(id)
                .map(filme -> new Filmes(
                        filme.getId_filme(),
                        filme.getTitulo(),
                        filme.getDuracao_min(),
                        filme.getAnoLancamento(),
                        filme.getClassificacaoEtaria(),
                        filme.getGenero()
                ))
                .orElse(null);
    }

    public Stream<FilmeDTO> getByGenero(String genero) {
        return filmeRepository.findByGenero(genero)
                .stream()
                .map(filme -> new FilmeDTO(
                        filme.getId_filme(),
                        filme.getTitulo(),
                        filme.getDuracao_min(),
                        filme.getAnoLancamento(),
                        filme.getClassificacaoEtaria(),
                        filme.getGenero()
                ));
    }

    public Stream<FilmeDTO> getByAnoLancamento(int ano) {
        return filmeRepository.findByAnoLancamento(ano)
                .stream()
                .map(filme -> new FilmeDTO(
                        filme.getId_filme(),
                        filme.getTitulo(),
                        filme.getDuracao_min(),
                        filme.getAnoLancamento(),
                        filme.getClassificacaoEtaria(),
                        filme.getGenero()
                ));
    }

    public Filmes update(Integer id, FilmeDTO dto) {
        return filmeRepository.findById(id)
                .map(filme -> {
                    filme.setTitulo(dto.getTitulo());
                    filme.setDuracao_min(dto.getDuracao_min());
                    filme.setAnoLancamento(dto.getAnoLancamento());
                    filme.setClassificacaoEtaria(dto.getClassificacaoEtaria());
                    filme.setGenero(dto.getGenero());
                    return filmeRepository.save(filme);
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        filmeRepository.findById(id).ifPresent(filmeRepository::delete);
    }

    public void deleteAll() {
        filmeRepository.deleteAll();
    }
}
