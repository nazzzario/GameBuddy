package com.nkrasnovoronka.gamebuddy.config;

import com.nkrasnovoronka.gamebuddy.listeners.PlayListener;
import com.nkrasnovoronka.gamebuddy.listeners.PrintGamesListener;
import lombok.AllArgsConstructor;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@AllArgsConstructor
public class DiscordConfiguration {

    private final Environment env;
    private final PlayListener playListener;
    private final PrintGamesListener printGamesListener;

    @Bean
    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordApi() {
        String token = env.getProperty("TOKEN");
        DiscordApi discordApi = new DiscordApiBuilder()
                .setToken(token)
                .setAllNonPrivilegedIntents()
                .login()
                .join();
        discordApi.addMessageCreateListener(playListener);
        discordApi.addMessageCreateListener(printGamesListener);
        //todo run this command one time and all discord will register this command
        SlashCommand command = SlashCommand.with("ping", "Checks the functionality of this command")
                .createGlobal(discordApi)
                .join();

//        discordApi.addSlashCommandCreateListener(event -> {
//            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
//            if (slashCommandInteraction.getCommandName().equals("ping")) {
//                slashCommandInteraction.createImmediateResponder()
//                        .setContent("Pong!")
//                        .setFlags(MessageFlag.EPHEMERAL)
//                        .respond();
//            }
//        });

        return discordApi;
    }


}
