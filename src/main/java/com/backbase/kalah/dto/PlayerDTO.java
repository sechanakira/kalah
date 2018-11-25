package com.backbase.kalah.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PlayerDTO implements Serializable {

    private Long id;
    private Long playerId;
    private String name;
    private List<PitDTO> pits = new ArrayList<>();
    private HouseDTO houseDTO;

}
