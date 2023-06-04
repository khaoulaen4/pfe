package com.example.demo.service;

import com.example.demo.entity.Modul;
import com.example.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Modul saveModule(Modul md) {

        return moduleRepository.save(md);
    }

    public List<Modul> saveModules(List<Modul> mds) {

        return moduleRepository.saveAll(mds);
    }

    public List<Modul> getModules() {

        return moduleRepository.findAll();
    }

    public Modul getModuleById(int id) {

        return moduleRepository.findById(id).orElse(null);
    }


    public String deleteModule(int id) {
        moduleRepository.deleteById(id);
        return " removed !! " + id;
    }

    public Modul updateModule(Modul md) {
/*        Modul existingModule= moduleRepository.findById(md.getIdModul()).orElse(null);
        existingModule.setNomModul(md.getNomModul());
        existingModule.setFilier(md.getFilier());
//        existingModule.setFilieres(md.getFilieres());
        existingModule.setEnseignante(md.getEnseignante());
        existingModule.setEnseignants(md.getEnseignants());
        existingModule.setEtudiantes(md.getEtudiantes());
        existingModule.setExercices(md.getExercices());
        existingModule.setChapitres(md.getChapitres());
        existingModule.setQuizs(md.getQuizs());*/

        return moduleRepository.save(md);
    }

    public List<Modul> getAllModules() {
        return moduleRepository.findAll();
    }}
