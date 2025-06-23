package br.edu.fiec.cinema_project.model.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {

    private Integer id_filme;

    private String titulo;

    private int duracao_min;

    private int anoLancamento;

    private String classificacaoEtaria;

    private String genero;
}

