package com.example.demo.service;

import com.example.demo.entity.QuizEntity;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository repository;

    public QuizEntity saveQuiz(QuizEntity q) {

        return repository.save(q);
    }

    public List<QuizEntity> saveQuizs(List<QuizEntity> qs) {

        return repository.saveAll(qs);
    }

    public List<QuizEntity> getQuizs() {
        return repository.findAll();
    }

    public QuizEntity getQuizById(int id) {

        return repository.findById(id).orElse(null);
    }

    public QuizEntity getQuizByName(String name) {

        return repository.findByName(name);
    }

    public String deleteQuiz(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public QuizEntity updateQuiz(QuizEntity q) {
        QuizEntity existingQuiz= repository.findById(q.getIdQz()).orElse(null);
        existingQuiz.setTitre(q.getTitre());
        existingQuiz.setDateAjoute(q.getDateAjoute());
        existingQuiz.setDateLimite(q.getDateLimite());
        existingQuiz.setModule(q.getModule());
        return repository.save(existingQuiz);
    }
}
