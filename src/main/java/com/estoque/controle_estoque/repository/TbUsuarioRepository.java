package com.estoque.controle_estoque.repository;

import java.util.List; 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.controle_estoque.model.TbLogin; 
import com.estoque.controle_estoque.model.TbUsuario;

@Repository
public interface TbUsuarioRepository extends JpaRepository<TbUsuario, Long> {

    // Verifica se existe usuário com o CNPJ
    boolean existsByCdCnpj(String cdCnpj);

    // Busca usuário por CNPJ
    Optional<TbUsuario> findByCdCnpj(String cdCnpj);

    // Para campos booleanos o nome deve ser exatamente igual ao atributo!
long countByIdStatusTrue();
List<TbUsuario> findByIdStatusTrue();

    // Busca usuário usando o relacionamento com TbLogin
    Optional<TbUsuario> findByLogin(TbLogin login);
}
