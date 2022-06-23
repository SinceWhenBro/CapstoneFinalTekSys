package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Artist;
import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getAllManagers();

    void saveManager(Manager manager);
    Manager getManagerById(long id);

    void deleteManagerById(long id);
}
