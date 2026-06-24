package io.dev.acesso_api.core.services;

import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.domain.Visitante;
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
    public Usuario updateUsuario(Long id, Usuario usuario) {
        // Verifica se o visitante existe
        Usuario usuarioExistente = this.getById(id);

        // Valida se o novo RG já está cadastrado em outro visitante
        if (!usuarioExistente.getEmail().equals(usuario.getEmail())) {
            usuarioRepositoryPort.obtainByEmail(usuario.getEmail())
                    .ifPresent(v -> {
                        throw new BusinessNotFoundException("Morador não Cadastrado com esse E-mail!");
                    });
        }

        // Atualiza os dados
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setPessoa(usuario.getPessoa());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setAdministrador(usuario.getAdministrador());

        // Persiste a atualização
        return usuarioRepositoryPort.update(usuarioExistente);
    }

    @Override
    public Collection<Usuario> getAllUsers() {
        return usuarioRepositoryPort.getAllUsers();
    }
}
