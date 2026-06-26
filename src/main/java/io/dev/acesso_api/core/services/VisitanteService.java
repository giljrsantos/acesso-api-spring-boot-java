package io.dev.acesso_api.core.services;


import io.dev.acesso_api.core.domain.Visitante;
import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import io.dev.acesso_api.core.ports.VisitanteRepositoryPort;
import io.dev.acesso_api.core.ports.VisitanteServicePort;

import java.util.Collection;


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

    @Override
    public Visitante getById(Long id) {
        return visitanteRepositoryPort.getById(id)
                .orElseThrow(() -> new BusinessNotFoundException("Visitante com esse ID não encontrado!"));
    }

    @Override
    public Visitante updateVisitante(Long id, Visitante visitante) {
        // Verifica se o visitante existe
        Visitante visitanteExistente = this.getById(id);

        // Valida se o novo RG já está cadastrado em outro visitante
        if (!visitanteExistente.getRg().equals(visitante.getRg())) {
            visitanteRepositoryPort.obtainByRg(visitante.getRg())
                    .ifPresent(v -> {
                        throw new BusinessNotFoundException("Visitante com esse Rg já cadastrado!");
                    });
        }
        // Atualiza os dados
        visitanteExistente.setRg(visitante.getRg());
        visitanteExistente.setPessoa(visitante.getPessoa());

        // Persiste a atualização
        return visitanteRepositoryPort.update(visitanteExistente);
    }

    @Override
    public void delete(Long id) {
        // Verifica se o visitante existe antes de deletar
        this.getById(id);
        //Se chegou aqui, o visitante existe, então deleta
        visitanteRepositoryPort.delete(id);
    }

}
