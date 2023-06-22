package com.example.demo.controller;

import com.example.demo.entity.Etudiante;
import com.example.demo.entity.Filiere;
import com.example.demo.service.EtudiantService;
import com.example.demo.service.FiliereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class EtudianteController {
    private EtudiantService etudianteService;
    private FiliereService filiereService ;

    public EtudianteController(EtudiantService etudianteService, FiliereService filiereService) {
        super();
        this.etudianteService = etudianteService;
        this.filiereService = filiereService;

    }
 @GetMapping("/Etudiante")
    public String listEtudiantes(Model model) {
        model.addAttribute("Etudiante", etudianteService.getAllEtudiantes());
        return "Etudiante/Etudiante";
    }
    @GetMapping("/Etudiantee")
    public String listEtudiante(Model model) {
        model.addAttribute("Etudiante", etudianteService.getAllEtudiantes());
        return "Etudiante/Etudiantee";
    }

    @GetMapping("/Etudiante/New")
    public String createEtudianteForm(Model model) {

        // create Etudiante object to hold Etudiante form data
        Etudiante Etudiante = new Etudiante();
        model.addAttribute("etudiante", Etudiante);
        List<Filiere> filieres = filiereService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        System.out.println("create");
        return "Register";

    }
/* d ajoute*/
    @PostMapping("/Etudiantee/Save")
    public String saveEtudiantee(@ModelAttribute("etudiante") Etudiante etudiante) {
        Etudiante etudiant = etudianteService.saveEtudiante(etudiante);
        System.out.println(etudiante.getUserName());
        return "redirect:/Etudiantee/New";
    }

    @GetMapping("/Etudiantee/New")
    public String createEtudianteeForm(Model model) {
        // create Etudiante object to hold Etudiante form data
        Etudiante Etudiante = new Etudiante();
        model.addAttribute("etudiante", Etudiante);
        return "Etudiante/create_Etudiante";

    }
    /*f ajoute*/
    @PostMapping("/Etudiante/Save")
    public String saveEtudiante(@ModelAttribute("etudiante") Etudiante etudiante) {
        Etudiante etudiant = etudianteService.saveEtudiante(etudiante);
        System.out.println(etudiante.getUserName());
        return "redirect:/Etudiante/New";
    }
    @GetMapping("/Etudiante/edit/{id}")
    public String editEnseignantForm(@PathVariable int id, Model model) {
        model.addAttribute("Etudiante", etudianteService.getEtudianteById(id));
        List<Filiere> filieres = filiereService.getAllFilieres();
        model.addAttribute("filieres", filieres);

        return "Etudiante/edit_Etudiante";
    }

    @PostMapping("/Etudiante/Update/{id}")
    public String updateEtudiante(@PathVariable int id,
                                   @ModelAttribute("Etudiante") Etudiante etudiante,
                                   Model model) {

        etudiante.setIdEtu(id);
        etudianteService.updateEtudiante(etudiante);

        return "redirect:/Etudiante";
    }
    @GetMapping("/Etudiante/Delet/{id}")
    public String deleteEtudiante(@PathVariable int id) {
        etudianteService.deleteEtudiante(id);
        return "redirect:/Etudiante";
    }


}