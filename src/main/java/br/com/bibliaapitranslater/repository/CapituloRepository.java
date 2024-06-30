package br.com.bibliaapitranslater.repository;

import br.com.bibliaapitranslater.model.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapituloRepository extends JpaRepository<Capitulo, Long> {
}