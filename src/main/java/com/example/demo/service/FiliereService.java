package com.example.demo.service;

import com.example.demo.entity.Filiere;
import com.example.demo.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere saveFiliere(Filiere f) {

        return filiereRepository.save(f);
    }

    public List<Filiere> saveFilieres(List<Filiere> fs) {

        return filiereRepository.saveAll(fs);
    }

    public List<Filiere> getFilieres() {

        return filiereRepository.findAll();
    }

    public Filiere getFiliereById(int id) {

        return filiereRepository.findById(id).orElse(null);
    }



    public String deleteFiliere(int id) {
        filiereRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Filiere updateFiliere(Filiere f) {
        return filiereRepository.save(f);
    }

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }
}
