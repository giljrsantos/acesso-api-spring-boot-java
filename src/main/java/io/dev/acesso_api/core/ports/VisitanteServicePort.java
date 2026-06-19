package io.dev.acesso_api.core.ports;

import io.dev.acesso_api.core.domain.Visitante;

public interface VisitanteServicePort {
    Visitante createVisitante(Visitante visitante);
}
