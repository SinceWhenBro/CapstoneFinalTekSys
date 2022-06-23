package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("")
    public String landingPage(){
        return "index";
    }

}
