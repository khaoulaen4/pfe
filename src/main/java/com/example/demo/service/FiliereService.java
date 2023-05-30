package com.example.demo.service;

import com.example.demo.entity.FiliereEntity;
import com.example.demo.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository repository;

    public FiliereEntity saveFiliere(FiliereEntity f) {

        return repository.save(f);
    }

    public List<FiliereEntity> saveFilieres(List<FiliereEntity> fs) {

        return repository.saveAll(fs);
    }

    public List<FiliereEntity> getFilieres() {
        return repository.findAll();
    }

    public FiliereEntity getFiliereById(int id) {

        return repository.findById(id).orElse(null);
    }

    public FiliereEntity getFiliereByName(String name) {

        return repository.findByName(name);
    }

    public String deleteFiliere(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public FiliereEntity updateFiliere(FiliereEntity f) {
        FiliereEntity existingFiliere= repository.findById(f.getIdFil()).orElse(null);
        existingFiliere.setNomFil(f.getNomFil());
        existingFiliere.setCodeFil(f.getCodeFil());
        existingFiliere.setDepartement(f.getDepartement());
        existingFiliere.setModule(f.getModule());
        return repository.save(existingFiliere);
    }

}
