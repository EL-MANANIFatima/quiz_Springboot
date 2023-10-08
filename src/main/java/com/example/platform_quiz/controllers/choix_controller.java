package com.example.platform_quiz.controllers;

import com.example.platform_quiz.models.Choice;
import com.example.platform_quiz.services.choix_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.platform_quiz.services.choix_service;

import java.util.List;

@RestController
@RequestMapping("choix")
public class choix_controller {
    @Autowired
     choix_service choix_service;

    public choix_controller(com.example.platform_quiz.services.choix_service choix_service) {
        this.choix_service = choix_service;
    }
    @GetMapping("/get")
    public List<Choice> getALL(){
        return choix_service.getAll();
    }
    @PostMapping("/add")
    public Choice save(@RequestBody Choice choice)
    {
       return choix_service.save(choice);
    }
}

