package com.backbase.kalah.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.PRECONDITION_FAILED, reason="Required variable is missing")
public class NotYourTurnException extends RuntimeException {

    public NotYourTurnException(){
        super("Not your turn");
    }
}
