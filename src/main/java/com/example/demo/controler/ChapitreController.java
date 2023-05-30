package com.example.demo.controler;

import com.example.demo.entity.ChapitreEntity;
import com.example.demo.service.ChapitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ChapitreController {

        @Autowired
        private ChapitreService service;

        @PostMapping("/addAChapitre")
        public ChapitreEntity addChapitre(@RequestBody ChapitreEntity c) {
            return service.saveChapitre(c);
        }

        @PostMapping("/addChapitres")
        public List<ChapitreEntity> addChapitres(@RequestBody List<ChapitreEntity> cs) {
            return service.saveChapitres(cs);
        }

        @GetMapping("/Chapitres")
        public List<ChapitreEntity> findAllChapitres() {
            return service.getChapitres();
        }

        @GetMapping("/ChapitreById/{id}")
        public ChapitreEntity findAChapitreById(@PathVariable int id) {
            return service.getChapitreById(id);
        }

        @GetMapping("/Chapitre/{name}")
        public ChapitreEntity findChapitreByName(@PathVariable String name) {
            return service.getChapitreByName(name);
        }

        @PutMapping("/update")
        public ChapitreEntity updateChapitre(@RequestBody ChapitreEntity c) {
            return service.updateChapitre(c);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteChapitre(@PathVariable int id) {

            return service.deleteChapitre(id);
        }
    }
