package com.nkrasnovoronka.gamebuddy.config;

import com.nkrasnovoronka.gamebuddy.listeners.PlayListener;
import lombok.AllArgsConstructor;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@AllArgsConstructor
public class DiscordConfiguration {

    private final Environment env;
    private final PlayListener playListener;

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
        return discordApi;
    }


}
