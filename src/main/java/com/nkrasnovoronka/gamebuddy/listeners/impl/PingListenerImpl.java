package com.nkrasnovoronka.gamebuddy.listeners.impl;

import com.nkrasnovoronka.gamebuddy.listeners.PingListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class PingListenerImpl implements PingListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if(event.getMessage().getContent().equalsIgnoreCase("!ping")){
            event.getChannel().sendMessage("Pong").thenApply(message -> message.addReaction("😀"));
        }
    }
}
