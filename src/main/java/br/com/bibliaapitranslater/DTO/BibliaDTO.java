package br.com.bibliaapitranslater.DTO;

import br.com.bibliaapitranslater.model.Biblia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliaDTO {

    private Long idLivro;
    private String nome;
    private String abreviatura;
    private String testamento;
    private int numeroLivro;
    private int numeroCapitulo;
    private int numeroVersiculo;
    private String versiculo;

    public BibliaDTO convertModelToBibliaDTO(Biblia biblia) {
        BeanUtils.copyProperties(biblia, this);
        return this;
    }

    public List<BibliaDTO> convertPtBrToDtoList (List<Biblia> livroBiblia) {
        List<BibliaDTO> dtoList = new ArrayList<>();
        livroBiblia.forEach(u -> dtoList.add(new BibliaDTO().convertModelToBibliaDTO(u)));
        return dtoList;
    }


}
