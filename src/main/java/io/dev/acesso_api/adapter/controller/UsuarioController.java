package io.dev.acesso_api.adapter.controller;

import io.dev.acesso_api.adapter.convertes.UsuarioConverter;
import io.dev.acesso_api.adapter.dtos.UsuarioDto;
import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.ports.UsuarioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
                .toDto(usuarioServicePort
                        .createUsuario(usuarioConverter
                                .toTomain(usuarioDto)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> getAllUsers(){
        return usuarioServicePort.getAllUsers()
                .stream()
                .map(usuarioConverter::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto getByEmail(@PathVariable String email){
        Usuario usuario = usuarioServicePort.getByEmail(email);
        return usuarioConverter.toDto(usuario);
    }

}
