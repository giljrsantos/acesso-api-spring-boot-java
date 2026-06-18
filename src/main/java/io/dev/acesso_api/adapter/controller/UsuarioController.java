package io.dev.acesso_api.adapter.controller;

import io.dev.acesso_api.adapter.convertes.UsuarioConverter;
import io.dev.acesso_api.adapter.dtos.UsuarioDto;
import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.ports.UsuarioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioServicePort usuarioServicePort;
    private final UsuarioConverter usuarioConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto){
        return usuarioConverter
                .toDto(usuarioServicePort.createUsuario(usuarioConverter.toTomain(usuarioDto)));
    }
}
