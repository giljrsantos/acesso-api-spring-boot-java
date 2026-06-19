package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.MoradorEntity;
import io.dev.acesso_api.adapter.entities.PessoaEntity;
import io.dev.acesso_api.adapter.entities.UsuarioEntity;
import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.ports.MoradorRepositoryPort;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoradorRepositoryAdapter implements MoradorRepositoryPort {

    private final MoradorRepository moradorRepository;
    private final PessoaRepositoryAdapter pessoaRepositoryAdapter;
    private final ModelMapper modelMapper;


    @Override
    public Morador create(Morador morador) {
        MoradorEntity entity = modelMapper.map(morador, MoradorEntity.class);
        entity.setPessoaEntity(pessoaRepositoryAdapter.createPessoa(morador.getPessoa()));
        MoradorEntity novoMorador = moradorRepository.save(entity);
        return modelMapper.map(novoMorador, Morador.class);
    }

    @Override
    public Morador obtainByCpf(String cpf) {
        MoradorEntity moradorByCpf = moradorRepository.findByCpf(cpf);
        if(moradorByCpf == null){
           //throw new IllegalArgumentException("Morador já com esse CPF já existe!");
            return null;
        }
        return modelMapper.map(moradorByCpf, Morador.class);
    }

}
