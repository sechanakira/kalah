package com.backbase.kalah.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PitDTO implements Serializable {

    private Long id;
    private Long pitId;
    private Integer stones;

}
