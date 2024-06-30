package br.com.bibliaapitranslater.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Versiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id", nullable = false)
    private Capitulo capitulo;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;
}