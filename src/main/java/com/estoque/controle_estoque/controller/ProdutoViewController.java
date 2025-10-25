package com.estoque.controle_estoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.estoque.controle_estoque.service.ProdutoService;

@Controller
public class ProdutoViewController {

    private final ProdutoService service;

    public ProdutoViewController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping({"/", "/produtos/listar", "/produtos/view"}) // <-- CORREÇÃO AQUI
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "listar";
    }

    // ✅ Método de teste
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
