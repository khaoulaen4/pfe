package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Modul;
public interface ModuleRepository extends JpaRepository< Modul,Integer> {
    //Modul findByName(String name);
}
