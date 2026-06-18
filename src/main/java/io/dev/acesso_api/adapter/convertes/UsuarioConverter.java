package io.dev.acesso_api.adapter.convertes;

import io.dev.acesso_api.adapter.dtos.UsuarioDto;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {
    public Usuario toTomain(UsuarioDto usuarioDto){
        return new Usuario(
                usuarioDto.getId(),
                usuarioDto.getEmail(),
                usuarioDto.getSenha(),
                usuarioDto.getAdministrador(),
                new Pessoa(null, usuarioDto.getNome())
        );
    }

    public UsuarioDto toDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getPessoa().getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAdministrador()
        );
    }
}
