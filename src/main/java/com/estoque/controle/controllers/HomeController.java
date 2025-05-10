package com.estoque.controle.controllers;  // Note o pacote correto

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao Sistema de Controle de Estoque");
        model.addAttribute("dataAtual", java.time.LocalDate.now());
        return "home/index";  // Isso vai procurar em templates/home/index.html
    }
}