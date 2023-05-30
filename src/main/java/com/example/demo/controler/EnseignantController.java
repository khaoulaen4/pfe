package com.example.demo.controler;

import com.example.demo.entity.EnseignantEntity;
import com.example.demo.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnseignantController {

    @Autowired
    private EnseignantService service;

    @PostMapping("/addEnseignant")
    public EnseignantEntity addEnseignant(@RequestBody EnseignantEntity en) {

        return service.saveEnseignant(en);
    }

    @PostMapping("/addEnseignants")
    public List<EnseignantEntity> addEnseignants(@RequestBody List<EnseignantEntity> ens) {
        return service.saveEnseignants(ens);
    }

    @GetMapping("/Enseignants")
    public List<EnseignantEntity> findAllEnseignants() {
        return service.getEnseignants();
    }

    @GetMapping("/EnseignantById/{id}")
    public EnseignantEntity findEnseignantById(@PathVariable int id) {

        return service.getEnseignantById(id);
    }

    @GetMapping("/Enseignant/{name}")
    public EnseignantEntity findEnseignantByName(@PathVariable String name) {
        return service.getEnseignantByName(name);
    }

    @PutMapping("/update")
    public EnseignantEntity updateEnseignant(@RequestBody EnseignantEntity en) {
        return service.updateEnseignant(en);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEnseignant(@PathVariable int id) {

        return service.deleteEnseignant(id);
    }

}
