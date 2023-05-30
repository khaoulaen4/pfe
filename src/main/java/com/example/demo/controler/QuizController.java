package com.example.demo.controler;

import com.example.demo.entity.QuizEntity;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class QuizController {
    @Autowired
    private QuizService service;

    @PostMapping("/addQuiz")
    public QuizEntity addQuiz(@RequestBody QuizEntity q) {

        return service.saveQuiz(q);
    }

    @PostMapping("/addQuizs")
    public List<QuizEntity> addFQuizs(@RequestBody List<QuizEntity> qs) {
        return service.saveQuizs(qs);
    }

    @GetMapping("/Quizs")
    public List<QuizEntity> findAllQuizs() {
        return service.getQuizs();
    }

    @GetMapping("/QuizById/{id}")
    public QuizEntity findQuizById(@PathVariable int id) {

        return service.getQuizById(id);
    }

    @GetMapping("/Quiz/{name}")
    public QuizEntity findQuizByName(@PathVariable String name) {
        return service.getQuizByName(name);
    }

    @PutMapping("/update")
    public QuizEntity updateQuiz(@RequestBody QuizEntity q) {
        return service.updateQuiz(q);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable int id) {

        return service.deleteQuiz(id);
    }
}
