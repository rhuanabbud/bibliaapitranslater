package br.com.bibliaapitranslater.controller;

import br.com.bibliaapitranslater.model.Livro;
import br.com.bibliaapitranslater.service.LivroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private static final Logger logger = LoggerFactory.getLogger(LivroController.class);

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getAllBooks() {
        logger.info("Buscando todos os livros LivroController - getAllBooks");
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getBookById(@PathVariable Long id) {
        logger.info("Buscando livro pelo id: {} LivroController - getBookById", id);
        Optional<Livro> book = livroService.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}