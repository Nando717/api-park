package com.nando.demo_park_api.web.controller;

import com.nando.demo_park_api.entity.Usuario;
import com.nando.demo_park_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){

    Usuario user = usuarioService.salvar(usuario);

    return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getByID(@PathVariable Long id){

        Usuario user = usuarioService.buscarPorID(id);

        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> upDatePassword(@PathVariable Long id, @RequestBody Usuario usuario){

        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());

        return ResponseEntity.ok(user);
    }
}
