// src/main/java/com/estoque/controle/controllers/LoginController.java
package com.estoque.controle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }
}