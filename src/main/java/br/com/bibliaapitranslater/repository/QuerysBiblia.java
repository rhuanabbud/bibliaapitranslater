package br.com.bibliaapitranslater.repository;

import br.com.bibliaapitranslater.model.Biblia;
import br.com.bibliaapitranslater.service.BibliaService;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class QuerysBiblia {

    private static final Logger logger = LoggerFactory.getLogger(BibliaService.class);

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public List<Biblia> findBookById(Long id) {
        logger.info("Buscando um livro da biblia com todos os capitulos e versiculos QuerysBiblia - findBookById - id = {}", id);
        String jpql =
                "select l.id_livro idlivro, l.nome, l.abreviatura, l.testamento, l.numero_livro numerolivro, " +
                        "c.numero_capitulo numerocapitulo, " +
                        "v.numero_versiculo numeroversiculo, v.versiculo " +
                        "from public.livro l " +
                        "inner join public.capitulo c on l.id_livro = c.id_livro " +
                        "inner join public.versiculo v on c.id_capitulo = v.id_capitulo " +
                        "where l.id_livro = :id";

        Query query = manager.createNativeQuery(jpql, "BibliaSelectValue");
        query.setParameter("id", id);
        return (List<Biblia>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Biblia> findBookById(int numeroLivro) {
        logger.info("Buscando um livro da biblia com todos os capitulos e versiculos QuerysBiblia - findBookById " +
                "- numeroLivro = {}", numeroLivro);
        String jpql =
                "select l.id_livro idlivro, l.nome, l.abreviatura, l.testamento, l.numero_livro numerolivro, " +
                        "c.numero_capitulo numerocapitulo, " +
                        "v.numero_versiculo numeroversiculo, v.versiculo " +
                        "from public.livro l " +
                        "inner join public.capitulo c on l.id_livro = c.id_livro " +
                        "inner join public.versiculo v on c.id_capitulo = v.id_capitulo " +
                        "where l.numero_livro = :numeroLivro";

        Query query = manager.createNativeQuery(jpql, "BibliaSelectValue");
        query.setParameter("numeroLivro", numeroLivro);
        return (List<Biblia>) query.getResultList();
    }
}