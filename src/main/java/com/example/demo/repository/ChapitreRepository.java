package com.example.demo.repository;

import com.example.demo.entity.ChapitreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapitreRepository extends JpaRepository<ChapitreEntity,Integer> {
    ChapitreEntity findByName(String name);
}
