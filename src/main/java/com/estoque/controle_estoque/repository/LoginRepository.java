package com.estoque.controle_estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estoque.controle_estoque.model.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{

    @Query("SELECT  l FROM Login l WHERE l.email = :email")
    public Optional<Login> findByEmail(@Param("email") String email);
    
}
