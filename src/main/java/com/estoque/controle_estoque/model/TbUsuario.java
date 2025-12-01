package com.estoque.controle_estoque.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class TbUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_status", nullable = false)
private boolean idStatus = true; // true = ativo, false = inativo

    @Column(name = "nm_fantasia", nullable = false, length = 200)
    private String nmFantasia;

    @Column(name = "cd_cnpj", nullable = false, unique = true, length = 18)
    private String cdCnpj;

    @Column(name = "dt_cadastro", nullable = false)
    private LocalDateTime dtCadastro;

    // Login do usuário (1:1)
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private TbLogin login;

    // Endereço único (1:1)
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private TbEndereco endereco;

    // Histórico de movimentações
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private java.util.List<TbMovimentacao> movimentacoes;

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }
}
