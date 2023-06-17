package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.service.QuestionService;
import com.example.demo.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
//@RequestMapping("/quizzes")
public class QuizController {
    private  QuizService quizService;
    private QuestionService questionService;
    public QuizController(QuizService quizService ,QuestionService questionService) {

        this.quizService = quizService;
        this.questionService = questionService;
    }
    @PostMapping("/quizzes")
    public String createQuiz(@RequestParam("titre") String titre,
                             @RequestParam("notes[]") Float[] notes ,
                             @RequestParam("reponses[]") String[] reponses,
                             @RequestParam("question[]") String[] questions) {
//      return quizService.saveQuiz(quiz);
        Quiz quiz = new Quiz();
        quiz.setTitre(titre);
        quiz = quizService.saveQuiz(quiz);
        for (int i=0; i<questions.length;i++){
            Question question = new Question();
            question.setQuiz(quiz);
            question.setQuestion(questions[i]);
            question.setNote(notes[i]);
            question.setReponse(reponses[(i*4)]);
            question.setOption1(reponses[(i*4)+1]);
            question.setOption2(reponses[(i*4)+2]);
            question.setOption3(reponses[(i*4)+3]);
            questionService.saveQuestion(question);
        }

       /* for(String as : reponses){
            System.out.println(as);
        }*/
        return "redirect:/addquiz";
    }
    @GetMapping("/addquiz")
    public String getAllQuizzes() {
      //quizService.getAllQuizs();
        return "Quiz/Quiz" ;
//        return "get";
//
    }
    // Other endpoints as per your application's requirements
}
