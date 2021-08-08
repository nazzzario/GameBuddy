package com.nkrasnovoronka.gamebuddy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @GetMapping
    public String hello(){
        return "hello from herouku";
    }
}
