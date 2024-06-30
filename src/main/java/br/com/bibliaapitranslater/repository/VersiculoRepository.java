package br.com.bibliaapitranslater.repository;

import br.com.bibliaapitranslater.model.Versiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersiculoRepository extends JpaRepository<Versiculo, Long> {
}