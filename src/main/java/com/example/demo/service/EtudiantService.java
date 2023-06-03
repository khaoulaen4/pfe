package com.example.demo.service;

import com.example.demo.entity.Etudiante;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;



    public Etudiante saveEtudiante(Etudiante e) {

        return etudiantRepository.save(e);
    }

    public List<Etudiante> saveEtudiantes(List<Etudiante> es) {

        return etudiantRepository.saveAll(es);
    }

    public List<Etudiante> getEtudiantes() {

        return etudiantRepository.findAll();
    }

    public Etudiante getEtudianteById(int id) {

        return etudiantRepository.findById(id).orElse(null);
    }


    public String deleteEtudiante(int id) {
        etudiantRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Etudiante updateEtudiante(Etudiante e) {
        Etudiante existingEtudiante= etudiantRepository.findById(e.getId().getIdEtu()).orElse(null);
        existingEtudiante.setFiliere(e.getFiliere());
        existingEtudiante.setMessage(e.getMessage());
        //existingEtudiante.setEmail(e.getEmail());
        //existingEtudiante.setUserName(e.getUserName());
        //existingEtudiante.setPassword(e.getPassword());
        //existingEtudiante.setDateNaissanceEtd(e.getDateNaissanceEtd());
        //existingEtudiante.setDateInscpEtd(e.getDateInscpEtd());
        //existingEtudiante.setNumTele(e.getNumTele());
        //existingEtudiante.setModule(e.getModule());
        return etudiantRepository.save(existingEtudiante);
    }

    public List<Etudiante> getAllEtudiantes() {
        return etudiantRepository.findAll();
    }
}
