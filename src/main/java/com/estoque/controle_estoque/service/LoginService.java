package com.estoque.controle_estoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.controle_estoque.model.TbLogin;
import com.estoque.controle_estoque.repository.TbLoginRepository;

@Service
public class LoginService {

    @Autowired
    private TbLoginRepository loginRepository;

    public TbLogin salvar(TbLogin login) {
        return loginRepository.save(login);
    }

    public Optional<TbLogin> buscarPorEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    public boolean existePorEmail(String email) {
        return loginRepository.existsByEmail(email);
    }

    public void deletar(Long id) {
        loginRepository.deleteById(id);
    }

    // Método usado no ProdutoViewController
    public TbLogin findLoginByEmail(String email) {
        return loginRepository.findByEmail(email).orElse(null);
    }
}