package com.rotacidade.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException(String mensagem){
        super(mensagem);
    }

    public RegraDeNegocioException(String message, Throwable cause) {
        super(message, cause);
    }


}
