package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.service.EditoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/editoras")
public class EditoraController {

    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @PostMapping
    public ResponseEntity<Editora> salvar(@RequestBody Editora editora) {
        return ResponseEntity
                .status(201)
                .body(editoraService
                        .salvar(editora));

    }

    @GetMapping
    public ResponseEntity<List<Editora>> listaEditoras() {
        return ResponseEntity.ok(editoraService.listarLivros());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable("id") int id) {
        Optional<Editora> editoraEncontrado = editoraService.buscarPorId(id);
        if (editoraEncontrado.isPresent()) {
            return ResponseEntity.ok(editoraEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = {"", "/"}, params = "nome")
    public ResponseEntity<List<Editora>> findByAutorStartingWith(@RequestParam String nome) {
        return ResponseEntity.status(200).body(editoraService.findByNomeStartingWith(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLivro(@PathVariable("id") int id) {
        if (editoraService.excluirEditoraPorId(id)) {
            return ResponseEntity.status(204).build();
        }

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", "O editora com ID " + id + " não foi encontrado!");
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(404).body(erro);
    }

    @PutMapping
    public ResponseEntity<Editora> atualizarLivro(@RequestBody Editora editoraAtualizado) {

        Editora novaEditora = editoraService.atualizar(editoraAtualizado);
        if (novaEditora != null) {
            return ResponseEntity.status(200).body(novaEditora);
        }

        return ResponseEntity.status(404).build();
    }
}
