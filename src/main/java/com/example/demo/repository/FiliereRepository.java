package com.example.demo.repository;

import com.example.demo.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FiliereRepository extends JpaRepository<Filiere,Integer> {
    //Filiere findByName(String name);
}
