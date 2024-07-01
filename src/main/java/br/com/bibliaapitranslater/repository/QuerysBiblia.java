package br.com.bibliaapitranslater.repository;

import br.com.bibliaapitranslater.DTO.BibliaDTO;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class QuerysBiblia {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public List<BibliaDTO> consultaPeloIdLivro(Long id) {
        String jpql =
                "select l.id_livro idlivro, l.nome, l.abreviatura, l.testamento, l.numero_livro numerolivro, " +
                "c.numero_capitulo numerocapitulo, " +
                "v.numero_versiculo numerovesiculo, v.versiculo " +
                "from public.livro l " +
                "inner join public.capitulo c on l.id_livro = c.id_livro " +
                "inner join public.versiculo v on c.id_capitulo = v.id_capitulo " +
                "where l.id_livro = :id";

        Query query = manager.createNativeQuery(jpql);
        query.setParameter("id", id);

        List<Object[]> queryResp = query.getResultList();

        String[] columns = {"idlivro","nome","abreviatura","testamento",
                "numerolivro", "numerocapitulo", "numerovesiculo", "versiculo"};

        List<Map<String,String>> dataList = new ArrayList<>();
        List<BibliaDTO> listaBiblia = new ArrayList<>();

        for(Object[] obj : queryResp) {
            Map<String,String> row = new HashMap<>(columns.length);
            for(int i=0; i<columns.length; i++) {
                if(obj[i]!=null) {
                    row.put(columns[i], obj[i].toString());
                }
                else
                    row.put(columns[i], "");
            }
            dataList.add(row);
        }

        for (Map<String, String> stringStringMap : dataList) {
            BibliaDTO dto = getBibliaDTO(stringStringMap);
            listaBiblia.add(dto);
        }
        return listaBiblia;
    }

    private static BibliaDTO getBibliaDTO(Map<String, String> stringStringMap) {
        BibliaDTO dto = new BibliaDTO();
        dto.setIdLivro(stringStringMap.get("idlivro"));
        dto.setNome(stringStringMap.get("nome"));
        dto.setAbreviatura(stringStringMap.get("abreviatura"));
        dto.setTestamento(stringStringMap.get("testamento"));
        dto.setNumeroLivro(stringStringMap.get("numerolivro"));
        dto.setNumeroCapitulo(stringStringMap.get("numerocapitulo"));
        dto.setNumeroVersiculo(stringStringMap.get("numerovesiculo"));
        dto.setVersiculo(stringStringMap.get("versiculo"));
        return dto;
    }
}