package com.estoque.controle_estoque.service;

import org.springframework.stereotype.Service;

import com.estoque.controle_estoque.model.Login;
import com.estoque.controle_estoque.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public Login findLoginByEmail(String email){
        return loginRepository.findByEmail(email).orElse(null);
    }
}
