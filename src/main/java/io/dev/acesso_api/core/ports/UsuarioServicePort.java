package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Usuario;

import java.util.Collection;

public interface UsuarioServicePort {

    Usuario createUsuario(Usuario usuario);

    Collection<Usuario> getAllUsers();

    Usuario getByEmail(String email);

    Usuario getById(Long id);
}
