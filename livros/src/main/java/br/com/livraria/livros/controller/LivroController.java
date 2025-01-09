package br.com.livraria.livros.controller;

import br.com.livraria.livros.model.Livro;
import br.com.livraria.livros.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid Livro livro){
        Livro dados = livroService.cadastrar(livro);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<Livro>> listarLivro(@PageableDefault(size = 3, sort = "{id}") Pageable pageable){
        Page<Livro> dados = livroService.listar(pageable);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody @Valid Livro livroAtualizado){
        Livro dados = livroService.localizar(id);
        if (dados == null){
            return ResponseEntity.notFound().build();
        }

        Livro dadosAtualizado = livroService.atualizar(id, livroAtualizado);
        return ResponseEntity.ok(dadosAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        Livro dados = livroService.localizar(id);
        if (dados == null){
            return ResponseEntity.notFound().build();
        }

        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
