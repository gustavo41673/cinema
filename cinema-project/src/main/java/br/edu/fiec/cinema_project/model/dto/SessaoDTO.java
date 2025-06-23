package br.edu.fiec.cinema_project.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessaoDTO {

    private Integer id_sessao;

    private Integer id_filme;

    private Integer id_sala;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horario;

    private BigDecimal precoBase;
}
