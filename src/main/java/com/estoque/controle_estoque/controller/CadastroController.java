package com.estoque.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estoque.controle_estoque.dto.RegistroForm;
import com.estoque.controle_estoque.model.TbUsuario;
import com.estoque.controle_estoque.service.CadastroService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    /**
     * Exibe o formulário de cadastro completo
     */
    @GetMapping
    public String exibirFormularioCadastro(Model model) {

        // Envia um form vazio apenas se ainda não existir na sessão
        if (!model.containsAttribute("registroForm")) {
            model.addAttribute("registroForm", new RegistroForm());
        }

        return "cadastro-completo";
    }

    /**
     * Processa o cadastro completo
     */
    @PostMapping("/criar")
    public String criarConta(@ModelAttribute("registroForm") RegistroForm registroForm,
                             RedirectAttributes redirectAttributes) {

        try {
            // Validar dados
            String erro = cadastroService.validarCadastro(registroForm);
            if (erro != null) {
                redirectAttributes.addFlashAttribute("mensagemErro", erro);
                redirectAttributes.addFlashAttribute("registroForm", registroForm);
                return "redirect:/cadastro";
            }

            // Criar conta
            TbUsuario usuario = cadastroService.criarConta(registroForm);

            redirectAttributes.addFlashAttribute("mensagemSucesso",
                    "Conta criada com sucesso! Faça login para continuar.");

            return "redirect:/login";

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("mensagemErro",
                    "Erro ao criar conta: " + e.getMessage());
            redirectAttributes.addFlashAttribute("registroForm", registroForm);
            return "redirect:/cadastro";
        }
    }
}
