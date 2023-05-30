package com.example.demo.controler;

import com.example.demo.entity.EtudianteEntity;
import com.example.demo.service.EtudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudianteController {

    @Autowired
    private EtudianteService service;

    @PostMapping("/addEtudiante")
    public EtudianteEntity addEtudiante(@RequestBody EtudianteEntity e) {
        return service.saveEtudiant(e);
    }

    @PostMapping("/addEtudiantes")
    public List<EtudianteEntity> addEtudiantes(@RequestBody List<EtudianteEntity> es) {
        return service.saveEtudiantes(es);
    }

    @GetMapping("/Etudiants")
    public List<EtudianteEntity> findAllEtudiantes() {
        return service.getEtudiants();
    }

    @GetMapping("/EtudiantById/{id}")
    public EtudianteEntity findEtudianteById(@PathVariable int id) {
        return service.getEtudiantById(id);
    }

    @GetMapping("/Etudiant/{name}")
    public EtudianteEntity findEtudianteByName(@PathVariable String name) {

        return service.getEtudiantByName(name);
    }

    @PutMapping("/update")
    public EtudianteEntity updateEtudiante(@RequestBody EtudianteEntity e) {
        return service.updateEtudiant(e);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEtudiante(@PathVariable int id) {

        return service.deleteEtudiant(id);
    }
}
