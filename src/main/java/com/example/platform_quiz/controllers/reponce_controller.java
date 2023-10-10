package com.example.platform_quiz.controllers;

import com.example.platform_quiz.models.*;
import com.example.platform_quiz.services.UserService;
import com.example.platform_quiz.services.reponce_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.platform_quiz.services.service_question;
import   com.example.platform_quiz.services.choix_service;

@RestController
@RequestMapping("reponces")
public class reponce_controller {
    @Autowired
    reponce_service reponce_service;
    @Autowired
     service_question service_question;
    @Autowired
      choix_service choix_service;
    @Autowired
    UserService userService;
    public reponce_controller(com.example.platform_quiz.services.reponce_service reponce_service) {
        this.reponce_service = reponce_service;
    }

    @PostMapping("/add")
    public Reponce save(@RequestParam Integer id_choix,@RequestParam Integer id_question,@RequestParam  Integer id_user){
        User user=userService.getUser(id_user);
        Choice choix= choix_service.getChoix(id_choix);
        Question question= service_question.getQuestion(id_question);
       return reponce_service.insert(user,choix,question);
    }
    @PostMapping("/getScore")
    public int getScoreCategory(@RequestParam Integer id_user,@RequestParam Integer id_category){
       return reponce_service.getScoreById(id_user,id_category);
    }
    @PostMapping("/getScoreGlobale")
    public int getGlobale(@RequestParam Integer id_user){
     return    reponce_service.getScoreGlobale(id_user);
    }

}
