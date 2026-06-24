package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Morador;

import java.util.Collection;

public interface MoradorServicePort {
    Morador createMorador(Morador morador);
    Morador obtainByCfp(String cpf);
    Collection<Morador> getAllMoradores();

    Morador getById(Long id);

    Morador updateMorador(Long id, Morador morador);
}
