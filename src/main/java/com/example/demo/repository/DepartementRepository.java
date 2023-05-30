package com.example.demo.repository;

import com.example.demo.entity.DepartementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<DepartementEntity,Integer> {
    DepartementEntity findByName(String name);
}
