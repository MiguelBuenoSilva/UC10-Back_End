package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// POST http://localhost:8080/v1/api/livros
// GET  http://localhost:8080/v1/api/livros

@RestController
@RequestMapping("/v1/api/livros")
@Tag(name = "Livros", description = "API responsável por gerenciar os livros da editora .Com essa API será possível inserir, atualizar, listar e excluir livros do sistema.")
public class LivroController {

    //injeção de indenpendecia
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    @Operation(
            summary = "Cadastrar novos livros",
            description = "Criar registro de novos livros no sistema."
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Livro cadastro com sucesso!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Dados de entrada inválidos.",
                            content = @Content
                    )
            }
    )
    public ResponseEntity<Livro> salvar(@Valid @RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);
        return ResponseEntity.status(201).body(novoLivro);

    }

    @GetMapping
    @Operation(summary = "Listar todos os livros do sistema.")
    public ResponseEntity<List<Livro>> listaLivros() {
        return ResponseEntity.ok(livroService.listarLivros());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable("id") int id) {
        Optional<Livro> livroEncontrado = livroService.buscarPorId(id);
        if (livroEncontrado.isPresent()) {
            return ResponseEntity.ok(livroEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ano-edicao")
    public ResponseEntity<List<Livro>> findByAnoEdicaoLessThan(@RequestParam("anoEdicao") int anoEdicao) {

        return ResponseEntity.status(200).body(livroService.findByAnoEdicaoLessThan(anoEdicao));

    }

    @GetMapping("/autor")
    public ResponseEntity<List<Livro>> findByAutorStartingWith(@RequestParam("autor") String autor) {
        return ResponseEntity.status(200).body(livroService.findByAutorStartingWith(autor));
    }

    @GetMapping("/faixa-preco")
    @Operation(
            summary = "Lista de livros por faixa de preço",
            description = "Listar livros que estejam por uma faixa de preços.Exemplo: Listar todos os livros que custam $10,00 e $300,00"
    )
    public ResponseEntity<List<Livro>> listarPrecoPor
            (
                    @Parameter(name = "valorInicial", description = "Informe o valor inicial da faixa de preços que você deseja consultar", example = "10")
                    @RequestParam("valorInicial")
                    double valorInicial,
                    @Parameter(name = "valorFinal", description = "Informe o valor final da faixa de preços que você deseja consultar", example = "200")
                    @RequestParam("valorFinal")
                    double valorFinal) {
        return ResponseEntity.status(200).body(livroService.listarPrecoDeLivro(valorInicial, valorFinal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLivro(@PathVariable("id") int id) {
        if (livroService.excluirLivroPorId(id)) {
            return ResponseEntity.status(204).build();
        }

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", "O livro com ID " + id + " não foi encontrado!");
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(404).body(erro);
    }

    @PutMapping
    @Operation(
            method = "PUT",
            summary = "Atualizar dados de um livro",
            description = "Este endpoint é utilidado para atualizar os dados de um livro. Para encontrar o livro será atualizado a busca será efetuada através do ID"
    )
    public ResponseEntity<Livro> atualizarLivro(@RequestBody Livro livroAtualizado) {
        Livro novoLivro = livroService.atualizar(livroAtualizado);
        if (novoLivro != null) {
            return ResponseEntity.status(200).body(novoLivro);
        }

        return ResponseEntity.status(404).build();
    }

}

