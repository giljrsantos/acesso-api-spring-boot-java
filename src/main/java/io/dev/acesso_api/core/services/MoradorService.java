package io.dev.acesso_api.core.services;


import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.domain.Visitante;
import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import io.dev.acesso_api.core.ports.MoradorRepositoryPort;
import io.dev.acesso_api.core.ports.MoradorServicePort;

import java.util.Collection;


public class MoradorService implements MoradorServicePort {

    private final MoradorRepositoryPort moradorRepositoryPort;

    public MoradorService(MoradorRepositoryPort moradorRepositoryPort) {
        this.moradorRepositoryPort = moradorRepositoryPort;
    }

    @Override
    public Morador createMorador(Morador morador) {
        moradorRepositoryPort.obtainByCpf(morador.getCpf())
                .ifPresent(m -> {
                    throw new BusinessException("Morador já existe com esse CPF");
                });
        return moradorRepositoryPort.create(morador);
    }

    @Override
    public Morador obtainByCfp(String cpf) {
        return moradorRepositoryPort.obtainByCpf(cpf)
                .orElseThrow(() -> new BusinessNotFoundException("Morador não encontrado com esse CPF"));
    }

    @Override
    public Collection<Morador> getAllMoradores() {
        return moradorRepositoryPort.getAllMoradores();
    }

    @Override
    public Morador getById(Long id) {
        return moradorRepositoryPort.getById(id)
                .orElseThrow(() -> new BusinessNotFoundException("Morador não encontrado com esse ID"));
    }

    @Override
    public Morador updateMorador(Long id, Morador morador) {
        // Verifica se o visitante existe
        Morador moradorExistente = this.getById(id);

        // Valida se o novo CPF já está cadastrado em outro visitante
        if (!moradorExistente.getCpf().equals(morador.getCpf())) {
            moradorRepositoryPort.obtainByCpf(morador.getCpf())
                    .ifPresent(v -> {
                        throw new BusinessNotFoundException("Morador com esse CPF já cadastrado!");
                    });
        }

        // Atualiza os dados
        moradorExistente.setCpf(morador.getCpf());
        moradorExistente.setPessoa(morador.getPessoa());
        moradorExistente.setEndereco(morador.getEndereco());
        moradorExistente.setCelular(morador.getCelular());

        // Persiste a atualização
        return moradorRepositoryPort.update(moradorExistente);
    }

    @Override
    public void delete(Long id) {
        // verifica se o morador existe antes de deletar
        this.getById(id);

        //se chegou aqui, o morador existe e vai ser deletado
        moradorRepositoryPort.delete(id);
    }
}
