package io.dev.acesso_api.adapter.controller;


import io.dev.acesso_api.adapter.convertes.MoradorConverter;
import io.dev.acesso_api.adapter.dtos.MoradorDto;
import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.ports.MoradorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/moradores")
@RequiredArgsConstructor
public class MoradorController {

    private final MoradorServicePort moradorServicePort;
    private final MoradorConverter moradorConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorDto createMorador(@RequestBody MoradorDto moradorDto) {
        Morador novoMorador = moradorServicePort.createMorador(moradorConverter.toTomain(moradorDto));
        return moradorConverter.toDto(novoMorador);
    }
}
