package br.com.bibliaapitranslater.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Livro {

    @Id
    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String abreviatura;

    @Column(nullable = false)
    private String testamento;

    @Column(name = "numero_livro", nullable = false)
    private int numeroLivro;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Capitulo> capitulos;
}