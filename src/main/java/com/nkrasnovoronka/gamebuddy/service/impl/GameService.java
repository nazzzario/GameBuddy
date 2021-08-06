package com.nkrasnovoronka.gamebuddy.service.impl;

import com.nkrasnovoronka.gamebuddy.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;

    public List<String> printAllGamesName(){
        return gameRepository.findAll().stream()
                             .map(game -> String.format("%s %s players", game.getName(), game.getNumberOfPlayers()))
                             .collect(Collectors.toList());
    }
}
