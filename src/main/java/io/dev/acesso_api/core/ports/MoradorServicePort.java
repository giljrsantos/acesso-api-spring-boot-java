package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Morador;

public interface MoradorServicePort {
    Morador createMorador(Morador morador);
}
