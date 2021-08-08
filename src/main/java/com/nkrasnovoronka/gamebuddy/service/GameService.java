package com.nkrasnovoronka.gamebuddy.service;

import com.nkrasnovoronka.gamebuddy.exception.GameNotFoundException;
import com.nkrasnovoronka.gamebuddy.model.Game;

import java.util.List;

public interface GameService{
    List<String> printAllGamesName();
    Game getGameByName(String name) throws GameNotFoundException;
}
