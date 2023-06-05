package com.example.demo.controller;

import com.example.demo.entity.Filiere;
import com.example.demo.entity.Modul;
import com.example.demo.service.FiliereService;
import com.example.demo.service.ModulService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller

public class ModulController {
        private ModulService modulService;
        private FiliereService filiereService ;

        public ModulController(ModulService modulService, FiliereService filiereService ) {
            super();
            this.modulService = modulService;
            this.filiereService = filiereService;


        }

        // handler method to handle list Modules and return mode and view
        @GetMapping("/Moduls")
        public String listModuls(Model model) {
            System.out.println("hit");

            model.addAttribute("Moduls", modulService.getAllModules());
            System.out.println("hi");
            return "Module/Modul.html";
        }

        @GetMapping("/Modul/New")
        public String createModulForm(Model model) {

            // create Modul object to hold Modul form data
            Modul Modul = new Modul();
            model.addAttribute("Modul", Modul);
            List<Filiere> filieres = filiereService.getAllFilieres();
            model.addAttribute("filieres", filieres);
            return "Module/create_Modul";

        }

        @PostMapping("/Modul/Save")
        public String saveModul(@ModelAttribute("Modul") Modul modul) {
            System.out.println(modul);
            modulService.saveModule(modul);
            return "redirect:/Moduls";
        }

        @GetMapping("/Modul/edit/{id}")
        public String editModulForm(@PathVariable int id, Model model) {
            model.addAttribute("Modul", modulService.getModuleById(id));
            List<Filiere> filieres = filiereService.getAllFilieres();
            model.addAttribute("filieres", filieres);
            return "Module/edit_Modul";
        }

        @PostMapping("/Modul/Update/{id}")
        public String updateModul(@PathVariable int id,
                                    @ModelAttribute("Modul") Modul modul,
                                    Model model) {
            //System.out.println("hello");
            //get Filiere from database by id
            modul.setIdModul(id);
            // save updated Modul object
            modulService.updateModule(modul);
            return "redirect:/Moduls";
        }

        // handler method to handle delete Modul request

        @GetMapping("/Modul/Delet/{id}")
        public String deleteModul(@PathVariable int id) {
            modulService.deleteModule(id);
            return "redirect:/Moduls";
        }

    }


