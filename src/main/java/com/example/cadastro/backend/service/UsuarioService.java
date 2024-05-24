package com.example.cadastro.backend.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cadastro.backend.entity.Usuario;
import com.example.cadastro.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private UsuarioRepository repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }
    
    public Usuario atualizarCadastro(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getReferenceById(usuario.getId()).getSenha();
        boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
