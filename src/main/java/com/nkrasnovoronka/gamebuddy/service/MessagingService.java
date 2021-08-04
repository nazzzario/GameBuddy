package com.nkrasnovoronka.gamebuddy.service;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;

public interface MessagingService {
    void sendMessage(MessageAuthor messageAuthor, String title, String description, String footer, String thumbnail, TextChannel textChannel);
}
