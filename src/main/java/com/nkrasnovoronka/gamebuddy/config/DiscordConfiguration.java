package com.nkrasnovoronka.gamebuddy.config;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DiscordConfiguration {

    private final Environment env;

    public DiscordConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordApi() {
        String token = env.getProperty("TOKEN");
        DiscordApi discordApi = new DiscordApiBuilder()
                .setToken(token)
                .setAllNonPrivilegedIntents()
                .login()
                .join();

        discordApi.addMessageCreateListener(event -> {
           if(event.getMessage().getContent().equalsIgnoreCase("Hi bot")){
               event.getChannel().sendMessage("Hello "  + event.getMessageAuthor().getName());
           }
        });
        return discordApi;
    }


}
