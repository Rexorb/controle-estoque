package com.estoque.controle_estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroForm {
    
    // Dados da Empresa (tb_usuario)
    private String nmFantasia;
    private String cdCnpj;
    
    // Dados de Login (tb_login)
    private String nmLogin;
    private String dsEmail;
    private String dsSenha;
    
    // Dados de Endereço (tb_endereco)
    private String cdCep;
    private String nmRua;
    private String nrLogradouro;
    private String dsComplemento;
    private String nmBairro;
    private String nmCidade;
    private String sgEstado;
    private String nrTelefone;
}