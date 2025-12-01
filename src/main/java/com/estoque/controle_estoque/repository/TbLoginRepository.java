package com.estoque.controle_estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.controle_estoque.model.TbLogin;

@Repository
public interface TbLoginRepository extends JpaRepository<TbLogin, Long> {

    Optional<TbLogin> findByEmail(String email);
    Optional<TbLogin> findByNmLogin(String nmLogin);

    boolean existsByEmail(String email);
}
