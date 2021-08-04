package com.nkrasnovoronka.gamebuddy.listeners.impl;

import com.nkrasnovoronka.gamebuddy.listeners.PlayListener;
import com.nkrasnovoronka.gamebuddy.service.MessagingService;
import lombok.AllArgsConstructor;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayListenerImpl implements PlayListener {

    private final MessagingService messagingService;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessage().getContent().equals("!post dota")) {
            messagingService.sendMessage(
                    event.getMessageAuthor(),
                    "Test",
                    "description",
                    "footer",
                    null,
                    event.getChannel()
            );
        }
    }
}
