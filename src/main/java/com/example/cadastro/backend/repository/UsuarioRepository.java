package com.example.cadastro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
}
