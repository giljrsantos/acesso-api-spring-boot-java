package io.dev.acesso_api.adapter.controller;

import io.dev.acesso_api.adapter.convertes.UsuarioConverter;
import io.dev.acesso_api.adapter.dtos.UsuarioDto;
import io.dev.acesso_api.adapter.dtos.VisitanteDto;
import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.domain.Visitante;
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

    @GetMapping("email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto getByEmail(@PathVariable String email){
        Usuario usuario = usuarioServicePort.getByEmail(email);
        return usuarioConverter.toDto(usuario);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto getById(@PathVariable Long id){
        Usuario usuario = usuarioServicePort.getById(id);
        return usuarioConverter.toDto(usuario);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto updateVisitante(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioServicePort.updateUsuario(id, usuarioConverter.toTomain(usuarioDto));
        return usuarioConverter.toDto(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Long id){
        usuarioServicePort.delete(id);
    }

}
