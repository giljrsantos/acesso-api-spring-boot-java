package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Visitante;

import java.util.Optional;

public interface VisitanteRepositoryPort {
    public Visitante create(Visitante visitante);
    public Optional<Visitante> obtainByRg(String rg);
}
