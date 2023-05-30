package com.example.demo.repository;

import com.example.demo.entity.FiliereEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereRepository extends JpaRepository<FiliereEntity,Integer> {
    FiliereEntity findByName(String name);
}
