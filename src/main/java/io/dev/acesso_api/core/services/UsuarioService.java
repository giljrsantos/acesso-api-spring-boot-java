package io.dev.acesso_api.core.services;

import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.ports.UsuarioServicePort;
import org.springframework.stereotype.Service;

public class UsuarioService implements UsuarioServicePort {
    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuario;
    }
}
