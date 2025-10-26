package com.estoque.controle_estoque.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Usuario
 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String nome;
    private final boolean status;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "login_id")
    private Login login;
}
