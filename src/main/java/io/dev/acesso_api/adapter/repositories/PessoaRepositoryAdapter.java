package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.PessoaEntity;
import io.dev.acesso_api.core.domain.Pessoa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PessoaRepositoryAdapter {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    public PessoaEntity createPessoa(Pessoa pessoa){
        PessoaEntity pessoaEntity = modelMapper.map(pessoa, PessoaEntity.class);
        return pessoaRepository.save(pessoaEntity);
    }

    public PessoaEntity obtainById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com esse id: " + id));
    }
}
