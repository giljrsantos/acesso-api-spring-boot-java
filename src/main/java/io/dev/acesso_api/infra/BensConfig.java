package io.dev.acesso_api.infra;

import io.dev.acesso_api.core.ports.UsuarioServicePort;
import io.dev.acesso_api.core.services.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BensConfig {

    @Bean
    public UsuarioServicePort usuarioServiceImpl(){
        return new UsuarioService();
    }
}
