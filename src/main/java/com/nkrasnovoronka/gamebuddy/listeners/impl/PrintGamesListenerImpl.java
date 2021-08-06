package com.nkrasnovoronka.gamebuddy.listeners.impl;

import com.nkrasnovoronka.gamebuddy.listeners.PrintGamesListener;
import com.nkrasnovoronka.gamebuddy.service.impl.GameService;
import lombok.AllArgsConstructor;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrintGamesListenerImpl implements PrintGamesListener {
    private GameService gameService;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if(event.getMessage().getContent().equals("!print")){
            String gamesList = String.join("\n", gameService.printAllGamesName());
            event.getChannel().sendMessage(gamesList);
        }
    }
}
