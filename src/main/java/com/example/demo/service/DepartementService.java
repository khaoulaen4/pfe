package com.example.demo.service;

import com.example.demo.entity.DepartementEntity;
import com.example.demo.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository repository;

    public DepartementEntity saveDepartement(DepartementEntity d) {

        return repository.save(d);
    }

    public List<DepartementEntity> saveDepartements(List<DepartementEntity> ds) {

        return repository.saveAll(ds);
    }

    public List<DepartementEntity> getDepartements() {

        return repository.findAll();
    }

    public DepartementEntity getDepartementById(int id) {

        return repository.findById(id).orElse(null);
    }

    public DepartementEntity getDepartementByName(String name) {

        return repository.findByName(name);
    }

    public String deleteDepartement(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public DepartementEntity updateDepartement(DepartementEntity d) {
        DepartementEntity existingDepartement= repository.findById(d.getIdDep()).orElse(null);
        existingDepartement.setNomDep(d.getNomDep());
        return repository.save(existingDepartement);
    }

}
