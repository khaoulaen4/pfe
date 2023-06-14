package com.example.demo.repository;

import com.example.demo.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
    //Enseignant findByName(String name);
}
