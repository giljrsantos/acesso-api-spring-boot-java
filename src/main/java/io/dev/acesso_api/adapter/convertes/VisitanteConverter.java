package io.dev.acesso_api.adapter.convertes;

import io.dev.acesso_api.adapter.dtos.MoradorDto;
import io.dev.acesso_api.adapter.dtos.VisitanteDto;
import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Visitante;
import org.springframework.stereotype.Component;

@Component
public class VisitanteConverter {
    public Visitante toTomain(VisitanteDto visitanteDto){
        return new Visitante(
                visitanteDto.getId(),
                visitanteDto.getRg(),
                new Pessoa(null, visitanteDto.getNome())
        );
    }

    public VisitanteDto toDto(Visitante visitante){
        return new VisitanteDto(
                visitante.getId(),
                visitante.getPessoa().getNome(),
                visitante.getRg()
        );
    }
}
