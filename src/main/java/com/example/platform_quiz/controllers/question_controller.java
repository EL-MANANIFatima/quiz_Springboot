package com.example.platform_quiz.controllers;

import com.example.platform_quiz.DTO.question_request_DTO;
import com.example.platform_quiz.models.Question;
import com.example.platform_quiz.services.service_question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class question_controller {
    @Autowired
    service_question  service_question;

    public question_controller(com.example.platform_quiz.services.service_question service_question) {
        this.service_question = service_question;
    }

    @GetMapping("/getquation/{id_category}")
    public List<Question> get(@PathVariable() Integer id_category){
         return service_question.getByCategoryId(id_category);
    }

    @PostMapping("/push")
        public Question save(@RequestBody() question_request_DTO question)
    {
          return   service_question.save(question);
        }
    }




