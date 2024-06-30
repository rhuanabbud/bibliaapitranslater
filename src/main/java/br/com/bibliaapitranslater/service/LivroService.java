package br.com.bibliaapitranslater.service;

import br.com.bibliaapitranslater.model.Livro;
import br.com.bibliaapitranslater.repository.LivroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private static final Logger logger = LoggerFactory.getLogger(LivroService.class);

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll() {
        logger.info("Buscando todos os livros LivroService - findAll");
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        logger.info("Buscando livro pelo id: {} LivroService - findById", id);
        return livroRepository.findById(id);
    }
}