package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Visitante;

import java.util.Collection;
import java.util.Optional;

public interface VisitanteRepositoryPort {
    public Visitante create(Visitante visitante);
    public Optional<Visitante> obtainByRg(String rg);

    public Collection<Visitante> listAll();
    public Optional<Visitante> getById(Long id);

    public Visitante update(Visitante visitante);
}
