package com.example.demo.service;

import com.example.demo.entity.Departement;
import com.example.demo.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public Departement saveDepartement(Departement d) {

        return departementRepository.save(d);
    }

    public List<Departement> saveDepartements(List<Departement> ds) {

        return departementRepository.saveAll(ds);
    }

    public List<Departement> getDepartements() {

        return departementRepository.findAll();
    }

    public Departement getDepartementById(int id) {

        return departementRepository.findById(id).orElse(null);
    }



    public String deleteDepartement(int id) {
        departementRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Departement updateDepartement(Departement d) {
        Departement existingDepartement= departementRepository.findById(d.getIdDep()).orElse(null);
        existingDepartement.setNomDep(d.getNomDep());
        return departementRepository.save(existingDepartement);
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }
}
