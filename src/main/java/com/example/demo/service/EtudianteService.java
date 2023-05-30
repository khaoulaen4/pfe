package com.example.demo.service;

import com.example.demo.entity.EtudianteEntity;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudianteService {
    @Autowired
    private EtudiantRepository repository;

    public EtudianteEntity saveEtudiant(EtudianteEntity e) {
        return repository.save(e);
    }

    public List<EtudianteEntity> saveEtudiantes(List<EtudianteEntity> es) {
        return repository.saveAll(es);
    }

    public List<EtudianteEntity> getEtudiants() {
        return repository.findAll();
    }

    public EtudianteEntity getEtudiantById(int id) {
        return repository.findById(id).orElse(null);
    }

    public EtudianteEntity getEtudiantByName(String name) {
        return repository.findByName(name);
    }

    public String deleteEtudiant(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public EtudianteEntity updateEtudiant(EtudianteEntity e) {
        EtudianteEntity existingEtudiant= repository.findById(e.getIdEtu()).orElse(null);
        existingEtudiant.setNomEtu(e.getNomEtu());
        existingEtudiant.setPrenomEtu(e.getPrenomEtu());
        existingEtudiant.setEmail(e.getEmail());
        existingEtudiant.setUserName(e.getUserName());
        existingEtudiant.setPassword(e.getPassword());
        existingEtudiant.setDateNaissanceEtd(e.getDateNaissanceEtd());
        existingEtudiant.setDateInscpEtd(e.getDateInscpEtd());
        existingEtudiant.setFilier(e.getFilier());
        existingEtudiant.setNumTele(e.getNumTele());
        existingEtudiant.setNote(e.getNote());
        existingEtudiant.setModule(e.getModule());
        existingEtudiant.setMessage(e.getMessage());
        return repository.save(existingEtudiant);
    }
}
