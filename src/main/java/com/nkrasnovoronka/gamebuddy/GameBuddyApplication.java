package com.nkrasnovoronka.gamebuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameBuddyApplication {

    public static void main(String[] args) {
        //todo Deploy bot to Herouku and config CI/CD ASAP
        SpringApplication.run(GameBuddyApplication.class, args);
    }
}
