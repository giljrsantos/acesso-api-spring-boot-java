package io.dev.acesso_api.infra.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorNotFound {
    private String message;
}
