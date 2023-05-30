package com.example.demo.service;

import com.example.demo.entity.QuestionEntity;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public QuestionEntity saveQuestion(QuestionEntity qt) {

        return repository.save(qt);
    }

    public List<QuestionEntity> saveQuestions(List<QuestionEntity> qts) {

        return repository.saveAll(qts);
    }

    public List<QuestionEntity> getQuestions() {
        return repository.findAll();
    }

    public QuestionEntity getQuestionById(int id) {

        return repository.findById(id).orElse(null);
    }

    public QuestionEntity getQuestionByName(String name) {

        return repository.findByName(name);
    }

    public String deleteQuestion(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public QuestionEntity updateQuestion(QuestionEntity qt) {
        QuestionEntity existingQuestion= repository.findById(qt.getIdQst()).orElse(null);
        existingQuestion.setQuestion(qt.getQuestion());
        existingQuestion.setReponse(qt.getReponse());
        existingQuestion.setNote(qt.getNote());
        existingQuestion.setQuiz(qt.getQuiz());
        return repository.save(existingQuestion);
    }
}
