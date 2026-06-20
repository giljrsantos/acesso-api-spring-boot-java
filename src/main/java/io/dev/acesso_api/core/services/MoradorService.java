package io.dev.acesso_api.core.services;


import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.ports.MoradorRepositoryPort;
import io.dev.acesso_api.core.ports.MoradorServicePort;


public class MoradorService implements MoradorServicePort {

    private final MoradorRepositoryPort moradorRepositoryPort;

    public MoradorService(MoradorRepositoryPort moradorRepositoryPort) {
        this.moradorRepositoryPort = moradorRepositoryPort;
    }

    @Override
    public Morador createMorador(Morador morador) {
        Morador moradorExistente = moradorRepositoryPort.obtainByCpf(morador.getCpf());
        if(moradorExistente != null){
            throw new BusinessException("Morador já existe com esse CPF");
        }
        return moradorRepositoryPort.create(morador);
    }
}
