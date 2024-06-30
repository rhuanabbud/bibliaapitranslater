package br.com.bibliaapitranslater.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Versiculo {

    @Id
    @Column(name = "id_versiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVersiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_capitulo", nullable = false)
    private Capitulo capitulo;

    @Column(name = "numero_versiculo", nullable = false)
    private int numeroVersiculo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String versiculo;
}