package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.controllers;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Artist;
import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/home")
    public String viewArtistsPage(Model model){
        model.addAttribute("listArtists", artistService.getAllArtists());
        return "artist_index";
    }

    @GetMapping("/showNewArtistForm")
    public String showNewArtistForm(Model model){
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "new_artist";
    }

    @PostMapping("/saveArtist")
    public String saveArtist(@ModelAttribute("artist") Artist artist){
        //save artist to database
        artistService.saveArtist(artist);
        return "redirect:/artist/home";
    }

    @GetMapping("/showFormForArtistUpdate/{id}")
    public String showFormforArtistUpdate(@PathVariable(value ="id") long id, Model model){
        //get artist from the service
        Artist artist = artistService.getArtistById(id);
        //set artist as a model attribute to prepopulate form
        model.addAttribute("artist", artist);
        return "update_artist";
    }

    @GetMapping("/deleteArtist/{id}")
    public String deleteArtist(@PathVariable (value ="id") long id){
        //call delete artist method
        this.artistService.deleteArtistById(id);
        return "redirect:/artist/home";
    }
}
