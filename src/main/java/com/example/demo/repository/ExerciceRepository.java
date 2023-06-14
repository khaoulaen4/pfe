package com.example.demo.repository;

import com.example.demo.entity.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ExerciceRepository extends JpaRepository<Exercice,Integer> {
    //Exercice findByName(String name);
}
