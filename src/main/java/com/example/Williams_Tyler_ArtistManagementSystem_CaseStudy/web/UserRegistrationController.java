package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.web;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services.UserService;
import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, Model model){
        boolean isManager = false;
        model.addAttribute("isManager", isManager);
        if(isManager == true){
            registrationDto.setRole("MANAGER");
            userService.saveManager(registrationDto);
        } else{
            registrationDto.setRole("ARTIST");
            userService.save(registrationDto);
        }
        return "redirect:/registration?success";
    }
}
