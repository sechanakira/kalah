package com.backbase.kalah.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class House implements Serializable {

    @Column(name = "stones")
    private Integer stones;

}
