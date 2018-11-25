package com.backbase.kalah.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid Game Id")
public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(){
        super("Specified Game was not found");
    }
}
