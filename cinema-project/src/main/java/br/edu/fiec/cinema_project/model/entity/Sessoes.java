package br.edu.fiec.cinema_project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sessoes {

    @Id
    @GeneratedValue
    @Column(name = "id_sessao")
    private Integer id_sessao;

    @Column(nullable = false, name = "id_filme")
    private Integer id_filme;

    @Column(nullable = false, name = "id_sala")
    private Integer id_sala;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "preco_base")
    private BigDecimal precoBase;

}

