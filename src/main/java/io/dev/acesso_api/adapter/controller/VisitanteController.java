package io.dev.acesso_api.adapter.controller;



import io.dev.acesso_api.adapter.convertes.VisitanteConverter;
import io.dev.acesso_api.adapter.dtos.VisitanteDto;
import io.dev.acesso_api.core.domain.Visitante;
import io.dev.acesso_api.core.ports.VisitanteServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/visitantes")
@RequiredArgsConstructor
public class VisitanteController {

    private final VisitanteServicePort visitanteServicePort;
    private final VisitanteConverter visitanteConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitanteDto createVisitante(@RequestBody VisitanteDto visitanteDto) {
        Visitante novoVisitante = visitanteServicePort.createVisitante(visitanteConverter.toTomain(visitanteDto));
        return visitanteConverter.toDto(novoVisitante);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VisitanteDto> obtainAll() {
        return visitanteServicePort.listAll().stream()
                .map(visitanteConverter::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{rg}")
    @ResponseStatus(HttpStatus.OK)
    public VisitanteDto obtainByRg(@PathVariable String rg) {
        Visitante visitante = visitanteServicePort.obtainByRg(rg);
        return visitanteConverter.toDto(visitante);
    }
}