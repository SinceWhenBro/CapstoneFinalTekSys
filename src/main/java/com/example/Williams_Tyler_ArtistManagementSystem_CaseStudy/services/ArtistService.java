package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> getAllArtists();
    void saveArtist(Artist artist);
    Artist getArtistById(long id);

    void deleteArtistById(long id);

}
