package com.backbase.kalah.api;

import com.backbase.kalah.dto.GameDTO;
import com.backbase.kalah.persistence.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public GameDTO createGame(){
        return gameService.createGame();
    }
}
