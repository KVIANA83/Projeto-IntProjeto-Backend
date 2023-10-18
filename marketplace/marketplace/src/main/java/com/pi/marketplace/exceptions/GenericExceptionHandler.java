package com.pi.marketplace.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public final ResponseEntity<ErrorBody> lancaExcessao(ValidacaoException ex) {

        var errorBody = ErrorBody.builder()
                .mensagem(ex.getMessage())
                .build();

        return new ResponseEntity<ErrorBody>(errorBody, HttpStatus.BAD_REQUEST);
    }
}
