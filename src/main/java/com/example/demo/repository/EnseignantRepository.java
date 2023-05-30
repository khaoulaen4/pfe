package com.example.demo.repository;

import com.example.demo.entity.EnseignantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<EnseignantEntity,Integer> {
    EnseignantEntity findByName(String name);
}
