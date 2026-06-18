package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
