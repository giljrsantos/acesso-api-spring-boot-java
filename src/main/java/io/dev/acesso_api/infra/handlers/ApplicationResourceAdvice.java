package io.dev.acesso_api.infra.handlers;

import io.dev.acesso_api.core.exception.BusinessException;
import io.dev.acesso_api.core.exception.BusinessNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationResourceAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ApiError handleBusinessException(BusinessException ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(BusinessNotFoundException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ApiErrorNotFound handleBusinessException(BusinessNotFoundException ex) {
        return new ApiErrorNotFound(ex.getMessage());
    }


}
