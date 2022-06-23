package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.repositories;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
