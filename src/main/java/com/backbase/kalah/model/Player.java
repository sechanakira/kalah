package com.backbase.kalah.model;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private List<Pit> pits = new LinkedList<>();
    private House house;

    public List<Pit> getPits() {
        return pits;
    }

    public void setPits(List<Pit> pits) {
        this.pits = pits;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

}
