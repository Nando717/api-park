package com.nando.demo_park_api.service;

import com.nando.demo_park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final  UsuarioRepository usuarioRepository;

}
