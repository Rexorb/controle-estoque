package com.estoque.controle_estoque.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.estoque.controle_estoque.model.Login;
import com.estoque.controle_estoque.service.CriptoService;
import com.estoque.controle_estoque.service.LoginService;
import com.estoque.controle_estoque.service.ProdutoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class ProdutoViewController {

    private final ProdutoService service;
    private final LoginService loginService;
    private final CriptoService criptoService;


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

    @PostMapping("/user/login")
    public ResponseEntity<String> UserLogin(@RequestBody Login entity) {
        if(entity.getEmail() == null || entity.getEmail() == ""
        || entity.getPassword() == null || entity.getPassword() == ""){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados insuficientes");
        }
        Login mached = loginService.findLoginByEmail(entity.getEmail());
        if(mached == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário inexistente");
        }
        boolean ValidLogin = criptoService.verificar(entity.getPassword(), mached.getPassword());
        
        if(ValidLogin){
            return ResponseEntity.ok().body("Deu certo");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login ou senha inválidos");
        }
    }
    


}
