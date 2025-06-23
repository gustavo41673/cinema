package br.edu.fiec.cinema_project.controller;

import br.edu.fiec.cinema_project.model.dto.SessaoDTO;
import br.edu.fiec.cinema_project.model.entity.Sessoes;
import br.edu.fiec.cinema_project.service.SessaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("sessao")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Sessoes criarSessao(@RequestBody Sessoes sessoes) {
        return sessaoService.createSessao(sessoes);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "id")
    public Sessoes getById(Integer id){
        return sessaoService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "BuscaPorHorario")
    public Stream<SessaoDTO> getByHorario(LocalTime horario){
        return sessaoService.getByHorario(horario);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "BuscaPorPreco")
    public Stream<SessaoDTO> getByPreco(BigDecimal preco_base){
        return sessaoService.getByPrecoBase(preco_base);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value = "update")
    public Sessoes update(@RequestParam Integer id, @RequestBody SessaoDTO dto) {
        return sessaoService.update(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "delete")
    public void delete(Integer id){
        sessaoService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "deleteAll")
    public void deleteAll(){
        sessaoService.deleteAll();
    }


}
