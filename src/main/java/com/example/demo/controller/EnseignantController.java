package com.example.demo.controller;

import com.example.demo.entity.Enseignant;
import com.example.demo.entity.Modul;
import com.example.demo.service.EnseignantService;
import com.example.demo.service.ModulService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class EnseignantController {
    private EnseignantService enseignantService;
    private ModulService modulService ;


    public EnseignantController(EnseignantService enseignantService,ModulService modulService) {
        super();
        this.enseignantService = enseignantService;
        this.modulService = modulService;

    }

    // handler method to handle list Enseignant and return mode and view
    @GetMapping("/Enseignante")
    public String listEnseignants(Model model) {
        model.addAttribute("enseignante", enseignantService.getAllEnseignants());

        return "Enseignante/Enseignante";
    }

    @GetMapping("/Enseignante/New")
    public String createEnseignantForm(Model model) {

        // create Enseignant object to hold Enseignant form data
        Enseignant Enseignant = new Enseignant();
        model.addAttribute("enseignante", Enseignant);
        List<Modul> moduls = modulService.getAllModules();
        model.addAttribute("moduls", moduls);
        return "Enseignante/create_Enseignante";

    }

    @PostMapping("/Enseignante/Save")
    public String saveEnseignant(@ModelAttribute("enseignante") Enseignant enseignant) {
        enseignantService.saveEnseignant(enseignant);
        return "redirect:/Enseignante";
    }

    @GetMapping("/Enseignante/edit/{id}")
    public String editEnseignantForm(@PathVariable int id, Model model) {
        model.addAttribute("enseignante", enseignantService.getEnseignantById(id));
        List<Modul> moduls = modulService.getAllModules();
        model.addAttribute("moduls", moduls);
        return "Enseignante/edit_Enseignante";
    }

    @PostMapping("/Enseignante/Update/{id}")
    public String updateEnseignant(@PathVariable int id,
                                    @ModelAttribute("enseignante") Enseignant enseignant,
                                    Model model) {

        enseignant.setIdEng(id);
        enseignantService.updateEnseignant(enseignant);

        return "redirect:/Enseignante";
    }

    @GetMapping("/Enseignante/Delet/{id}")
    public String deleteEnseignant(@PathVariable int id) {
        enseignantService.deleteEnseignant(id);
        return "redirect:/Enseignante";
    }
}
