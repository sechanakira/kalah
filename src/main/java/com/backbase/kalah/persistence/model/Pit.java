package com.backbase.kalah.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pit")
public class Pit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "pit_id")
    private Long pitId;
    @Column(name = "stones")
    private Integer stones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }

    public Integer getStones() {
        return stones;
    }

    public void setStones(Integer stones) {
        this.stones = stones;
    }
}
