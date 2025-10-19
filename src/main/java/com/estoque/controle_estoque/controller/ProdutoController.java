package com.estoque.controle_estoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.estoque.controle_estoque.repository.ProdutoRepository;

@Controller
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/produtos")
    public String listar(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "listar";
    }
}
