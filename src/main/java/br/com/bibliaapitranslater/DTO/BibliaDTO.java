package br.com.bibliaapitranslater.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliaDTO {

    private String idLivro;
    private String nome;
    private String abreviatura;
    private String testamento;
    private String numeroLivro;
    private String numeroCapitulo;
    private String numeroVersiculo;
    private String versiculo;
}
