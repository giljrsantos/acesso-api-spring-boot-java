package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.PessoaEntity;
import io.dev.acesso_api.adapter.entities.UsuarioEntity;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final PessoaRepositoryAdapter pessoaRepositoryAdapter;
    private final ModelMapper modelMapper;

    @Override
    public Usuario create(Usuario usuario) {
        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setPessoaEntity(pessoaRepositoryAdapter.createPessoa(usuario.getPessoa()));
        UsuarioEntity novoUsuario =  usuarioRepository.save(usuarioEntity);
        return modelMapper.map(novoUsuario, Usuario.class);
    }

    @Override
    public Optional<Usuario> obtainByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(usuarioEntity -> modelMapper.map(usuarioEntity, Usuario.class));
    }

    @Override
    public Collection<Usuario> getAllUsers() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioEntity -> modelMapper.map(usuarioEntity, Usuario.class))
                .toList();
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioEntity -> modelMapper.map(usuarioEntity, Usuario.class));
    }


}
