package br.com.livraria.livros.repository;

import br.com.livraria.livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
