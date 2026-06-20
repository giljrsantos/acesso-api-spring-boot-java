package io.dev.acesso_api.core.services;

import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import io.dev.acesso_api.core.ports.UsuarioServicePort;


public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepositoryPort.obtainByEmail(usuario.getEmail());
        if(usuarioExistente != null){
            throw new BusinessException("Usuário já existe com esse email");
        }
        return usuarioRepositoryPort.create(usuario);
    }
}
