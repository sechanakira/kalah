package com.backbase.kalah.persistence.service;

import com.backbase.kalah.dto.GameDTO;
import com.backbase.kalah.persistence.model.Game;
import com.backbase.kalah.persistence.model.House;
import com.backbase.kalah.persistence.model.Pit;
import com.backbase.kalah.persistence.model.Player;
import com.backbase.kalah.persistence.repository.GameRepository;
import com.backbase.kalah.persistence.repository.PitRepository;
import com.backbase.kalah.persistence.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static com.backbase.kalah.constant.ApplicationConstants.GAME_RESOURCE_BASE_URL;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PitRepository pitRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public GameDTO createGame() {
        Game game = new Game();
        game.setPlayers(createPlayers());
        Game saved = gameRepository.save(game);
        GameDTO dto = mapper.map(saved,GameDTO.class);
        dto.setUri(createResourceUri(saved.getId()));
        return dto;
    }

    private List<Player> createPlayers(){
        Player player1 = new Player();
        House player1House = new House();
        player1.setHouse(player1House);
        player1.setName("Player1");
        player1.setPlayerId(1L);
        player1.setPits(createPlayerPits());

        Player player2 = new Player();
        House player2House = new House();
        player2.setHouse(player2House);
        player2.setName("Player2");
        player2.setPlayerId(2L);
        player2.setPits(createPlayerPits());

        playerRepository.saveAll(Arrays.asList(player1,player2));

        return Arrays.asList(player1,player2);
    }

    private String createResourceUri(Long id){
        StringBuilder sb = new StringBuilder(GAME_RESOURCE_BASE_URL);
        sb.append(id);
        return sb.toString();
    }

    private List<Pit> createPlayerPits(){
        List<Pit> pits = new LinkedList<>();
        IntStream.rangeClosed(1,6).forEach(i->pits.add(new Pit()));
        pitRepository.saveAll(pits);
        return pits;
    }

}
