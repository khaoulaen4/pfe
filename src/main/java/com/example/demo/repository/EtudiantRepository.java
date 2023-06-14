package com.example.demo.repository;

import com.example.demo.entity.Etudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiante,Integer> {
    //Etudiante findByName(String name);

}
