package com.backbase.kalah.api;

import com.backbase.kalah.dto.GameDTO;
import com.backbase.kalah.dto.GameStatusDTO;
import com.backbase.kalah.persistence.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public GameDTO createGame(){
        return gameService.createGame();
    }

    @GetMapping("/{id}")
    public GameDTO findGame(@PathVariable("id") @Valid @NotNull Long id){
        return gameService.findGame(id);
    }

    @PutMapping("/{gameId}/pits/{pitId}")
    public GameStatusDTO makeMove(@PathVariable("gameId") @Valid @NotNull Long gameId, @PathVariable("pitId") @Valid @NotNull Long pitId){
        return gameService.makeMove(gameId,pitId);
    }
}
