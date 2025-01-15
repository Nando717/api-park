package com.nando.demo_park_api.web.dto;


import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioResponseDto {

    private Long id;
    private String username;
    private String role;
}
