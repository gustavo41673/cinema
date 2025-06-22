package br.edu.fiec.cinema_project.controller;


import br.edu.fiec.cinema_project.model.dto.SalasDTO;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "BuscarPorCapacidade")
    public ResponseEntity<List<Salas>> buscarPorCapacidade(@RequestParam int capacidade) {
        return ResponseEntity.ok(salasService.buscarPorCapacidadeMinima(capacidade));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "nome")
    public Stream<Object> getByName_salas(String nome){
        return salasService.getByNome(nome);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "update")
    public Salas update(@RequestParam Integer id, @RequestBody SalasDTO dto) {
        return salasService.update(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "delete")
    public void delete(Integer id){
        salasService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "deleteAll")
    public void deleteAll(){
        salasService.deleteAll();
    }
}
