package com.nkrasnovoronka.gamebuddy.repository;

import com.nkrasnovoronka.gamebuddy.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game getGameByName(String name);
}
