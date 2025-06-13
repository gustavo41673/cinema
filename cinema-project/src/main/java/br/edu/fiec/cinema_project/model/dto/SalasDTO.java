package br.edu.fiec.cinema_project.model.dto;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalasDTO {

    private Integer Id_sala;

    private String nome;

    private Integer capacidade;

    private String tipo_sala;

}
