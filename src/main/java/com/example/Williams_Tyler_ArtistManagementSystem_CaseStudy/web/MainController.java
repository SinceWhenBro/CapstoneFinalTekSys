package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/artist")
    public String Home(){
        return "artist_index";
    }


}
