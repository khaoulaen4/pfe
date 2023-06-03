package com.example.demo.controller;

import com.example.demo.entity.Departement;
import com.example.demo.entity.Filiere;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.service.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FiliereController {
    private FiliereService filierService;
    private DepartementRepository departementRepository ;

    public FiliereController(FiliereService filierService, DepartementRepository departementRepository) {
        super();
        this.filierService = filierService;
        this.departementRepository = departementRepository;

    }

    // handler method to handle list Filieres and return mode and view
    @GetMapping("/Filieres")
    public String listFilieres(Model model) {
        model.addAttribute("filieres", filierService.getAllFilieres());

        return "Filiere/filiere.html";
    }

    @GetMapping("/Filiere/New")
    public String createFiliereForm(Model model) {

        // create Filiere object to hold Filiere form data
        Filiere Filiere = new Filiere();
        model.addAttribute("filiere", Filiere);
        List<Departement> departements = departementRepository.findAll();
        model.addAttribute("departements", departements);
        return "Filiere/create_Filiere";

    }

    @PostMapping("/Filiere/Save")
    public String saveFiliere(@ModelAttribute("filiere") Filiere filier) {
        filierService.saveFiliere(filier);
        return "redirect:/Filieres";
    }

    @GetMapping("/Filiere/edit/{id}")
    public String editFiliereForm(@PathVariable int id, Model model) {
        model.addAttribute("filiere", filierService.getFiliereById(id));
        List<Departement> departements = departementRepository.findAll();
        model.addAttribute("departements", departements);
        return "Filiere/edit_Filiere";
    }

    @PostMapping("/Filiere/Update/{id}")
    public String updateFiliere(@PathVariable int id,
                                    @ModelAttribute("filiere") Filiere filiere,
                                    Model model) {
        //System.out.println("hello");
        //get Filiere from database by id
//        Filiere existingFiliere = filierService.getFiliereById(id);
//        existingFiliere.setIdFil(id);
//        existingFiliere.setCodeFil(filiere.getCodeFil());
//        existingFiliere.setNomFil(filiere.getNomFil());
            filiere.setIdFil(id);
        // save updated filier object
        filierService.updateFiliere(filiere);
        return "redirect:/Filieres";
    }

    // handler method to handle delete Filiere request

    @GetMapping("/Filiere/Delet/{id}")
    public String deleteFiliere(@PathVariable int id) {
        filierService.deleteFiliere(id);
        return "redirect:/Filieres";
    }

}
