package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Morador;

import java.util.Collection;
import java.util.Optional;

public interface MoradorRepositoryPort {
    public Morador create(Morador morador);
    public Optional<Morador> obtainByCpf(String cpf);
    public Collection<Morador> getAllMoradores();
}
