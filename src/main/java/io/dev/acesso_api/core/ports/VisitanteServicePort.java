package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Visitante;

import java.util.Collection;

public interface VisitanteServicePort {
    Visitante createVisitante(Visitante visitante);

    Visitante obtainByRg(String rg);

    Collection<Visitante> listAll();

    Visitante getById(Long id);

    Visitante updateVisitante(Long id, Visitante visitante);
}
