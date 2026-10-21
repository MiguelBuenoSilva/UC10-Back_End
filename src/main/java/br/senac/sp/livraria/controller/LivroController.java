package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import org.springframework.web.bind.annotation.*;

// POST http://localhost:8080/v1/api/livros
// GET  http://localhost:8080/v1/api/livros


@RestController
@RequestMapping("/v1/api/livros")
public class LivroController {

    @PostMapping
    public String salvar(@RequestBody Livro livro){
        System.out.println(livro.titulo());
        return "Você chamou o método para gravar um livro!";
    }

    @GetMapping
    public String listaLivros(){
        return "Você chamou o metodo para LISTAR um livro!";

    }

}

