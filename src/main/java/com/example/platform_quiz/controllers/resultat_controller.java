package com.example.platform_quiz.controllers;

import com.example.platform_quiz.models.Resultat;
import com.example.platform_quiz.services.resultat_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resultats")

public class resultat_controller {
    @Autowired
    resultat_service resultat_service;

    public resultat_controller(com.example.platform_quiz.services.resultat_service resultat_service) {
        this.resultat_service = resultat_service;
    }
    @PostMapping("/add")
    public Resultat add(Resultat resultat){
        return resultat_service.save(resultat);
    }
}
