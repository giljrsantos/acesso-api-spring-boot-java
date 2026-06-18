package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Usuario;

public interface UsuarioRepositoryPort {
    public Usuario create(Usuario usuario);
}
