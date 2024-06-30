package br.com.bibliaapitranslater.controller;

import br.com.bibliaapitranslater.model.Capitulo;
import br.com.bibliaapitranslater.service.CapituloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/capitulos")
public class CapituloController {

    private static final Logger logger = LoggerFactory.getLogger(CapituloController.class);

    private final CapituloService capituloService;

    @Autowired
    public CapituloController(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    @GetMapping
    public List<Capitulo> getAllChapters() {
        logger.info("Buscando todos os Capitulos CapituloController - getAllChapters");
        return capituloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capitulo> getChapterById(@PathVariable Long id) {
        logger.info("Buscando Capitulo pelo id: {} CapituloController - getChapterById", id);
        Optional<Capitulo> chapter = capituloService.findById(id);
        return chapter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}