package com.estoque.controle_estoque.service;

import java.util.List;

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

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
