package com.example.demo.controller;

import com.example.demo.service.AdministrateurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class AdministrateurController {
    private AdministrateurService administrateurService;

    public AdministrateurController(AdministrateurService administrateurService) {
        super();
        this.administrateurService = administrateurService;
    }

}
