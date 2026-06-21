package io.dev.acesso_api.core.services;


import io.dev.acesso_api.core.domain.Visitante;
import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import io.dev.acesso_api.core.ports.VisitanteRepositoryPort;
import io.dev.acesso_api.core.ports.VisitanteServicePort;

import java.util.Collection;
import java.util.List;


public class VisitanteService implements VisitanteServicePort {

    private final VisitanteRepositoryPort visitanteRepositoryPort;

    public VisitanteService(VisitanteRepositoryPort visitanteRepositoryPort) {
        this.visitanteRepositoryPort = visitanteRepositoryPort;
    }

    @Override
    public Visitante createVisitante(Visitante visitante) {
        visitanteRepositoryPort.obtainByRg(visitante.getRg())
                .ifPresent(v -> {
                    throw new BusinessException("Visitante com esse Rg já cadastrado!");
                });
        return visitanteRepositoryPort.create(visitante);
    }

    @Override
    public Visitante obtainByRg(String rg) {
        return visitanteRepositoryPort.obtainByRg(rg)
                .orElseThrow(() -> new BusinessNotFoundException("Visitante com esse Rg não encontrado!"));
    }

    @Override
    public Collection<Visitante> listAll() {
        return visitanteRepositoryPort.listAll();
    }

}
