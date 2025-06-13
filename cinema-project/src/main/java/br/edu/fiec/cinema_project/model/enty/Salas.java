package br.edu.fiec.cinema_project.model.enty;

import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salas {

    @Id
    @GeneratedValue
    @Column(name = "id_sala")
    private Integer id_sala;

    @Column(name = "nome")
    private String nome;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "tipo_sala")
    private String tipo_sala;





}
