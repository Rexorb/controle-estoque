package com.estoque.controle_estoque.model;

import java.time.LocalDateTime;

import com.estoque.controle_estoque.enums.TipoMovimentacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_movimentacao")
@NoArgsConstructor
@AllArgsConstructor
public class TbMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao")
    private Long idMovimentacao;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private TbUsuario usuario;

    @Column(name = "dt_movimentacao", nullable = false)
    private LocalDateTime dtMovimentacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_movimentacao", nullable = false)
    private TipoMovimentacao tipoMovimentacao;

    @Column(name = "qt_alterada", nullable = false)
    private Integer qtAlterada;

    @Column(name = "ds_motivo", length = 255)
    private String dsMotivo;

    @PrePersist
    public void prePersist() {
        if (dtMovimentacao == null) dtMovimentacao = LocalDateTime.now();
    }
}
