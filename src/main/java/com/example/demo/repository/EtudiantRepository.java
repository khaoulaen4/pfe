package com.example.demo.repository;

import com.example.demo.entity.Etudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiante,Integer> {
    //Etudiante findByName(String name);

}
