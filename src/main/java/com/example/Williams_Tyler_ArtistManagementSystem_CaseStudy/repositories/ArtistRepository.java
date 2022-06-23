package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.repositories;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
