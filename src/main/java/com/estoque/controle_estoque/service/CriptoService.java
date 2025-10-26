package com.estoque.controle_estoque.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CriptoService {
    private final PasswordEncoder passwordEncoder;

    public CriptoService(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    public String encodificar(String texto) {
        return passwordEncoder.encode(texto);
    }

    public boolean verificar(String texto, String hash) {
        return passwordEncoder.matches(texto, hash);
    }
}
