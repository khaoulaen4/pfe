package com.example.demo.repository;

import com.example.demo.entity.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapitreRepository extends JpaRepository<Chapitre,Integer> {
    //Chapitre findByName(String name);
}
