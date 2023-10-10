package com.example.platform_quiz.services;

import com.example.platform_quiz.DTO.SaveReponseDto;
import com.example.platform_quiz.DTO.ScoreDto;
import com.example.platform_quiz.models.*;

import java.util.List;

public interface reponce_service {

    public Reponce insert(User user, Choice choix, Question question);
    public int getScoreById(Integer id_user, Integer Id_category);
    public ScoreDto getScoreGlobale(Integer id_user);
    public List<SaveReponseDto> send(User user , List<QuestionChoix> reponses );
}
