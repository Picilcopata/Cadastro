package com.example.cadastro.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 4, message = "O nome deve ter no mínimo 4 caracteres!")
    @NotBlank(message = "O nome é obrigatório!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email(message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable =  false)
    private String senha;

    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;
}
