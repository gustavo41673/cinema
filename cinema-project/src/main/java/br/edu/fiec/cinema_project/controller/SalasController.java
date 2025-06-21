package br.edu.fiec.cinema_project.controller;


import br.edu.fiec.cinema_project.model.entity.Ingressos;
import br.edu.fiec.cinema_project.model.entity.Salas;
import br.edu.fiec.cinema_project.service.SalasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("salas")
public class SalasController {

    private final SalasService salasService;

    public SalasController(SalasService salasService) {
        this.salasService = salasService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "id")
    public Salas getById(Integer id){
        return salasService.getById(id);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Salas criarSala(@RequestBody Salas salas) {
        return salasService.createSala(salas);
    }

    @GetMapping(value = "/buscarPorCapacidadeMinima", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Salas>> buscarPorCapacidadeMinima(@RequestParam int capacidade) {
        return ResponseEntity.ok(salasService.buscarPorCapacidadeMinima(capacidade));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "nome")
    public Stream<Object> getByName_salas(String nome){
        return salasService.getByNome(nome);
    }

//    @GetMapping(value = "/comSessao", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Salas>> salasComSessao() {
//        return ResponseEntity.ok(salasService.salasComSessao());
//    }
}
