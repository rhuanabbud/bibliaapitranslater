package br.com.bibliaapitranslater.service;

import br.com.bibliaapitranslater.model.Capitulo;
import br.com.bibliaapitranslater.repository.CapituloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapituloService {

    private static final Logger logger = LoggerFactory.getLogger(CapituloService.class);

    private final CapituloRepository capituloRepository;

    @Autowired
    public CapituloService(CapituloRepository capituloRepository) {
        this.capituloRepository = capituloRepository;
    }

    public List<Capitulo> findAll() {
        logger.info("Buscando todos os Capitulos CapituloService - findAll");
        return capituloRepository.findAll();
    }

    public Optional<Capitulo> findById(Long id) {
        logger.info("Buscando Capitulo pelo id: {} CapituloService - findById", id);
        return capituloRepository.findById(id);
    }
}