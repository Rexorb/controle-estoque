package com.estoque.controle_estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estoque.controle_estoque.model.Login;
import com.estoque.controle_estoque.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    public Optional<Usuario> getUserByLogin(@Param("login") Login login);
}
