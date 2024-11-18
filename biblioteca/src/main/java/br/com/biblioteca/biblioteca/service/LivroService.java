package br.com.biblioteca.biblioteca.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.biblioteca.biblioteca.entity.Livro;
import br.com.biblioteca.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    // Método para salvar um livro
    public Livro save(Livro livro) {
        return repository.save(livro);
    }

    // Método para listar os livros
    public List<Livro> findAll() {
        return repository.findAll();
    }

    // Método para listar apenas um livro
    public Livro findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Método para Excluir um Livro
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}