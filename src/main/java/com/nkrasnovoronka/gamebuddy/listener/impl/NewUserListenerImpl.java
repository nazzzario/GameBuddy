package com.nkrasnovoronka.gamebuddy.listener.impl;

import com.nkrasnovoronka.gamebuddy.listener.NewUserListener;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NewUserListenerImpl implements NewUserListener {

    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent event) {
        Optional<ServerTextChannel> textChannelById = event.getServer().getTextChannelById(871736330705580035L);
        textChannelById.ifPresent(serverTextChannel -> serverTextChannel.sendMessage("Welcome " + event.getUser().getName()).thenApply(message -> message.addReaction("😀")));
    }
}
