package com.backbase.kalah.persistence.service;

import com.backbase.kalah.dto.GameDTO;
import com.backbase.kalah.dto.GameStatusDTO;

public interface GameService {

    GameDTO createGame();

    GameDTO findGame(Long id);

    GameStatusDTO makeMove(Long gameId,Long pitId);

}
