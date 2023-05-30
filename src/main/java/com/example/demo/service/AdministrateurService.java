package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.AdministrateurEntity ;
import com.example.demo.repository.AdministrateurRepository;



import java.util.List;
@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository repository;

    public AdministrateurEntity saveAdministrateur(AdministrateurEntity a) {

        return repository.save(a);
    }

    public List<AdministrateurEntity> saveAdministrateurs(List<AdministrateurEntity> as) {

        return repository.saveAll(as);
    }

    public List<AdministrateurEntity> getAdministrateurs() {

        return repository.findAll();
    }

    public AdministrateurEntity getAdministrateurById(int id) {

        return repository.findById(id).orElse(null);
    }

    public AdministrateurEntity getAdministrateurByName(String name) {

        return repository.findByName(name);
    }

    public String deleteAdministrateur(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public AdministrateurEntity updateAdministrateur(AdministrateurEntity a) {
        AdministrateurEntity existingAdministrateur= repository.findById(a.getIdAd()).orElse(null);
        existingAdministrateur.setNomAdm(a.getNomAdm());
        existingAdministrateur.setPrenomAdm(a.getPrenomAdm());
        existingAdministrateur.setEmail(a.getEmail());
        existingAdministrateur.setUserName(a.getUserName());
        existingAdministrateur.setPassword(a.getPassword());
        existingAdministrateur.setDateNaissenceAdm(a.getDateNaissenceAdm());
        existingAdministrateur.setDateInscpAdm(a.getDateInscpAdm());
        existingAdministrateur.setNumTele(a.getNumTele());
        existingAdministrateur.setMessage(a.getMessage());
        return repository.save(existingAdministrateur);
    }

}

