package br.com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.biblioteca.entity.Genero;

public interface  GeneroRepository extends JpaRepository<Genero, Long> {
    
}
