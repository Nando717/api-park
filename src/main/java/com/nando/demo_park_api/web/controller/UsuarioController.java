package com.nando.demo_park_api.web.controller;


import com.nando.demo_park_api.entity.Usuario;
import com.nando.demo_park_api.repository.UsuarioRepository;
import com.nando.demo_park_api.service.UsuarioService;
import com.nando.demo_park_api.web.dto.UsuarioCreateDTO;
import com.nando.demo_park_api.web.dto.UsuarioResponseDto;
import com.nando.demo_park_api.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

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

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Object>atualizarUsuario(@PathVariable(value = "id") Long id,
                                                  @RequestBody @Valid UsuarioResponseDto usuarioResponseDto){
        Optional<Usuario>usU = usuarioRepository.findById(id);

        if (usU.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
        }

        var usuario = usU.get();
        BeanUtils.copyProperties(usuarioResponseDto, usuario);

        return  ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));

    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Object>deleteUsuario(@PathVariable(value = "id") Long id){
        Optional<Usuario> usU = usuarioRepository.findById(id);

        if (usU.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");

        }

        usuarioRepository.delete(usU.get());

        return ResponseEntity.status(HttpStatus.OK).body("usuario deletado");
    }



}
