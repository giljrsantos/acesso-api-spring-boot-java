package io.dev.acesso_api.core.services;

import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import io.dev.acesso_api.core.ports.UsuarioServicePort;
import org.springframework.stereotype.Service;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepositoryPort.create(usuario);
    }
}
