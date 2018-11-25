package com.backbase.kalah.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Game implements Serializable {

    private Long id;
    private List<Player> players;

}
