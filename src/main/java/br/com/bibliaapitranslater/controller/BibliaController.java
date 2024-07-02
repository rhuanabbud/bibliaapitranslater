package br.com.bibliaapitranslater.controller;

import br.com.bibliaapitranslater.DTO.BibliaDTO;
import br.com.bibliaapitranslater.service.BibliaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/biblia")
public class BibliaController {

    private static final Logger logger = LoggerFactory.getLogger(BibliaController.class);

    private final BibliaService bibliaService;

    @Autowired
    public BibliaController(BibliaService bibliaService) {
        this.bibliaService = bibliaService;
    }

    @GetMapping("getFullBookById/{id}")
    public ResponseEntity<List<BibliaDTO>> getFullBook(@PathVariable Long id) {
        logger.info("Buscando um livro da biblia com todos os capitulos e versiculos BibliaController - getFullBook - id = {}", id);

        List<BibliaDTO> lista = bibliaService.findFullBook(id);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("getFullBookByNumero/{numeroLivro}")
    public ResponseEntity<List<BibliaDTO>> getFullBook(@PathVariable int numeroLivro) {
        logger.info("Buscando um livro da biblia com todos os capitulos e versiculos BibliaController " +
                "- getFullBook - numeroLivro = {}", numeroLivro);

        List<BibliaDTO> lista = bibliaService.findFullBook(numeroLivro);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }
}