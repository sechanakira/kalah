package com.backbase.kalah.persistence.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class House implements Serializable {

    private Integer stones;

    public Integer getStones() {
        return stones;
    }

    public void setStones(Integer stones) {
        this.stones = stones;
    }

}
