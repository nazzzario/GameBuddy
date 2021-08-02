package com.nkrasnovoronka.gamebuddy;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GameBuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameBuddyApplication.class, args);
    }
}
