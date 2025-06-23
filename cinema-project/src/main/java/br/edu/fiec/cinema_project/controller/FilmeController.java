package br.edu.fiec.cinema_project.controller;

import br.edu.fiec.cinema_project.model.entity.Filmes;
import br.edu.fiec.cinema_project.model.dto.FilmeDTO;
import br.edu.fiec.cinema_project.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Filmes criarFilme(@RequestBody Filmes filmes) {
        return filmeService.createFilme(filmes);
    }

    @GetMapping(value = "buscarPorId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Filmes buscarPorId(@RequestParam Integer id) {
        return filmeService.getById(id);
    }

    @GetMapping(value = "/buscarPorGenero", produces = MediaType.APPLICATION_JSON_VALUE)
    public Stream<FilmeDTO> buscarPorGenero(@RequestParam String genero) {
        return filmeService.getByGenero(genero);
    }

    @GetMapping(value = "buscarPorAno", produces = MediaType.APPLICATION_JSON_VALUE)
    public Stream<FilmeDTO> buscarPorAno(@RequestParam int anoLancamento) {
        return filmeService.getByAnoLancamento(anoLancamento);
    }

    @PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Filmes atualizarFilme(@RequestParam Integer id, @RequestBody FilmeDTO dto) {
        return filmeService.update(id, dto);
    }

    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFilme(@RequestParam Integer id) {
        filmeService.delete(id);
    }

    @DeleteMapping("deletarALl")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAll() {
        filmeService.deleteAll();
    }
}
