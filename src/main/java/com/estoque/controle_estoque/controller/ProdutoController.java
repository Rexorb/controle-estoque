package com.estoque.controle_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estoque.controle_estoque.model.Produto;
import com.estoque.controle_estoque.service.ProdutoService;

@Controller
@RequestMapping("/produtos") // Define o prefixo de URL: /produtos
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // 1. Rota de Listagem (GET /produtos)
    // Exibe a tela listar.html
    @GetMapping
    public String listarProdutos(Model model) {
        // Busca todos os produtos do banco de dados (PostgreSQL)
        model.addAttribute("produtos", produtoService.listarTodos());
        return "listar"; // Retorna o template 'listar.html'
    }

    // 2. Rota de Formulário (GET /produtos/novo)
    // Exibe a tela de cadastro.html
    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        // Cria um objeto Produto vazio para ser preenchido pelo formulário no Thymeleaf
        model.addAttribute("produto", new Produto());
        return "produtos/cadastro"; // Retorna o template 'templates/produtos/cadastro.html'
    }

    // 3. Rota de Salvar (POST /produtos/salvar)
    // Processa os dados enviados pelo formulário
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        // O Spring preenche o objeto 'produto' com os dados do formulário
        produtoService.salvar(produto);
        
        // Redireciona o usuário de volta para a tela de listagem
        return "redirect:/produtos";
    }
// 4. Rota de Edição (GET /produtos/editar/{id}) <<< NOVO
    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de produto inválido:" + id));

        model.addAttribute("produto", produto);
        return "produtos/editar"; 
    }
    // 5. Rota de Exclusão (GET /produtos/excluir/{id}) <<< NOVO
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        produtoService.deletar(id);
        return "redirect:/produtos";
    }
    // 6. Rota de Detalhes (GET /produtos/detalhes/{id}) <<< NOVO
    // Exibe a tela de detalhes completos do produto
    @GetMapping("/detalhes/{id}")
    public String exibirDetalhesProduto(@PathVariable("id") Long id, Model model) {
        // Usa o ProdutoService para buscar o produto
        Produto produto = produtoService.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de produto inválido:" + id));

        // Adiciona o produto ao Model para ser exibido no template
        model.addAttribute("produto", produto);
        
        // Retorna o template de detalhes
        return "produtos/detalhes"; 
    }
    
}