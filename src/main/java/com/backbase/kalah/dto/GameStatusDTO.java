package com.backbase.kalah.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class GameStatusDTO implements Serializable {

    private Long id;
    private String url;
    private Map<String,String> status = new HashMap<>();

}
