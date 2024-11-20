package com.nando.demo_park_api.web.controller;

import com.nando.demo_park_api.entity.Usuario;
import com.nando.demo_park_api.service.UsuarioService;
import com.nando.demo_park_api.web.dto.UsuarioCreateDTO;
import com.nando.demo_park_api.web.dto.UsuarioResponseDto;
import com.nando.demo_park_api.web.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDTO createDTO){

    Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDTO));

    return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
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

    @GetMapping
    public ResponseEntity<List<Usuario>>getAll(){

       List<Usuario> users = usuarioService.buscarTodos();

        return ResponseEntity.ok(users);
    }




}
