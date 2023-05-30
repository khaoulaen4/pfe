package com.example.demo.service;

import com.example.demo.entity.EnseignantEntity;
import com.example.demo.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository repository;

    public EnseignantEntity saveEnseignant(EnseignantEntity en) {

        return repository.save(en);
    }

    public List<EnseignantEntity> saveEnseignants(List<EnseignantEntity> ens) {

        return repository.saveAll(ens);
    }

    public List<EnseignantEntity> getEnseignants() {

        return repository.findAll();
    }

    public EnseignantEntity getEnseignantById(int id) {

        return repository.findById(id).orElse(null);
    }

    public EnseignantEntity getEnseignantByName(String name) {

        return repository.findByName(name);
    }

    public String deleteEnseignant(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public EnseignantEntity updateEnseignant(EnseignantEntity en) {
        EnseignantEntity existingEnseignant= repository.findById(en.getIdEng()).orElse(null);
        existingEnseignant.setNomEng(en.getNomEng());
        existingEnseignant.setPrenomEng(en.getPrenomEng());
        existingEnseignant.setEmail(en.getEmail());
        existingEnseignant.setUserName(en.getUserName());
        existingEnseignant.setPassword(en.getPassword());
        existingEnseignant.setDateNaissanceEng(en.getDateNaissanceEng());
        existingEnseignant.setDateInscpEng(en.getDateInscpEng());
        existingEnseignant.setNumTele(en.getNumTele());
        existingEnseignant.setModule(en.getModule());
        existingEnseignant.setMessage(en.getMessage());
        return repository.save(existingEnseignant);
    }
}
