package com.estoque.controle_estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_login")
public class TbLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login")
    private Long idLogin;

    @Column(name = "nm_login", nullable = false, unique = true)
    private String nmLogin;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "ds_senha_hash", nullable = false) // <-- corrigido
    private String password;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private TbUsuario usuario;

    public TbLogin() {}

    public Long getIdLogin() { return idLogin; }
    public void setIdLogin(Long idLogin) { this.idLogin = idLogin; }

    public String getNmLogin() { return nmLogin; }
    public void setNmLogin(String nmLogin) { this.nmLogin = nmLogin; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public TbUsuario getUsuario() { return usuario; }
    public void setUsuario(TbUsuario usuario) { this.usuario = usuario; }
}
