package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.entities.MoradorEntity;
import io.dev.acesso_api.adapter.entities.PessoaEntity;
import io.dev.acesso_api.adapter.entities.UsuarioEntity;
import io.dev.acesso_api.adapter.entities.VisitanteEntity;
import io.dev.acesso_api.core.domain.Morador;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Usuario;
import io.dev.acesso_api.core.domain.Visitante;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import io.dev.acesso_api.core.ports.MoradorRepositoryPort;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    public Optional<Morador> obtainByCpf(String cpf) {
        return moradorRepository.findByCpf(cpf)
                .map(moradorEntity -> modelMapper.map(moradorEntity, Morador.class));
    }

    @Override
    public Collection<Morador> getAllMoradores() {
        return moradorRepository.findAll()
                .stream()
                .map(moradorEntity -> modelMapper.map(moradorEntity, Morador.class))
                .toList();
    }

    @Override
    public Optional<Morador> getById(Long id) {
        return moradorRepository.findById(id)
                .map(moradorEntity -> modelMapper.map(moradorEntity, Morador.class));
    }



    @Override
    public Morador update(Morador morador) {
        MoradorEntity entity = modelMapper.map(morador, MoradorEntity.class);
        // Busca a entidade existente para manter a pessoa atual
        MoradorEntity existente = moradorRepository.findById(morador.getId())
                .orElseThrow(() -> new BusinessNotFoundException("Visitante não encontrado!"));

        PessoaEntity pessoaEntity = existente.getPessoaEntity();
        pessoaEntity.setNome(morador.getPessoa().getNome());

        // Mantém a pessoa existente
        entity.setPessoaEntity(pessoaEntity);
        MoradorEntity updated = moradorRepository.save(entity);
        return modelMapper.map(updated, Morador.class);
    }

    @Override
    public void delete(long id) {
        moradorRepository.deleteById(id);;
    }


}
