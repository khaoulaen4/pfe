package com.example.demo.service;

import com.example.demo.entity.ChapitreEntity;
import com.example.demo.repository.ChapitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChapitreService {


    @Autowired
    private ChapitreRepository repository;

    public ChapitreEntity saveChapitre(ChapitreEntity c) {

        return repository.save(c);
    }

    public List<ChapitreEntity> saveChapitres(List<ChapitreEntity> cs) {

        return repository.saveAll(cs);
    }

    public List<ChapitreEntity> getChapitres() {

        return repository.findAll();
    }

    public ChapitreEntity getChapitreById(int id) {

        return repository.findById(id).orElse(null);
    }

    public ChapitreEntity getChapitreByName(String name) {

        return repository.findByName(name);
    }

    public String deleteChapitre(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public ChapitreEntity updateChapitre(ChapitreEntity c) {
        ChapitreEntity existingChapitre= repository.findById(c.getIdChpt()).orElse(null);
        existingChapitre.setTitre(c.getTitre());
        existingChapitre.setModule(c.getModule());
        existingChapitre.setDateAjoute(c.getDateAjoute());
        return repository.save(existingChapitre);
    }
}
