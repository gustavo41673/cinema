package br.edu.fiec.cinema_project.model.entity;

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
public class Filme {

    @Id
    @GeneratedValue
    @Column(name = "id_filme")
    private Integer id_filme;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "duracao_min")
    private Integer duracao_min;

    @Column(name = "ano_lancamento")
    private Integer ano_lancamento;

    @Column(name = "classificacao_etaria")
    private String classificacao_etaria;

    @Column(name = "genero")
    private String genero;

    public Filme(String titulo, Integer duracao_min, Integer ano_lancamento, String classificacao_etaria, String genero) {
        this.titulo = titulo;
        this.duracao_min = duracao_min;
        this.ano_lancamento = ano_lancamento;
        this.classificacao_etaria = classificacao_etaria;
        this.genero = genero;
    }
}
