package com.backbase.kalah.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Game was won and is now ended")
public class GameEndedException extends RuntimeException {

    public GameEndedException(String msg){
        super(msg);
    }
}
