package com.backbase.kalah.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Game data is corrupted")
public class GameDataCorruptedException extends RuntimeException {

    public GameDataCorruptedException(){
        super("Game Data is corrupted");
    }
}
