package com.example.cadastro.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.cadastro.backend.service.UsuarioService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;
    
    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> novoUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }

    @GetMapping("/listar")
    public ResponseEntity <List<Usuario>> listaUsuarios(){
        return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
    }

    @PutMapping("/atualizarCadastro")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
        Usuario novoUsuario = repo.save(usuario);
        return ResponseEntity.status(0).body(novoUsuario);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
