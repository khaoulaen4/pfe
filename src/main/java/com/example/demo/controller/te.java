package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class te {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @GetMapping("/uploa")
    public String teste () {

        return "Chapitre/uplode";

    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Generate a unique file name
            String fileName = UUID.randomUUID().toString() + ".pdf";

            // Save the file to the upload directory
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // File stored successfully, perform additional logic if needed

            return "redirect:/uploa";
        }
        catch (IOException e) {
            // Handle file upload error
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    // Rest of the code remains the same
}