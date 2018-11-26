package com.backbase.kalah.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "game_won")
    private boolean gameWon;
    @Column(name = "winner")
    private String winner;
    @Column(name = "player_1_plays_next")
    private Boolean player1PlaysNext;
    @Column(name = "player_2_plays_next")
    private Boolean player2PlaysNext;
    @ElementCollection
    @Column(name = "players")
    @CollectionTable(name="game_players", joinColumns=@JoinColumn(name="game_id"))
    private List<Player> players;

}
