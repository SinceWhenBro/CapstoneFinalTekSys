package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Artist;
import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    //Build out custom query for all managers with "Independent" as label
    @Override
    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

    @Override
    public void saveArtist(Artist artist){
        this.artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(long id){
        Optional<Artist> optional = artistRepository.findById(id);
        Artist artist = null;
        if(optional.isPresent()){
            artist = optional.get();
        } else{
            throw new RuntimeException("Artist not found for id: " + id);
        }
        return artist;
    }

    @Override
    public void deleteArtistById(long id){
        this.artistRepository.deleteById(id);
    }
}
