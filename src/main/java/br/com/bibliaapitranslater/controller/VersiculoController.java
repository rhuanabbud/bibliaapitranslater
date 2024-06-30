package br.com.bibliaapitranslater.controller;

import br.com.bibliaapitranslater.model.Versiculo;
import br.com.bibliaapitranslater.service.VersiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/versiculos")
public class VersiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VersiculoController.class);

    private final VersiculoService versiculoService;

    @Autowired
    public VersiculoController(VersiculoService versiculoService) {
        this.versiculoService = versiculoService;
    }

    @GetMapping
    public List<Versiculo> getAllVerses() {
        logger.info("Buscando todos os Versiculos VersiculoController - getAllVerses");
        return versiculoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Versiculo> getVerseById(@PathVariable Long id) {
        logger.info("Buscando Versiculo pelo id: {} VersiculoController - getVerseById", id);
        Optional<Versiculo> verse = versiculoService.findById(id);
        return verse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}