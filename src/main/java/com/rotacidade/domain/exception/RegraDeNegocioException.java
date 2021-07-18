package com.rotacidade.domain.exception;

public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException(String mensagem){
        super(mensagem);
    }

    public RegraDeNegocioException(String message, Throwable cause) {
        super(message, cause);
    }


}
