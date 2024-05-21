package com.example.cadastro.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.backend.entity.Usuario;
import com.example.cadastro.backend.repository.UsuarioRepository;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @PostMapping("/cadastrar")
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return repo.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listaUsuarios(){
        return repo.findAll();
    }

    @PutMapping("/atualizarCadastro")
    public Usuario atualizar(@RequestBody Usuario usuario){
        Usuario novoUsuario = repo.save(usuario);
        return novoUsuario;
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id){
        repo.deleteById(id);
    }
}
