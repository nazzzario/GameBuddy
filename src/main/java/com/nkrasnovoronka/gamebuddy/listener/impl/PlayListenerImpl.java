package com.nkrasnovoronka.gamebuddy.listener.impl;

import com.nkrasnovoronka.gamebuddy.dto.GameDTO;
import com.nkrasnovoronka.gamebuddy.exception.GameNotFoundException;
import com.nkrasnovoronka.gamebuddy.listener.PlayListener;
import com.nkrasnovoronka.gamebuddy.mapper.GameMapper;
import com.nkrasnovoronka.gamebuddy.model.Game;
import com.nkrasnovoronka.gamebuddy.service.GameService;
import com.nkrasnovoronka.gamebuddy.service.MessagingService;
import lombok.AllArgsConstructor;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class PlayListenerImpl implements PlayListener {

    private final MessagingService messagingService;
    private final GameMapper gameMapper;
    private final GameService gameService;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String content = event.getMessage().getContent();
        if (content.startsWith("!post")) {
            GameDTO gameFromDatabase = getGameFromDatabase(getGameName(content));
            if (gameFromDatabase != null) {
                messagingService.sendMessage(
                        event.getMessageAuthor(),
                        "Lets play some game",
                        "bla bla",
                        "bla bla",
                        gameFromDatabase.getGameLogo(),
                        event.getChannel()
                );
            }


        }
    }

    private String getGameName(String content) {
        String[] s = content.split(" ", 1);

        return s[1];
    }

    private GameDTO getGameFromDatabase(String gameName) {
        try {
            Game gameByName = gameService.getGameByName(gameName);
            return gameMapper.toDTO(gameByName);
        } catch (GameNotFoundException e) {
            return null;
        }
    }
}
