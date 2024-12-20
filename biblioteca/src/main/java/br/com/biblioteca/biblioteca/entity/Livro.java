package br.com.biblioteca.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivro;

    @Column(nullable = false, length = 40)
    private String nomeLivro;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false) // A chave estrangeira do gênero
    private Genero generoLivro;  // Tipo de dado alterado para 'Genero' em vez de 'String'
}