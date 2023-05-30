package com.example.demo.controler;

import com.example.demo.entity.FiliereEntity;
import com.example.demo.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FiliereController {

    @Autowired
    private FiliereService service;

    @PostMapping("/addFiliere")
    public FiliereEntity addFiliere(@RequestBody FiliereEntity f) {

        return service.saveFiliere(f);
    }

    @PostMapping("/addFilieres")
    public List<FiliereEntity> addFilieres(@RequestBody List<FiliereEntity> fs) {
        return service.saveFilieres(fs);
    }

    @GetMapping("/Filieres")
    public List<FiliereEntity> findAllFilieres() {
        return service.getFilieres();
    }

    @GetMapping("/FiliereById/{id}")
    public FiliereEntity findFiliereById(@PathVariable int id) {

        return service.getFiliereById(id);
    }

    @GetMapping("/Filiere/{name}")
    public FiliereEntity findFiliereByName(@PathVariable String name) {
        return service.getFiliereByName(name);
    }

    @PutMapping("/update")
    public FiliereEntity updateFiliere(@RequestBody FiliereEntity f) {
        return service.updateFiliere(f);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFiliere(@PathVariable int id) {

        return service.deleteFiliere(id);
    }
}
