package com.nando.demo_park_api.service;

import com.nando.demo_park_api.entity.Usuario;
import com.nando.demo_park_api.repository.UsuarioRepository;
import com.nando.demo_park_api.web.dto.UsuarioCreateDTO;
import com.nando.demo_park_api.web.dto.UsuarioResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final  UsuarioRepository usuarioRepository;


    @Transactional
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorID(Long id) {

        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado")
        );
    }


    @Transactional
    public Usuario editarSenha(Long id, String password) {

        Usuario user = buscarPorID(id);
        user.setPassword(password);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {

        return usuarioRepository.findAll();
    }
}
