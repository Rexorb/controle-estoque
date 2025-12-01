package com.estoque.controle_estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.controle_estoque.model.TbLogin;
import com.estoque.controle_estoque.model.TbUsuario; // CORRIGIDO
import com.estoque.controle_estoque.repository.TbUsuarioRepository; // CORRIGIDO

@Service
public class UsuarioService {

    @Autowired
    private TbUsuarioRepository usuarioRepository; // CORRIGIDO

    public TbUsuario salvar(TbUsuario usuario) { // CORRIGIDO
        return usuarioRepository.save(usuario);
    }

    public List<TbUsuario> listarTodos() { // CORRIGIDO
        return usuarioRepository.findAll();
    }

// Mantenha este como estava (se o retorno for Optional)
public Optional<TbUsuario> buscarPorId(Long id) {
    return usuarioRepository.findById(id);
}

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public long contarUsuarios() {
        return usuarioRepository.count();
    }

  public long contarUsuariosAtivos() {
    return usuarioRepository.countByIdStatusTrue(); // CORRIGIDO
}

 public List<TbUsuario> listarUsuariosAtivos() {
    return usuarioRepository.findByIdStatusTrue(); // CORRIGIDO
}



    // Método usado no ProdutoViewController
    public TbUsuario getUserByLogin(TbLogin login) { // CORRIGIDO
        return usuarioRepository.findByLogin(login).orElse(null);
    }
}