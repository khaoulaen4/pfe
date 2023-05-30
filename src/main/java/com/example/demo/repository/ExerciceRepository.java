package com.example.demo.repository;

import com.example.demo.entity.ExerciceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<ExerciceEntity,Integer> {
    ExerciceEntity findByName(String name);
}
