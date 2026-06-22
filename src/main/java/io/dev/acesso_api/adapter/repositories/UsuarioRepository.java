package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.UsuarioEntity;
import io.dev.acesso_api.core.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(String email);
}
