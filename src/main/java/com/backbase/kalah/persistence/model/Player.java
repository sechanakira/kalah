package com.backbase.kalah.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Table
@Entity(name = "player")
public class Player implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "name")
    private String name;
    @ElementCollection
    @Column(name = "pits")
    @CollectionTable(name="player_pits", joinColumns=@JoinColumn(name="player_pit_id"))
    private List<Pit> pits = new ArrayList<>();
    @Embedded
    private House house;

}
