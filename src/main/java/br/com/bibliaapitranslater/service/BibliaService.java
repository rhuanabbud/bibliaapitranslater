package br.com.bibliaapitranslater.service;

import br.com.bibliaapitranslater.DTO.BibliaDTO;
import br.com.bibliaapitranslater.model.Biblia;
import br.com.bibliaapitranslater.repository.QuerysBiblia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliaService {

    private static final Logger logger = LoggerFactory.getLogger(BibliaService.class);

    private final QuerysBiblia jpql;

    @Autowired
    public BibliaService(QuerysBiblia jpql) {
        this.jpql = jpql;
    }

    public List<BibliaDTO> findFullBook(Long id) {
        logger.info("Buscando um livro da biblia com todos os capitulos e versiculos BibliaService - findFullBook - id = {}", id);
        List<Biblia> livro = jpql.findBookById(id);
        BibliaDTO dto = new BibliaDTO();
        return dto.convertPtBrToDtoList(livro);
    }
}