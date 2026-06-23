package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Usuario;

import java.util.Collection;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    public Usuario create(Usuario usuario);
    public Optional<Usuario> obtainByEmail(String email);
    public Collection<Usuario> getAllUsers();
    public Optional<Usuario> getById(Long id);
}
