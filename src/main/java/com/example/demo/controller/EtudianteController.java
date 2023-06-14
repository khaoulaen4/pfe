package com.example.demo.controller;

import com.example.demo.entity.Etudiante;
import com.example.demo.entity.Filiere;
import com.example.demo.service.EtudiantService;
import com.example.demo.service.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EtudianteController {
    private EtudiantService etudianteService;
    private FiliereService filiereService ;

    public EtudianteController(EtudiantService etudianteService) {
        super();
        this.etudianteService = etudianteService;
    }
/*    @GetMapping("/Etudiante")
    public String listEtudiantes(Model model) {
        System.out.println("hit");
        model.addAttribute("Etudiante", etudianteService.getAllEtudiantes());
        //System.out.println("hi");
        return "index.html";
    }*/
    @GetMapping("/Etudiante/New")
    public String createEtudianteForm(Model model) {

        // create Etudiante object to hold Etudiante form data
        Etudiante Etudiante = new Etudiante();
        model.addAttribute("etudiante", Etudiante);
     /*   List<Filiere> filieres = filiereService.getAllFilieres();
        model.addAttribute("filieres", filieres);*/

        System.out.println("create");
        return "Register";

    }
    @PostMapping("/Etudiante/Save")
    public String saveEtudiante(@ModelAttribute("etudiante") Etudiante etudiante) {
        System.out.println("Register");

/*
        etudianteService.saveEtudiante(etudiante);
*/
        return "redirect:/Register";
    }






}

