package com.nkrasnovoronka.gamebuddy.service.impl;

import com.nkrasnovoronka.gamebuddy.service.MessagingService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class MessagingServiceImpl implements MessagingService {
    @Override
    public void sendMessage(MessageAuthor messageAuthor, String title, String description, String footer, String thumbnail, TextChannel textChannel) {
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setAuthor(messageAuthor)
                .setTitle(title)
                .setDescription(description)
                .setFooter(footer)
                .setColor(Color.CYAN)
                .setThumbnail(thumbnail)
        ).send(textChannel).thenApply(message -> message.addReaction("🎮"));
    }
}
