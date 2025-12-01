package com.estoque.controle_estoque.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estoque.controle_estoque.model.TbLogin;
import com.estoque.controle_estoque.model.TbUsuario;
import com.estoque.controle_estoque.service.CriptoService;
import com.estoque.controle_estoque.service.LoginService;
import com.estoque.controle_estoque.service.ProdutoService;
import com.estoque.controle_estoque.service.UsuarioService;
import com.estoque.controle_estoque.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProdutoViewController {

    private final ProdutoService service;
    private final LoginService loginService;
    private final UsuarioService usuarioService;
    private final CriptoService criptoService;

    @GetMapping({"/", "/produtos/listar", "/produtos/view"})
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "listar";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> UserLogin(@RequestBody TbLogin entity) {
        // Validação correta de Strings (usando isEmpty() ou isBlank())
        if(entity.getEmail() == null || entity.getEmail().trim().isEmpty()
        || entity.getPassword() == null || entity.getPassword().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados insuficientes");
        }
        
        TbLogin mached = loginService.findLoginByEmail(entity.getEmail());
        
        if(mached == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário inexistente");
        }
        
        boolean ValidLogin = criptoService.verificar(entity.getPassword(), mached.getPassword());
        
        if(ValidLogin){
            TbUsuario usuario = usuarioService.getUserByLogin(mached);

            if(usuario != null){
                String token = JwtUtil.GeraToken(usuario.getNmFantasia(), mached.getEmail());
                return ResponseEntity.ok().body(token);
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro desconhecido");    
            }
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login ou senha inválidos");
        }
    }
}