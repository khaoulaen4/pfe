package com.example.demo.controller;

import com.example.demo.entity.Chapitre;
import com.example.demo.entity.Modul;
import com.example.demo.service.ChapitreService;
import com.example.demo.service.ModulService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller

public class ChapitreController {

    @Value("${upload.directory}")
    private String uploadDirectory;
    private ChapitreService chapitreService;
    private ModulService modulService ;

    public ChapitreController(ChapitreService chapitreService ,ModulService modulService) {
        super();
        this.chapitreService = chapitreService;
        this.modulService = modulService;

    }
    @GetMapping("/Chapitre")
    public String listChapitres(Model model) {

        model.addAttribute("Chapitre", chapitreService.getAllChapitres());
        return "Chapitre/Chapitre";
    }
    @GetMapping("/course")
    public String afficheChapitres(Model model) {

        model.addAttribute("Chapitre", chapitreService.getAllChapitres());
        return "course";
    }
    @GetMapping("/AfficheCoure")
    public String AfficheCoures(Model model) {

        model.addAttribute("Chapitre", chapitreService.getAllChapitres());
        return "AfficheCoure";
    }
    @GetMapping("/Chapitre/New")
    public String createChapitreForm(Model model) {

        // create Chapitre object to hold Chapitre form data
        Chapitre Chapitre = new Chapitre();
        model.addAttribute("Chapitre", Chapitre);
        List<Modul> modul = modulService.getAllModules();
        model.addAttribute("modul", modul);

        return "Chapitre/create_Chapitre";
    }
    @PostMapping("/Chapitre/Save")
    public String saveChapitre(@ModelAttribute("Chapitre") Chapitre chapitre ,
                               @RequestParam("file") MultipartFile file ,
                               @RequestParam("imag") MultipartFile imag) {
        try {
            // Generate a unique file name
            String fileName = UUID.randomUUID().toString() + ".pdf";
            // Save the file to the upload directory
            Path filePath = Paths.get(uploadDirectory, fileName);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            chapitre.setContenue(fileName);

            String imgName = UUID.randomUUID().toString() + ".jpg";
            // Save the image to the upload directory
            Path imagPath = Paths.get(uploadDirectory, imgName);
            Files.copy(imag.getInputStream(), imagPath, StandardCopyOption.REPLACE_EXISTING);
            chapitre.setImage(imgName);
            // image stored successfully, perform additional logic if needed
            chapitreService.saveChapitre(chapitre);
            return "redirect:/Chapitre";
        }
        catch (IOException e) {
            // Handle file upload error
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    @GetMapping("/Chapitre/edit/{id}")
    public String editModulForm(@PathVariable int id, Model model) {
        model.addAttribute("Chapitre", chapitreService.getChapitreById(id));
        List<Modul> modul = modulService.getAllModules();
        model.addAttribute("modul", modul);
        return "Chapitre/edit_Chapitre";
    }

    @PostMapping("/Chapitre/Update/{id}")
    public String updateModul(@PathVariable int id,
                              @ModelAttribute("Chapitre") Chapitre chapitre,
                              Model model,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam("imag") MultipartFile imag) {
        try {
            // Generate a unique file name
            String fileName = UUID.randomUUID().toString() + ".pdf";

            // Save the file to the upload directory
            Path filePath = Paths.get(uploadDirectory, fileName);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            chapitre.setContenue(fileName);

            String imgName = UUID.randomUUID().toString() + ".jpg";
            // Save the image to the upload directory
            Path imagPath = Paths.get(uploadDirectory, imgName);
            Files.copy(imag.getInputStream(), imagPath, StandardCopyOption.REPLACE_EXISTING);
            chapitre.setImage(imgName);
            //get chapitre from database by id
            chapitre.setIdChpt(id);
            // save updated chapitre object
            chapitreService.updateChapitre(chapitre);
            return "redirect:/Chapitre";
        }
        catch (IOException e) {
            // Handle file upload error
            e.printStackTrace();
            return "redirect:/error";
        }
    }
    @GetMapping("/Chapitre/Delet/{id}")
    public String deleteChapitre(@PathVariable int id) {
        chapitreService.deleteChapitre(id);
        return "redirect:/Chapitre";
    }

}
