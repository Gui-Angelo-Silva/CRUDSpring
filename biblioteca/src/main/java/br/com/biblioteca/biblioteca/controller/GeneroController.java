package br.com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.biblioteca.biblioteca.entity.Genero;
import br.com.biblioteca.biblioteca.service.GeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroService service;
    
    @GetMapping("/listar")
    public String listar(Model model) {
        // Busca todos os livros
        List<Genero> generos = service.findAll();
        // Adiciona os livros ao modelo
        model.addAttribute("generos", generos);
        // Retorna a página de lista de livros
        return "genero/lista";
    }

    // Método para abrir o formulário de criação de livro
    @GetMapping("/criar")
    public String criarForm(Model model) {
        // Adiciona um novo livro ao modelo
        model.addAttribute("genero", new Genero());
        // Retorna a página do formulário de livros
        return "genero/form";
    }

    // Método para salvar um livro
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Genero genero) {
        // Salva o livro
        service.save(genero);
        // Redireciona para a lista de livros
        return "redirect:/generos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/generos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Genero genero = service.findById(id);
        model.addAttribute("genero", genero);

        return "genero/form";
    }
}
