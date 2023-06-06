package com.example.demo.controller;

import com.example.demo.entity.Administrateur;
import com.example.demo.entity.Departement;
import com.example.demo.service.AdministrateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")

public class AdministrateurController {
    private AdministrateurService administrateurService;

    public AdministrateurController(AdministrateurService administrateurService) {
        super();
        this.administrateurService = administrateurService;
    }
    @ModelAttribute("/user")
    public Administrateur administrateur() {
        return new Administrateur();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        Administrateur Administrateur = new Administrateur();
        model.addAttribute("user", Administrateur);
        System.out.println("first");
        return "Register.html";
    }

    @PostMapping
    public String registerAdministrateurAccount(@ModelAttribute("user") Administrateur administrateur) {
        System.out.println("second");
        administrateurService.saveAdministrateur(administrateur);
        return "redirect:/registration?success";
    }

}
