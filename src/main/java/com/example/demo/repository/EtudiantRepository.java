package com.example.demo.repository;

import com.example.demo.entity.EtudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<EtudianteEntity,Integer> {
    EtudianteEntity findByName(String name);

}
