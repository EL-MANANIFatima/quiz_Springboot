package com.example.platform_quiz.services;

import com.example.platform_quiz.DTO.question_request_DTO;
import com.example.platform_quiz.models.Question;

import java.util.List;

public interface service_question {

   public Question save(question_request_DTO question_request);
   public List<Question> getByCategoryId(Integer category_id);
   public Question getQuestion(Integer id);

}
