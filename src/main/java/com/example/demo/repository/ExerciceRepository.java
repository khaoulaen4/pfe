package com.example.demo.repository;

import com.example.demo.entity.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<Exercice,Integer> {
    //Exercice findByName(String name);
}
