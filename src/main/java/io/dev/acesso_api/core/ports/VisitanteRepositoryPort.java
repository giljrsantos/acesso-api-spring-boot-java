package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Visitante;

public interface VisitanteRepositoryPort {
    public Visitante create(Visitante visitante);
    public Visitante obtainByRg(String rg);
}
