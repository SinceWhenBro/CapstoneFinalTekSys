package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.controllers;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Manager;
import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/home")
    public String viewManagersPage(Model model){
        model.addAttribute("listManagers", managerService.getAllManagers());
        return "manager_index";
    }

    @GetMapping("/showNewManagerForm")
    public String showNewManagerForm(Model model){
        Manager manager = new Manager();
        model.addAttribute("manager", manager);
        return "new_manager";
    }

    @PostMapping("/saveManager")
    public String saveManager(@ModelAttribute("manager") Manager manager){
        //save manager to database
        managerService.saveManager(manager);
        return "redirect:/manager/home";
    }

    @GetMapping("/showFormForManagerUpdate/{id}")
    public String showFormForManagerUpdate(@PathVariable(value ="id") long id, Model model){
        //get artist from the service
        Manager manager = managerService.getManagerById(id);

        //set artist as a model attribute to prepopulate form
        model.addAttribute("manager", manager);
        return "update_manager";
    }

    @GetMapping("/deleteManager/{id}")
    public String deleteManager(@PathVariable (value ="id") long id){
        //call delete artist method
        this.managerService.deleteManagerById(id);
        return "redirect:/manager/home";
    }


}
