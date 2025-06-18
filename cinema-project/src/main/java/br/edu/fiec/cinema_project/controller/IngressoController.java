package br.edu.fiec.cinema_project.controller;


import br.edu.fiec.cinema_project.model.dto.IngressoDTO;
import br.edu.fiec.cinema_project.model.enty.Ingressos;
import br.edu.fiec.cinema_project.service.IngressoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("cinema")
public class IngressoController {

    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "id")
    public Ingressos getById(Integer id){
        return ingressoService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "name")
    public List<Ingressos> getByNome_ingresso(String nome_cliente){
        return ingressoService.getByNome(nome_cliente);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, value = "create")
    public void create(@RequestBody IngressoDTO ingressoDTO){
        ingressoService.create(ingressoDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "getAll")
    public List<Ingressos> getAll(){
        return ingressoService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "delete")
    public void delete(Integer id){
        ingressoService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "deleteAll")
    public void deleteAll(){
        ingressoService.deleteAll();
    }

}
