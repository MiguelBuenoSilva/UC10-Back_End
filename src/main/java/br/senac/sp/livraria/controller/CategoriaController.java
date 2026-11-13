package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        return ResponseEntity
                .status(201)
                .body(categoriaService
                        .salvar(categoria));

    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listaEditoras() {
        return ResponseEntity.ok(categoriaService.listarLivros());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") int id) {
        Optional<Categoria> editoraEncontrado = categoriaService.buscarPorId(id);
        if (editoraEncontrado.isPresent()) {
            return ResponseEntity.ok(editoraEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = {"", "/"}, params = "nome")
    public ResponseEntity<List<Categoria>> findByAutorStartingWith(@RequestParam String nome) {
        return ResponseEntity.status(200).body(categoriaService.findByNomeStartingWith(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLivro(@PathVariable("id") int id) {
        if (categoriaService.excluirCategoriaPorId(id)) {
            return ResponseEntity.status(204).build();
        }

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", "O editora com ID " + id + " não foi encontrado!");
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(404).body(erro);
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizarLivro(@RequestBody Categoria categoriaAtualizado) {

        Categoria novaCategoria = categoriaService.atualizar(categoriaAtualizado);
        if (novaCategoria != null) {
            return ResponseEntity.status(200).body(novaCategoria);
        }

        return ResponseEntity.status(404).build();
    }
}
