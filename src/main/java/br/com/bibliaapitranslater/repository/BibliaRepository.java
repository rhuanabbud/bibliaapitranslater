package br.com.bibliaapitranslater.repository;

import br.com.bibliaapitranslater.model.Biblia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliaRepository extends JpaRepository<Biblia, Long> {
}