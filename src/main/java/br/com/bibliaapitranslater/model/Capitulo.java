package br.com.bibliaapitranslater.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Capitulo {

    @Id
    @Column(name = "id_capitulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCapitulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private Livro livro;

    @Column(name = "numero_capitulo", nullable = false)
    private int numeroCapitulo;

    @OneToMany(mappedBy = "versiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Versiculo> versiculos;
}