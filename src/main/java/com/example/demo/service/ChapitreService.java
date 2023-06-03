package com.example.demo.service;

import com.example.demo.entity.Chapitre;
import com.example.demo.repository.ChapitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ChapitreService {
    @Autowired
    private ChapitreRepository chapitreRepository;

    public Chapitre saveChapitre(Chapitre c) {

        return chapitreRepository.save(c);
    }

    public List<Chapitre> saveChapitres(List<Chapitre> cs) {

        return chapitreRepository.saveAll(cs);
    }

    public List<Chapitre> getChapitres() {

        return chapitreRepository.findAll();
    }

    public Chapitre getChapitreById(int id) {

        return chapitreRepository.findById(id).orElse(null);
    }


    public String deleteChapitre(int id) {
        chapitreRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Chapitre updateChapitre(Chapitre c) {
        Chapitre existingChapitre= chapitreRepository.findById(c.getIdChpt()).orElse(null);
        existingChapitre.setTitre(c.getTitre());
        existingChapitre.setModule(c.getModule());
        existingChapitre.setDateAjoute(c.getDateAjoute());
        return chapitreRepository.save(existingChapitre);
    }

    public List<Chapitre> getAllChapitres() {
        return chapitreRepository.findAll();
    }

}
