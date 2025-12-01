package com.estoque.controle_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.controle_estoque.model.TbEndereco;

@Repository
public interface TbEnderecoRepository extends JpaRepository<TbEndereco, Long> {
    // Métodos personalizados podem ser adicionados aqui se necessário
}