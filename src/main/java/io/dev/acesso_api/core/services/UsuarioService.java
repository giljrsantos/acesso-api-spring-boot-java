package io.dev.acesso_api.core.services;

import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import io.dev.acesso_api.core.ports.UsuarioServicePort;

import java.util.Collection;
import java.util.List;


public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;


    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        usuarioRepositoryPort.obtainByEmail(usuario.getEmail())
                .ifPresent(u -> {
                    throw new BusinessException("Usuário já existe com esse email");
                });
        return usuarioRepositoryPort.create(usuario);
    }

    @Override
    public Usuario getByEmail(String email) {
        return usuarioRepositoryPort.obtainByEmail(email)
                .orElseThrow(() -> new BusinessNotFoundException("Usuário não encontrado com esse email!"));
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepositoryPort.getById(id)
                .orElseThrow(() -> new BusinessNotFoundException("Usuário não encontrado com esse id!"));
    }

    @Override
    public Collection<Usuario> getAllUsers() {
        return usuarioRepositoryPort.getAllUsers();
    }
}
