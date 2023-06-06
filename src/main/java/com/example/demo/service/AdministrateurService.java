package com.example.demo.service;

import com.example.demo.entity.Administrateur;
import com.example.demo.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministrateurService {
    @Autowired
    private  AdministrateurRepository administrateurRepository;

    public  Administrateur saveAdministrateur(Administrateur a) {

        return administrateurRepository.save(a);
    }

    public List<Administrateur> saveAdministrateurs(List<Administrateur> as) {

        return administrateurRepository.saveAll(as);
    }

    public List<Administrateur> getAdministrateurs() {

        return administrateurRepository.findAll();
    }

    public Administrateur getAdministrateurById(int id) {

        return administrateurRepository.findById(id).orElse(null);
    }


    public String deleteAdministrateur(int id) {
        administrateurRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Administrateur updateAdministrateur(Administrateur a) {
        Administrateur existingAdministrateur= administrateurRepository.findById(a.getIdAd()).orElse(null);
        existingAdministrateur.setNomAdm(a.getNomAdm());
        existingAdministrateur.setPrenomAdm(a.getPrenomAdm());
        existingAdministrateur.setEmail(a.getEmail());
        existingAdministrateur.setUserName(a.getUserName());
        existingAdministrateur.setPassword(a.getPassword());
        existingAdministrateur.setDateNaissenceAdm(a.getDateNaissenceAdm());
        existingAdministrateur.setDateInscpAdm(a.getDateInscpAdm());
        existingAdministrateur.setNumTele(a.getNumTele());
        return administrateurRepository.save(existingAdministrateur);
    }

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }
}

