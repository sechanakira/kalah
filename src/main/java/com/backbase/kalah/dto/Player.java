package com.backbase.kalah.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Player implements Serializable {

    private Long id;
    private List<Pit> pits = new ArrayList<>();
    private House house;

}
