package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
        private QuestionRepository questionRepository;

        public Question saveQuestion(Question Qst) {

            return questionRepository.save(Qst);
        }

        public List<Question> saveQuestions(List<Question> Qsts) {

            return questionRepository.saveAll(Qsts);
        }

        public List<Question> getQuestions() {

            return questionRepository.findAll();
        }

        public Question getQuestionById(int id) {

            return questionRepository.findById(id).orElse(null);
        }


        public String deleteQuestion(int id) {
            questionRepository.deleteById(id);
            return " removed !! " + id;
        }

        public Question updateQuestion(Question Qst) {
            Question existingQuestion= questionRepository.findById(Qst.getIdQst()).orElse(null);
            existingQuestion.setQuiz(Qst.getQuiz());
            existingQuestion.setQuestion(Qst.getQuestion());
            existingQuestion.setReponse(Qst.getReponse());
            existingQuestion.setNote(Qst.getNote());

            return questionRepository.save(existingQuestion);
        }

        public List<Question> getAllQuestions() {
            return questionRepository.findAll();
        }
}


