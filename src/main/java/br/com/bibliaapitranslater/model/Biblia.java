package br.com.bibliaapitranslater.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@SqlResultSetMapping(name="BibliaSelectValue",
        classes = {
                @ConstructorResult(
                        targetClass = Biblia.class,
                        columns = {
                                @ColumnResult(name = "idLivro", type = Long.class),
                                @ColumnResult(name = "nome", type = String.class),
                                @ColumnResult(name = "abreviatura", type = String.class),
                                @ColumnResult(name = "testamento", type = String.class),
                                @ColumnResult(name = "numeroLivro", type = Integer.class),
                                @ColumnResult(name = "numeroCapitulo", type = Integer.class),
                                @ColumnResult(name = "numeroVersiculo", type = Integer.class),
                                @ColumnResult(name = "versiculo", type = String.class)
                        })
        })
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
