package com.example.platform_quiz.controllers;

import com.example.platform_quiz.DTO.QuestionChoixDto;
import com.example.platform_quiz.DTO.ReponseDto;
import com.example.platform_quiz.DTO.SaveReponseDto;
import com.example.platform_quiz.DTO.ScoreDto;
import com.example.platform_quiz.models.*;
import com.example.platform_quiz.services.UserService;
import com.example.platform_quiz.services.reponce_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.platform_quiz.services.service_question;
import   com.example.platform_quiz.services.choix_service;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/submit")
    public List<SaveReponseDto> submit(@RequestBody ReponseDto reponses) {
        User user = userService.getUser(reponses.getUserId());
        List<QuestionChoixDto> responses = reponses.getResponses();
        List<QuestionChoix> reponseList = new ArrayList<>();

        for (QuestionChoixDto reponse : responses) {
            Integer choixId = reponse.getChoixId();
            Integer questionId = reponse.getQuestionId();

            Choice choix = choix_service.getChoix(choixId);
            Question question = service_question.getQuestion(questionId);
            reponseList.add(new QuestionChoix(question, choix));
        }

        List<SaveReponseDto> saved = reponce_service.send(user, reponseList);

        return saved;
    }
    @PostMapping("/getScore")
    public int getScoreCategory(@RequestParam Integer id_user,@RequestParam Integer id_category){
       return reponce_service.getScoreById(id_user,id_category);
    }
    @PostMapping("/getScoreGlobale")
    public ScoreDto getGlobale(@RequestParam Integer id_user){

        return    reponce_service.getScoreGlobale(id_user);
    }

}
