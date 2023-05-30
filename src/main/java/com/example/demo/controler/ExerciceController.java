package com.example.demo.controler;

import com.example.demo.entity.ExerciceEntity;
import com.example.demo.service.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciceController {

    @Autowired
    private ExerciceService service;

    @PostMapping("/addExercice")
    public ExerciceEntity addExercice(@RequestBody ExerciceEntity ex) {

        return service.saveExercice(ex);
    }

    @PostMapping("/addExercices")
    public List<ExerciceEntity> addExercices(@RequestBody List<ExerciceEntity> exs) {
        return service.saveExercices(exs);
    }

    @GetMapping("/Exercices")
    public List<ExerciceEntity> findAllExercices() {
        return service.getExercices();
    }

    @GetMapping("/ExerciceById/{id}")
    public ExerciceEntity findExerciceById(@PathVariable int id) {

        return service.getExerciceById(id);
    }

    @GetMapping("/Exercice/{name}")
    public ExerciceEntity findExerciceByName(@PathVariable String name) {
        return service.getExerciceByName(name);
    }

    @PutMapping("/update")
    public ExerciceEntity updateExercice(@RequestBody ExerciceEntity ex) {
        return service.updateExercice(ex);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExercice(@PathVariable int id) {

        return service.deleteExercice(id);
    }

}
