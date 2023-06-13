package com.example.demo.service;

import com.example.demo.entity.Exercice;
import com.example.demo.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExerciceService {
    @Autowired
    private ExerciceRepository exerciceRepository;

    public Exercice saveExercice(Exercice ex) {

        return exerciceRepository.save(ex);
    }

    public List<Exercice> saveExercicees(List<Exercice> exs) {

        return exerciceRepository.saveAll(exs);
    }

    public List<Exercice> getExercices() {

        return exerciceRepository.findAll();
    }

    public Exercice getExerciceById(int id) {

        return exerciceRepository.findById(id).orElse(null);
    }


    public String deleteExercice(int id) {
        exerciceRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Exercice updateExercice(Exercice ex) {
        return exerciceRepository.save(ex);
    }

    public List<Exercice> getAllExercices() {
        return exerciceRepository.findAll();
    }

}
