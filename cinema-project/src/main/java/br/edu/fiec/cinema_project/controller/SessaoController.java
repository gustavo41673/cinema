package br.edu.fiec.cinema_project.controller;

import br.edu.fiec.cinema_project.model.entity.Salas;
import br.edu.fiec.cinema_project.model.entity.Sessao;
import br.edu.fiec.cinema_project.service.SalasService;
import br.edu.fiec.cinema_project.service.SessaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Sessao criarSessao(@RequestBody Sessao sessao) {
        return sessaoService.createSessao(sessao);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "id")
    public Sessao getById(Integer id){
        return sessaoService.getById(id);
    }

}
