package com.backbase.kalah.persistence.service;

import com.backbase.kalah.dto.GameDTO;

@FunctionalInterface
public interface GameService {

    GameDTO createGame();

}
