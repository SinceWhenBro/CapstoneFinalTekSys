package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.services;

import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models.Manager;
import com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerRepository managerRepository;

    //Build out custom query for all managers with "Yes" as availability
    @Override
    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }

    @Override
    public void saveManager(Manager manager){
        this.managerRepository.save(manager);
    }

    @Override
    public Manager getManagerById(long id){
        Optional<Manager> optional = managerRepository.findById(id);
        Manager manager = null;
        if(optional.isPresent()){
            manager = optional.get();
        } else{
            throw new RuntimeException("Manager not found for id: " + id);
        }
        return manager;
    }

    @Override
    public void deleteManagerById(long id){
        this.managerRepository.deleteById(id);
    }
}
