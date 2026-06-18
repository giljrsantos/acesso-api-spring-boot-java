package io.dev.acesso_api.adapter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String senha;
    private Boolean administrador;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoaEntity;
}
