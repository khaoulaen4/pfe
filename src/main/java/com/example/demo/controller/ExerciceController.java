package com.example.demo.controller;

import com.example.demo.entity.Exercice;
import com.example.demo.entity.Modul;
import com.example.demo.service.ExerciceService;
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
public class ExerciceController {
    @Value("${upload.directory}")
    private String uploadDirectory;
    private ExerciceService exerciceService;
    private ModulService modulService ;

    public ExerciceController(ExerciceService exerciceService ,ModulService modulService) {
        super();
        this.exerciceService = exerciceService;
        this.modulService = modulService;

    }
    @GetMapping("/Exercice")
    public String listExercices(Model model) {

        model.addAttribute("Exercice", exerciceService.getAllExercices());
        return "Exercice/Exercice";
    }
    @GetMapping("/Exercice/New")
    public String createExerciceForm(Model model) {

        // create Exercice object to hold Exercice form data
        Exercice Exercice = new Exercice();
        model.addAttribute("Exercice", Exercice);
        List<Modul> modul = modulService.getAllModules();
        model.addAttribute("modul", modul);

        return "Exercice/create_Exercice";
    }
    @PostMapping("/Exercice/Save")
    public String saveExercice(@ModelAttribute("Exercice") Exercice exercice ,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("imag") MultipartFile imag) {
        try {
            // Generate a unique file name
            String fileName = UUID.randomUUID().toString() + ".pdf";
            // Save the file to the upload directory
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            exercice.setContenue(fileName);
            // File stored successfully, perform additional logic if needed
            String imgName = UUID.randomUUID().toString() + ".jpg";
            // Save the image to the upload directory
            Path imagPath = Paths.get(uploadDirectory, imgName);
            Files.copy(imag.getInputStream(), imagPath, StandardCopyOption.REPLACE_EXISTING);
            exercice.setImage(imgName);
            exerciceService.saveExercice(exercice);
            return "redirect:/Exercice";
        }
        catch (IOException e) {
            // Handle file upload error
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    @GetMapping("/Exercice/edit/{id}")
    public String editExerciceForm(@PathVariable int id, Model model) {
        model.addAttribute("Exercice", exerciceService.getExerciceById(id));
        List<Modul> modul = modulService.getAllModules();
        model.addAttribute("modul", modul);
        return "Exercice/edit_Exercice";
    }

    @PostMapping("/Exercice/Update/{id}")
    public String updateExercice(@PathVariable int id,
                              @ModelAttribute("Exercice") Exercice exercice,
                              Model model,@RequestParam("file") MultipartFile file,
                                 @RequestParam("imag") MultipartFile imag) {
        try {
            // Generate a unique file name
            String fileName = UUID.randomUUID().toString() + ".pdf";

            // Save the file to the upload directory
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            exercice.setContenue(fileName);

            String imgName = UUID.randomUUID().toString() + ".jpg";
            // Save the image to the upload directory
            Path imagPath = Paths.get(uploadDirectory, imgName);
            Files.copy(imag.getInputStream(), imagPath, StandardCopyOption.REPLACE_EXISTING);
            exercice.setImage(imgName);
            //get chapitre from database by id
            exercice.setIdEx(id);
            // save updated Exercice object
            exerciceService.updateExercice(exercice);
            return "redirect:/Exercice";
        }
        catch (IOException e) {
            // Handle file upload error
            e.printStackTrace();
            return "redirect:/error";
        }
    }
    @GetMapping("/Exercice/Delet/{id}")
    public String deleteExercice(@PathVariable int id) {
        exerciceService.deleteExercice(id);
        return "redirect:/Exercice";
    }

}
