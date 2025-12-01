package com.estoque.controle_estoque.service;

import java.util.List;
import java.util.Optional; // <<<< NOVO: Necessário para o método findById

import org.springframework.stereotype.Service;

import com.estoque.controle_estoque.model.Produto;
import com.estoque.controle_estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // Método ADICIONADO: Necessário para o método editarProduto no Controller
    public Optional<Produto> buscarPorId(Long id) {
        // O método findById é fornecido pelo JpaRepository e retorna um Optional<Produto>
        return repository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}