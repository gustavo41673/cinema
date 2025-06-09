package br.edu.fiec.cinema_project.model.enty;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingressos {

    @Id
    @GeneratedValue
    @Column(name = "id_ingresso")
    private Integer id_ingresso;

    @Column(nullable = false,name = "id_sessao")
    private Integer id_sessao;

    @Column(name = "nome_cliente")
    private String nome_cliente;

    @Column(name = "assento")
    private String assento;

    @Column(nullable = false,name = "tipo_ingresso")
    private String tipo_ingresso;

    @Column(nullable = false,name = "status")
    private String status;

    @Column(nullable = false, name = "valor")
    private Float valor;


}
