package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Morador;

public interface MoradorRepositoryPort {
    public Morador create(Morador morador);
    public Morador obtainByCpf(String cpf);
}
