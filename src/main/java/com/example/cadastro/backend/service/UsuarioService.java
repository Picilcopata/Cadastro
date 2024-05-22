package com.example.cadastro.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cadastro.backend.entity.Usuario;
import com.example.cadastro.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }
}
