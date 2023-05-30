package com.example.demo.controler;

import com.example.demo.entity.DepartementEntity;
import com.example.demo.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController {

    @Autowired
    private DepartementService service;

    @PostMapping("/addDepartement")
    public DepartementEntity addDepartement(@RequestBody DepartementEntity d) {

        return service.saveDepartement(d);
    }

    @PostMapping("/addDepartements")
    public List<DepartementEntity> addDepartements(@RequestBody List<DepartementEntity> ds) {
        return service.saveDepartements(ds);
    }

    @GetMapping("/Departements")
    public List<DepartementEntity> findAllDepartements() {
        return service.getDepartements();
    }

    @GetMapping("/DepartementById/{id}")
    public DepartementEntity findDepartementById(@PathVariable int id) {

        return service.getDepartementById(id);
    }

    @GetMapping("/Departement/{name}")
    public DepartementEntity findDepartementByName(@PathVariable String name) {
        return service.getDepartementByName(name);
    }

    @PutMapping("/update")
    public DepartementEntity updateDepartement(@RequestBody DepartementEntity d) {
        return service.updateDepartement(d);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartement(@PathVariable int id) {

        return service.deleteDepartement(id);
    }

}
