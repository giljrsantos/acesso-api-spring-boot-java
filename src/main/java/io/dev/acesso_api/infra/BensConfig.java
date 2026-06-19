package io.dev.acesso_api.infra;

import io.dev.acesso_api.core.ports.MoradorRepositoryPort;
import io.dev.acesso_api.core.ports.MoradorServicePort;
import io.dev.acesso_api.core.ports.UsuarioRepositoryPort;
import io.dev.acesso_api.core.ports.UsuarioServicePort;
import io.dev.acesso_api.core.services.MoradorService;
import io.dev.acesso_api.core.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BensConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UsuarioServicePort usuarioServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort){
        return new UsuarioService(usuarioRepositoryPort);
    }

    @Bean
    public MoradorServicePort moradorServicePort(MoradorRepositoryPort moradorRepositoryPort){
        return new MoradorService(moradorRepositoryPort);
    }
}
