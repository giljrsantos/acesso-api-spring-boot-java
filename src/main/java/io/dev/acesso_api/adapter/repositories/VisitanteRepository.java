package io.dev.acesso_api.adapter.repositories;


import io.dev.acesso_api.adapter.entities.VisitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteRepository extends JpaRepository<VisitanteEntity, Long> {
    VisitanteEntity findByRg(String rg);
}
