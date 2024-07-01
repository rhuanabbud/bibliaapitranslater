package br.com.bibliaapitranslater.repository;

import br.com.bibliaapitranslater.model.Biblia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliaRepository extends JpaRepository<Biblia, Long> {


    @Query(value = "select " +
            "l.id_livro, l.nome, l.abreviatura, l.testamento, l.numero_livro, " +
            "c.numero_capitulo, " +
            "v.numero_versiculo, v.versiculo " +
            "from public.livro l " +
            "inner join public.capitulo c on l.id_livro = c.id_livro " +
            "inner join public.versiculo v on c.id_capitulo = v.id_capitulo " +
            "where l.id_livro = ?", nativeQuery = true)
    List<Biblia> findFullBook(Long id);
}