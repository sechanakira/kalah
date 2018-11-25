package com.backbase.kalah.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid Pit Id")
public class InvalidPitIdException extends RuntimeException {

    public InvalidPitIdException(){
        super("Invalid Pit Id");
    }

}
