package br.senac.sp.livraria.repository;


import br.senac.sp.livraria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository  extends JpaRepository<Categoria,Integer> {


    List<Categoria> findByNomeStartingWith(String nome);

    @Query("SELECT c FROM Categoria c WHERE c.id =:id")
    Optional<Categoria> buscarPorId(@Param("id") int id);
}
