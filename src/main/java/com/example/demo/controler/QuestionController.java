package com.example.demo.controler;

import com.example.demo.entity.QuestionEntity;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class QuestionController {
    @Autowired
    private QuestionService service;

    @PostMapping("/addQuestion")
    public QuestionEntity addQuestion(@RequestBody QuestionEntity qt) {

        return service.saveQuestion(qt);
    }

    @PostMapping("/addQuestions")
    public List<QuestionEntity> addQuestions(@RequestBody List<QuestionEntity> qts) {
        return service.saveQuestions(qts);
    }

    @GetMapping("/Questions")
    public List<QuestionEntity> findAllQuestions() {
        return service.getQuestions();
    }

    @GetMapping("/QuestionById/{id}")
    public QuestionEntity findQuestionById(@PathVariable int id) {

        return service.getQuestionById(id);
    }

    @GetMapping("/Question/{name}")
    public QuestionEntity findQuestionByName(@PathVariable String name) {
        return service.getQuestionByName(name);
    }

    @PutMapping("/update")
    public QuestionEntity updateQuestion(@RequestBody QuestionEntity qt) {
        return service.updateQuestion(qt);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {

        return service.deleteQuestion(id);
    }
}
