package com.backbase.kalah.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Required variable is missing")
public class MissingVariableException extends RuntimeException {

    public MissingVariableException(String msg){
        super(msg);
    }
}
