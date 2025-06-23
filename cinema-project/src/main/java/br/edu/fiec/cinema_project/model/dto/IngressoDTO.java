package br.edu.fiec.cinema_project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngressoDTO {


    private String nameCliente;

    private String assento;

    private String tipo_ingresso;

    private Float valor;
}
