package com.backbase.kalah.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
@Table
@Entity(name = "player")
public class Player implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    @Column(name = "pits")
    @CollectionTable(name="player_pits", joinColumns=@JoinColumn(name="player_pit_id"))
    private List<Pit> pits = new LinkedList<>();
    @Embedded
    private House house;

}
