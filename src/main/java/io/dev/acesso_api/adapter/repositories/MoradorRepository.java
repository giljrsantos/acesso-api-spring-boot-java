package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.MoradorEntity;
import io.dev.acesso_api.adapter.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {

    MoradorEntity findByCpf(String cpf);
}
