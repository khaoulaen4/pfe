package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Modul;
import org.springframework.stereotype.Repository;

@Repository

public interface ModuleRepository extends JpaRepository< Modul,Integer> {
    //Modul findByName(String name);
}
