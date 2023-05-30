package com.example.demo.repository;

import com.example.demo.entity.AdministrateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<AdministrateurEntity,Integer> {
    AdministrateurEntity findByName(String name);
}
