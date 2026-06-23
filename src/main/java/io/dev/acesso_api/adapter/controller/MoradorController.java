package io.dev.acesso_api.adapter.controller;


import io.dev.acesso_api.adapter.convertes.MoradorConverter;
import io.dev.acesso_api.adapter.dtos.MoradorDto;
import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.ports.MoradorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MoradorDto> getAllMoradores() {
        return moradorServicePort.getAllMoradores().stream()
                .map(moradorConverter::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public MoradorDto obtainByCpf(@PathVariable String cpf){
        Morador morador = moradorServicePort.obtainByCfp(cpf);
        return moradorConverter.toDto(morador);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MoradorDto getByid(@PathVariable Long id){
        Morador morador = moradorServicePort.getById(id);
        return moradorConverter.toDto(morador);
    }

}
