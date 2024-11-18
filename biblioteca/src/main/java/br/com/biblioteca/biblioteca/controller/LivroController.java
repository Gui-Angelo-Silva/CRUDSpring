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

import br.com.biblioteca.biblioteca.entity.Livro;
import br.com.biblioteca.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    // Método para listar todos os livros
    @GetMapping("/listar")
    public String listar(Model model) {
        // Busca todos os livros
        List<Livro> livros = service.findAll();
        // Adiciona os livros ao modelo
        model.addAttribute("livros", livros);
        // Retorna a página de lista de livros
        return "livro/lista";
    }

    // Método para abrir o formulário de criação de livro
    @GetMapping("/criar")
    public String criarForm(Model model) {
        // Adiciona um novo livro ao modelo
        model.addAttribute("livro", new Livro());
        // Retorna a página do formulário de livros
        return "livro/form";
    }

    // Método para salvar um livro
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro) {
        // Salva o livro
        service.save(livro);
        // Redireciona para a lista de livros
        return "redirect:/livros/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/livros/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Livro livro = service.findById(id);
        model.addAttribute("livro", livro);

        return "livro/form";
    }
    
}