package com.backbase.kalah.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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

}
