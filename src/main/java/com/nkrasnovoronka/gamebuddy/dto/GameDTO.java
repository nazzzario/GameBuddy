package com.nkrasnovoronka.gamebuddy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {
    private Long id;
    private String name;
    private Integer numberOfPlayers;
    private String gameLogo;
}
