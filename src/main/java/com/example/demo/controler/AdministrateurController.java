package com.example.demo.controler;

import com.example.demo.entity.AdministrateurEntity;
import com.example.demo.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AdministrateurController {

        @Autowired
        private AdministrateurService service;

        @PostMapping("/addAdministrateur")
        public AdministrateurEntity addAdministrateur(@RequestBody AdministrateurEntity a) {
            return service.saveAdministrateur(a);
        }

        @PostMapping("/addAdministrateurs")
        public List<AdministrateurEntity> addAdministrateurs(@RequestBody List<AdministrateurEntity> as) {
            return service.saveAdministrateurs(as);
        }

        @GetMapping("/Administrateurs")
        public List<AdministrateurEntity> findAllAdministrateurs() {
            return service.getAdministrateurs();
        }

        @GetMapping("/AdministrateurById/{id}")
        public AdministrateurEntity findAdministrateurById(@PathVariable int id) {
            return service.getAdministrateurById(id);
        }

        @GetMapping("/Administrateur/{name}")
        public AdministrateurEntity findAdministrateurByName(@PathVariable String name) {
            return service.getAdministrateurByName(name);
        }

        @PutMapping("/update")
        public AdministrateurEntity updateAdministrateur(@RequestBody AdministrateurEntity a) {
            return service.updateAdministrateur(a);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteAdministrateur(@PathVariable int id) {

            return service.deleteAdministrateur(id);
        }
}
