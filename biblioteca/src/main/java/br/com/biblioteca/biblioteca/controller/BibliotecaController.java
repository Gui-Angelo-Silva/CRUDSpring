package br.com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @GetMapping
    public String home(Model model) {
        return "/home";
    }
    
    
}
