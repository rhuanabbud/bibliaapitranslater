package br.com.bibliaapitranslater.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Biblia {

    @Id
    @Column(name = "id_livro")
    private Long idLivro;

    private String nome;

    private String abreviatura;

    private String testamento;

    @Column(name = "numero_livro")
    private int numeroLivro;

    @Column(name = "numero_capitulo")
    private int numeroCapitulo;

    @Column(name = "numero_versiculo")
    private int numeroVersiculo;

    private String versiculo;
}