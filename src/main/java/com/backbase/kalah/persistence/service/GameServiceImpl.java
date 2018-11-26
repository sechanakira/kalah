package com.backbase.kalah.persistence.service;

import com.backbase.kalah.dto.GameDTO;
import com.backbase.kalah.dto.GameStatusDTO;
import com.backbase.kalah.exception.*;
import com.backbase.kalah.persistence.model.Game;
import com.backbase.kalah.persistence.model.Pit;
import com.backbase.kalah.persistence.model.Player;
import com.backbase.kalah.persistence.repository.GameRepository;
import com.backbase.kalah.persistence.repository.PitRepository;
import com.backbase.kalah.persistence.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.LongStream;

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

    @Override
    public GameDTO findGame(Long id) {
        GameDTO gameDTO;
        Optional<Game> found = gameRepository.findById(id);
        if(found.isPresent()){
            gameDTO = mapper.map(found.get(),GameDTO.class);
            gameDTO.setUri(createResourceUri(found.get().getId()));
        }else {
            throw new GameNotFoundException();
        }
        return gameDTO;
    }

    @Override
    public GameStatusDTO makeMove(Long gameId, Long pitId) {
        if(gameId == null){
            throw new MissingVariableException("Required param gameId is missing from request");
        }
        Optional<Game> fetched = gameRepository.findById(gameId);
        if(pitId == null){
            throw new MissingVariableException("Required param pitId is missing from request");
        }
        if(pitId < 0 || pitId > 14){
            throw new InvalidPitIdException();
        }
        if(fetched.isPresent()){
            Game game = fetched.get();
            if(game.isGameWon()){
                throw new GameEndedException("Game was won by " + game.getWinner() + " and is now ended");
            }
            return move(game,pitId);
        }else{
            throw new GameNotFoundException();
        }
    }

    private GameStatusDTO move(Game game, Long pitId){
        boolean isPlayer1 = false;
        if(pitId < 7){
            isPlayer1 = true;
        }
        if(!isPlayer1 && game.getPlayer1PlaysNext() != null && game.getPlayer1PlaysNext() == true){
            throw new NotYourTurnException();
        }
        if(isPlayer1 && game.getPlayer2PlaysNext() != null && game.getPlayer2PlaysNext() == true){
            throw new NotYourTurnException();
        }
        List<Pit> pits = new ArrayList<>();
        for(Player player : game.getPlayers()){
            pits.addAll(player.getPits());
        }
        pits.sort(Comparator.comparing(Pit::getPitId));
        Pit start = pitRepository.findByPitId(pitId);
        int startStones = start.getStones();
        start.setStones(0);
        Long lastPitId = 0L;
        Long currentPitId = start.getPitId() + 1;
        for(int j = 1; j <= startStones; j++){
            if(currentPitId > 14){
                currentPitId = 1L;
            }
            if(currentPitId == 14 && isPlayer1){
                continue;
            }
            if(currentPitId == 7 && !isPlayer1){
                continue;
            }
            Pit pit = pitRepository.findByPitId(currentPitId);
            pit.setStones(pit.getStones() + 1);
            lastPitId = currentPitId;
            currentPitId++;
        }
        if(isPlayer1 && lastPitId == 7){
            game.setPlayer1PlaysNext(true);
        }
        if(!isPlayer1 && lastPitId == 14){
            game.setPlayer2PlaysNext(true);
        }
        GameStatusDTO dto = new GameStatusDTO();
        dto.setId(game.getId());
        dto.setUrl(createResourceUri(game.getId()));
        dto.setStatus(createStatusMap(game));
        return dto;
    }

    private Map<String,String> createStatusMap(Game game){
        Map<String, String> map = new HashMap<>();
        Player player1 = null;
        Player player2 = null;
        for(Player player : game.getPlayers()){
            if(player.getPlayerId() == 1L){
                player1 = player;
            }
            if(player.getPlayerId() == 2L){
                player2 = player;
            }
        }
        if(player1 == null || player2 == null){
            throw new GameDataCorruptedException();
        }
        player1.getPits().forEach(pit->map.put(pit.getPitId().toString(),pit.getStones().toString()));
        player2.getPits().forEach(pit->map.put(pit.getPitId().toString(),pit.getStones().toString()));
        return map;
    }

    private List<Player> createPlayers(){
        Player player1 = new Player();
        player1.setName("Player1");
        player1.setPlayerId(1L);
        player1.setPits(createPlayerPits(true));

        Player player2 = new Player();
        player2.setName("Player2");
        player2.setPlayerId(2L);
        player2.setPits(createPlayerPits(false));

        playerRepository.saveAll(Arrays.asList(player1,player2));

        return Arrays.asList(player1,player2);
    }

    private String createResourceUri(Long id){
        StringBuilder sb = new StringBuilder(GAME_RESOURCE_BASE_URL);
        sb.append(id);
        return sb.toString();
    }

    private List<Pit> createPlayerPits(boolean player1){
        int startFrom;
        int endAt;
        if(player1){
            startFrom = 1;
            endAt = 7;
        }else{
            startFrom = 8;
            endAt = 14;
        }
        List<Pit> pits = new LinkedList<>();
        LongStream.rangeClosed(startFrom,endAt).forEach(i->{
            Pit pit = new Pit();
            pit.setPitId(i);
            pit.setStones(6);
            pits.add(pit);
        });
        pitRepository.saveAll(pits);
        return pits;
    }

}
