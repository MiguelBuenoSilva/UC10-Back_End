package br.senac.sp.livraria.repository;

import br.senac.sp.livraria.model.Editora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EditoraRepository  extends JpaRepository<Editora,Integer> {

    List<Editora> findByNomeStartingWith(String nome);

    @Query("SELECT e FROM Editora e WHERE e.id =:id")
    Optional<Editora> buscarPorId(@Param("id") int id);

}
