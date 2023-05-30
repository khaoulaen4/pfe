package com.example.demo.service;

import com.example.demo.entity.ExerciceEntity;
import com.example.demo.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExerciceService {
    @Autowired
    private ExerciceRepository repository;

    public ExerciceEntity saveExercice(ExerciceEntity ex) {

        return repository.save(ex);
    }

    public List<ExerciceEntity> saveExercices(List<ExerciceEntity> exs) {

        return repository.saveAll(exs);
    }

    public List<ExerciceEntity> getExercices() {

        return repository.findAll();
    }

    public ExerciceEntity getExerciceById(int id) {

        return repository.findById(id).orElse(null);
    }

    public ExerciceEntity getExerciceByName(String name) {

        return repository.findByName(name);
    }

    public String deleteExercice(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public ExerciceEntity updateExercice(ExerciceEntity ex) {
        ExerciceEntity existingExercice= repository.findById(ex.getIdEx()).orElse(null);
        existingExercice.setNomEx(ex.getNomEx());
        existingExercice.setDateAjoute(ex.getDateAjoute());
        existingExercice.setModule(ex.getModule());
        return repository.save(existingExercice);
    }

}
