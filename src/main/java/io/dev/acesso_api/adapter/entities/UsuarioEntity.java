package io.dev.acesso_api.adapter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String senha;
    private Boolean administrador;
}
