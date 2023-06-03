package com.example.demo.repository;

import com.example.demo.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
    //Enseignant findByName(String name);
}
