package com.example.demo.controller;

import com.example.demo.entity.Departement;
import com.example.demo.service.DepartementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DepartementController {

    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        super();
        this.departementService = departementService;
    }

    // handler method to handle list Departements and return mode and view
    @GetMapping("/Departements")
    public String listDepartements(Model model) {
        model.addAttribute("departements", departementService.getAllDepartements());

        return "Departement/Admin.html";
    }

    @GetMapping("/Departement/New")
    public String createDepartementForm(Model model) {

        // create Departement object to hold Departement form data
        Departement Departement = new Departement();
        model.addAttribute("departement", Departement);
        return "Departement/create_Departement";

    }

    @PostMapping("/Departement/Save")
    public String saveDepartement(@ModelAttribute("departement") Departement departement) {
        departementService.saveDepartement(departement);
        return "redirect:/Departements";
    }

    @GetMapping("/Departement/edit/{id}")
    public String editDepartementForm(@PathVariable int id, Model model) {
        model.addAttribute("departement", departementService.getDepartementById(id));
        return "Departement/edit_Departement";
    }

    @PostMapping("/Departement/Update/{id}")
    public String updateDepartement(@PathVariable int id,
                                    @ModelAttribute("departement") Departement departement,
                                    Model model) {
        System.out.println("hello");
        //get Departement from database by id
        Departement existingDepartement = departementService.getDepartementById(id);
        existingDepartement.setIdDep(id);
        existingDepartement.setNomDep(departement.getNomDep());
        existingDepartement.setFilieres(departement.getFilieres());
        // save updated Departement object
        departementService.updateDepartement(existingDepartement);
        return "redirect:/Departements";
    }

    // handler method to handle delete Departement request

    @GetMapping("/Departement/Delet/{id}")
    public String deleteDepartement(@PathVariable int id) {
        departementService.deleteDepartement(id);
        return "redirect:/Departements";
    }

}
