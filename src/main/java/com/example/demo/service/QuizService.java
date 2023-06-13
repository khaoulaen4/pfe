package com.example.demo.service;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired

        private QuizRepository quizRepository;

        public Quiz saveQuiz(Quiz Qz) {

            return quizRepository.save(Qz);
        }

        public List<Quiz> saveQuizs(List<Quiz> Qzs) {

            return quizRepository.saveAll(Qzs);
        }

        public List<Quiz> getQuizs() {

            return quizRepository.findAll();
        }

        public Quiz getQuizById(int id) {

            return quizRepository.findById(id).orElse(null);
        }


        public String deleteQuiz(int id) {
            quizRepository.deleteById(id);
            return " removed !! " + id;
        }

        public Quiz updateQuiz(Quiz Qz) {

            return quizRepository.save(Qz);
        }

        public List<Quiz> getAllQuizs() {
            return quizRepository.findAll();
        }
    }




