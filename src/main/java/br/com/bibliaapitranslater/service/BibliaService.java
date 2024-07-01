package br.com.bibliaapitranslater.service;

import br.com.bibliaapitranslater.model.Biblia;
import br.com.bibliaapitranslater.repository.BibliaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliaService {

    private static final Logger logger = LoggerFactory.getLogger(BibliaService.class);

    private final BibliaRepository bibliaRepository;

    @Autowired
    public BibliaService(BibliaRepository bibliaRepository) {
        this.bibliaRepository = bibliaRepository;
    }

    public List<Biblia> findFullBook(Long id) {
        logger.info("Buscando um livro da biblia com todos os capitulos e versiculos BibliaService - findFullBook");
        return bibliaRepository.findFullBook(id);
    }
}