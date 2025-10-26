package com.estoque.controle_estoque.service;

import org.springframework.stereotype.Service;

import com.estoque.controle_estoque.model.Login;
import com.estoque.controle_estoque.model.Usuario;
import com.estoque.controle_estoque.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario getUserByLogin(Login login){
        return usuarioRepository.getUserByLogin(login).orElse(null);
    }
}
