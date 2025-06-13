package br.edu.fiec.cinema_project.controller;


import br.edu.fiec.cinema_project.model.enty.Ingressos;
import br.edu.fiec.cinema_project.model.enty.Salas;
import br.edu.fiec.cinema_project.repository.SalaRepository;
import br.edu.fiec.cinema_project.service.SalasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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


}
