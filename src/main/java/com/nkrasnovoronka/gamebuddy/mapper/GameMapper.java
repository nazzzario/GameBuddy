package com.nkrasnovoronka.gamebuddy.mapper;

import com.nkrasnovoronka.gamebuddy.dto.GameDTO;
import com.nkrasnovoronka.gamebuddy.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO toDTO(Game game);

    Game toEntity(GameDTO gameDTO);
}
