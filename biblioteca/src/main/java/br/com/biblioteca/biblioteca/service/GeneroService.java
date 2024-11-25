package br.com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.biblioteca.entity.Genero;
import br.com.biblioteca.biblioteca.repository.GeneroRepository;


@Service
public class GeneroService {
    
    @Autowired
    private GeneroRepository repository;

    // Método para salvar um Genero
    public Genero save(Genero genero) {
        return repository.save(genero);
    }

    // Método para listar os Generos
    public List<Genero> findAll() {
        return repository.findAll();
    }

    // Método para listar apenas um Genero
    public Genero findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Método para Excluir um Genero
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
