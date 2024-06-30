package br.com.bibliaapitranslater.service;

import br.com.bibliaapitranslater.model.Versiculo;
import br.com.bibliaapitranslater.repository.VersiculoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersiculoService {

    private static final Logger logger = LoggerFactory.getLogger(VersiculoService.class);

    private final VersiculoRepository versiculoRepository;

    @Autowired
    public VersiculoService(VersiculoRepository versiculoRepository) {
        this.versiculoRepository = versiculoRepository;
    }

    public List<Versiculo> findAll() {
        logger.info("Buscando todos os Versiculos VersiculoService - findAll");
        return versiculoRepository.findAll();
    }

    public Optional<Versiculo> findById(Long id) {
        logger.info("Buscando Versiculo pelo id: {} VersiculoService - findById", id);
        return versiculoRepository.findById(id);
    }
}