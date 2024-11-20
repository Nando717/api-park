package com.nando.demo_park_api.web.dto.mapper;

import com.nando.demo_park_api.entity.Usuario;
import com.nando.demo_park_api.web.dto.UsuarioCreateDTO;
import com.nando.demo_park_api.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDTO createDTO){
        return new ModelMapper().map(createDTO, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario) {
        String role = usuario.getRole().name().substring("ROLE_".length());
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Usuario, UsuarioResponseDto> propertyMapper =
                mapperMain.createTypeMap(Usuario.class, UsuarioResponseDto.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> role, UsuarioResponseDto::setRole)
        );
        return mapperMain.map(usuario, UsuarioResponseDto.class);
    }
}
