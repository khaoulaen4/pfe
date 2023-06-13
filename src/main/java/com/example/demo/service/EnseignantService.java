package com.example.demo.service;

import com.example.demo.entity.Enseignant;
import com.example.demo.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant saveEnseignant(Enseignant en) {

        return enseignantRepository.save(en);
    }

    public List<Enseignant> saveEnseignants(List<Enseignant> ens) {

        return enseignantRepository.saveAll(ens);
    }

    public List<Enseignant> getEnseignants() {

        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(int id) {

        return enseignantRepository.findById(id).orElse(null);
    }


    public String deleteEnseignant(int id) {
        enseignantRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Enseignant updateEnseignant(Enseignant en) {

        return enseignantRepository.save(en);
    }

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }
}
