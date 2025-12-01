package com.estoque.controle_estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
@NoArgsConstructor
@AllArgsConstructor
public class TbEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long idEndereco;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private TbUsuario usuario;

    @Column(name = "cd_cep", nullable = false, length = 9)
    private String cdCep;

    @Column(name = "nm_rua", nullable = false, length = 200)
    private String nmRua;

    @Column(name = "nr_logradouro", nullable = false, length = 10)
    private String nrLogradouro;

    @Column(name = "ds_complemento", length = 100)
    private String dsComplemento;

    @Column(name = "nm_bairro", nullable = false, length = 100)
    private String nmBairro;

    @Column(name = "nm_cidade", nullable = false, length = 100)
    private String nmCidade;

    @Column(name = "sg_estado", nullable = false, length = 2)
    private String sgEstado;

    @Column(name = "nr_telefone", length = 15)
    private String nrTelefone;
}
