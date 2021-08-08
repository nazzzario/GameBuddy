package com.nkrasnovoronka.gamebuddy.service.impl;

import com.nkrasnovoronka.gamebuddy.exception.GameNotFoundException;
import com.nkrasnovoronka.gamebuddy.model.Game;
import com.nkrasnovoronka.gamebuddy.repository.GameRepository;
import com.nkrasnovoronka.gamebuddy.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;

    public List<String> printAllGamesName() {
        return gameRepository.findAll().stream()
                .map(game -> String.format("%s %s players", game.getName(), game.getNumberOfPlayers()))
                .collect(Collectors.toList());
    }

    @Override
    public Game getGameByName(String name) throws GameNotFoundException {
        Game gameByName = gameRepository.getGameByName(name);
        if(gameByName == null){
            throw new GameNotFoundException(String.format("Cannot find game with name %s", name));
        }else {
            return gameByName;
        }
    }
}
