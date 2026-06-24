package io.dev.acesso_api.adapter.repositories;

import io.dev.acesso_api.adapter.convertes.VisitanteConverter;
import io.dev.acesso_api.adapter.entities.PessoaEntity;
import io.dev.acesso_api.adapter.entities.VisitanteEntity;
import io.dev.acesso_api.core.domain.Pessoa;
import io.dev.acesso_api.core.domain.Visitante;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import io.dev.acesso_api.core.ports.VisitanteRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class VisitanteRepositoryAdapter implements VisitanteRepositoryPort {

    private final VisitanteRepository visitanteRepository;
    private final PessoaRepositoryAdapter pessoaRepositoryAdapter;
    private final VisitanteConverter visitanteConverter;
    private final ModelMapper modelMapper;


    @Override
    public Visitante create(Visitante visitante) {
        VisitanteEntity entity = modelMapper.map(visitante, VisitanteEntity.class);
        entity.setPessoaEntity(pessoaRepositoryAdapter.createPessoa(visitante.getPessoa()));
        return modelMapper.map(visitanteRepository.save(entity), Visitante.class);
    }

    @Override
    public Optional<Visitante> obtainByRg(String rg) {
       return visitanteRepository.findByRg(rg)
                .map(visitanteEntity -> modelMapper.map(visitanteEntity, Visitante.class));
    }

    @Override
    public Collection<Visitante> listAll() {
        return visitanteRepository.findAll()
                .stream()
                .map(visitanteEntity -> modelMapper.map(visitanteEntity, Visitante.class))
                .toList();
    }

    @Override
    public Optional<Visitante> getById(Long id) {
        return visitanteRepository.findById(id)
                .map(visitanteEntity -> modelMapper.map(visitanteEntity, Visitante.class));
    }

    @Override
    public Visitante update(Visitante visitante) {
        VisitanteEntity entity = modelMapper.map(visitante, VisitanteEntity.class);
        // Busca a entidade existente para manter a pessoa atual
        VisitanteEntity existente = visitanteRepository.findById(visitante.getId())
                .orElseThrow(() -> new BusinessNotFoundException("Visitante não encontrado!"));

        PessoaEntity pessoaEntity = existente.getPessoaEntity();
        pessoaEntity.setNome(visitante.getPessoa().getNome());
        // Mantém a pessoa existente
        entity.setPessoaEntity(pessoaEntity);
        VisitanteEntity updated = visitanteRepository.save(entity);
        return modelMapper.map(updated, Visitante.class);
    }
}
