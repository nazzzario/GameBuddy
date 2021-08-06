package com.nkrasnovoronka.gamebuddy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "games")
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "number_of_players", nullable = false)
    @Size(max = 10, min = 2, message = "numbers of players can be form 2 to 10")
    private Integer numberOfPlayers;

    @Column(name = "game_logo")
    private String gameLogo;
}
