package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.MoradorEntity;
import io.dev.acesso_api.adapter.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {

    Optional<MoradorEntity> findByCpf(String cpf);
}
