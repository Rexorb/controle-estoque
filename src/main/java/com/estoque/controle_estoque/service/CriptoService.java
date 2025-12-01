package com.estoque.controle_estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CriptoService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Criptografa uma senha usando BCrypt
     * @param senha A senha em texto plano
     * @return A senha criptografada
     */
    public String criptografar(String senha) {
        return passwordEncoder.encode(senha);
    }

    /**
     * Verifica se uma senha corresponde ao hash armazenado
     * @param senhaPlana A senha digitada pelo usuário
     * @param senhaCriptografada O hash armazenado no banco
     * @return true se a senha está correta, false caso contrário
     */
    public boolean verificar(String senhaPlana, String senhaCriptografada) {
        return passwordEncoder.matches(senhaPlana, senhaCriptografada);
    }
}