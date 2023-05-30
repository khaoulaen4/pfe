package com.example.demo.service;

import com.example.demo.entity.ModuleEntity;
import com.example.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository repository;

    public ModuleEntity saveModule(ModuleEntity m) {

        return repository.save(m);
    }

    public List<ModuleEntity> saveModules(List<ModuleEntity> ms) {

        return repository.saveAll(ms);
    }

    public List<ModuleEntity> getModules() {
        return repository.findAll();
    }

    public ModuleEntity getModuleById(int id) {

        return repository.findById(id).orElse(null);
    }

    public ModuleEntity getModuleByName(String name) {

        return repository.findByName(name);
    }

    public String deleteModule(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public ModuleEntity updateModule(ModuleEntity m) {
        ModuleEntity existingModule= repository.findById(m.getIdModul()).orElse(null);
        existingModule.setNomModul(m.getNomModul());
        existingModule.setFilier(m.getFilier());
        existingModule.setEnseignante(m.getEnseignante());
        return repository.save(existingModule);
    }
}
