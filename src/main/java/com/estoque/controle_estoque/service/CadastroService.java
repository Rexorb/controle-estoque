package com.estoque.controle_estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estoque.controle_estoque.dto.RegistroForm;
import com.estoque.controle_estoque.model.TbEndereco;
import com.estoque.controle_estoque.model.TbLogin;
import com.estoque.controle_estoque.model.TbUsuario;
import com.estoque.controle_estoque.repository.TbEnderecoRepository;
import com.estoque.controle_estoque.repository.TbLoginRepository;
import com.estoque.controle_estoque.repository.TbUsuarioRepository;

@Service
public class CadastroService {

    @Autowired
    private TbUsuarioRepository usuarioRepository;

    @Autowired
    private TbLoginRepository loginRepository;

    @Autowired
    private TbEnderecoRepository enderecoRepository;

    @Autowired
    private CriptoService criptoService;

    public String validarCadastro(RegistroForm dto) {

        if (usuarioRepository.existsByCdCnpj(dto.getCdCnpj())) {
            return "CNPJ já cadastrado no sistema.";
        }

        if (loginRepository.existsByEmail(dto.getDsEmail())) {
            return "E-mail já cadastrado no sistema.";
        }

        return null;
    }

    @Transactional
    public TbUsuario criarConta(RegistroForm dto) {

        // CRIA USUÁRIO
        TbUsuario usuario = new TbUsuario();
        usuario.setNmFantasia(dto.getNmFantasia());
        usuario.setCdCnpj(dto.getCdCnpj());

        // SALVA USUÁRIO PRIMEIRO PARA GERAR ID
        usuario = usuarioRepository.save(usuario);

        // CRIA LOGIN
        String senhaHash = criptoService.criptografar(dto.getDsSenha());

        TbLogin login = new TbLogin();
        login.setNmLogin(dto.getNmLogin()); // <--- ESSENCIAL
        login.setEmail(dto.getDsEmail());
        login.setPassword(senhaHash);
        login.setUsuario(usuario);

        // RELACIONA LOGIN AO USUÁRIO
        usuario.setLogin(login);

        // SALVA USUÁRIO E LOGIN (cascade salva login automaticamente)
        usuarioRepository.save(usuario);

        // CRIA ENDEREÇO
        TbEndereco endereco = new TbEndereco();
        endereco.setUsuario(usuario);
        endereco.setCdCep(dto.getCdCep());
        endereco.setNmRua(dto.getNmRua());
        endereco.setNrLogradouro(dto.getNrLogradouro());
        endereco.setDsComplemento(dto.getDsComplemento());
        endereco.setNmBairro(dto.getNmBairro());
        endereco.setNmCidade(dto.getNmCidade());
        endereco.setSgEstado(dto.getSgEstado());
        endereco.setNrTelefone(dto.getNrTelefone());

        enderecoRepository.save(endereco);

        return usuario;
    }
}
