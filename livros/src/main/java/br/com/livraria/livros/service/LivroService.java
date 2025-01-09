package br.com.livraria.livros.service;

import br.com.livraria.livros.model.Livro;
import br.com.livraria.livros.repository.LivrosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivrosRepository livrosRepository;

    @Autowired
    public LivroService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public Livro cadastrar(Livro livro){
        return livrosRepository.save(livro);
    }

    public Page<Livro> listar (Pageable pageable){
        return livrosRepository.findAll(pageable);
    }

    public Livro localizar(Long id){
        return livrosRepository.findById(id).orElse(null);
    }

    public Livro atualizar(Long id, Livro livro){
        Livro dados = livrosRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Livro não encontrado"));
        dados.setNome(livro.getNome());
        dados.setAutor(livro.getAutor());
        dados.setEditora(livro.getEditora());
        dados.setPreco(livro.getPreco());

        return livrosRepository.save(dados);
    }

    public void deletar(Long id){
       livrosRepository.deleteById(id);
    }
}
