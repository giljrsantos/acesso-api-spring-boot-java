package io.dev.acesso_api.adapter.convertes;

import io.dev.acesso_api.adapter.dtos.MoradorDto;
import io.dev.acesso_api.adapter.dtos.UsuarioDto;
import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class MoradorConverter {
    public Morador toTomain(MoradorDto moradorDto){
        return new Morador(
                moradorDto.getId(),
                moradorDto.getCpf(),
                moradorDto.getEndereco(),
                moradorDto.getCelular(),
                new Pessoa(null, moradorDto.getNome())
        );
    }

    public MoradorDto toDto(Morador morador){
        return new MoradorDto(
                morador.getId(),
                morador.getPessoa().getNome(),
                morador.getCpf(),
                morador.getEndereco(),
                morador.getCelular()
        );
    }
}
