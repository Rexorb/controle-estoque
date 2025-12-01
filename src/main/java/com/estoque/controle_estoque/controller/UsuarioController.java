package com.estoque.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estoque.controle_estoque.dto.RegistroForm;
import com.estoque.controle_estoque.model.TbLogin;
import com.estoque.controle_estoque.model.TbUsuario;
import com.estoque.controle_estoque.service.LoginService;
import com.estoque.controle_estoque.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Exibe o formulário de registro
    @GetMapping("/registro")
    public String exibirFormularioRegistro(Model model) {
        model.addAttribute("registroForm", new RegistroForm());
        return "registro";
    }

    // Processa o cadastro de nova conta
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute RegistroForm registroForm, 
                                   RedirectAttributes redirectAttributes) {
        try {
            // Verifica se o email já está cadastrado
            if (loginService.existePorEmail(registroForm.getDsEmail())) { 
                redirectAttributes.addFlashAttribute("mensagemErro", 
                    "Este email já está cadastrado no sistema.");
                return "redirect:/registro";
            }

            // Cria o Login com senha criptografada
            TbLogin login = new TbLogin(); 
            login.setEmail(registroForm.getDsEmail());
            login.setPassword(passwordEncoder.encode(registroForm.getDsSenha()));
            loginService.salvar(login);

            // Cria o Usuário
            TbUsuario usuario = new TbUsuario(); 
            usuario.setNmFantasia(registroForm.getNmFantasia());
            

            // associa login ao usuário
            usuario.setLogin(login);
            usuarioService.salvar(usuario);

            // Atualiza a referência bidirecional — usa o setter correto
            // (o nome do método deve existir na sua entidade TbLogin)
            login.setUsuario(usuario);
            loginService.salvar(login);

            redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Conta criada com sucesso! Faça login para continuar.");
            return "redirect:/login";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", 
                "Erro ao criar conta. Tente novamente.");
            return "redirect:/registro";
        }
    }

    // Página de Dashboard (após login)
    @GetMapping("/dashboard")
    public String exibirDashboard(Model model) {
        long totalUsuarios = usuarioService.contarUsuarios();
        long usuariosAtivos = usuarioService.contarUsuariosAtivos();
        
        model.addAttribute("totalUsuarios", totalUsuarios);
        model.addAttribute("usuariosAtivos", usuariosAtivos);
        
        return "dashboard";
    }
}
