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
public class Filmes {

    @Id
    @GeneratedValue
    @Column(name = "id_filme")
    private Integer id_filme;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "duracao_min")
    private Integer duracao_min;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @Column(name = "classificacaoEtaria")
    private String classificacaoEtaria;

    @Column(name = "genero")
    private String genero;

    public Filmes(String titulo, Integer duracao_min, Integer anoLancamento, String classificacaoEtaria, String genero) {
        this.titulo = titulo;
        this.duracao_min = duracao_min;
        this.anoLancamento = anoLancamento;
        this.classificacaoEtaria = classificacaoEtaria;
        this.genero = genero;
    }
}
