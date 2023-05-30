package com.example.demo.repository;

import com.example.demo.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<ModuleEntity,Integer> {
    ModuleEntity findByName(String name);
}
