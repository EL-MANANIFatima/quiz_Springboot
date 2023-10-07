package com.example.platform_quiz.services;

import com.example.platform_quiz.models.*;

public interface reponce_service {

    public Reponce insert(User user, Choice choix, Question question);
    public int getScoreById(Integer id_user, Integer Id_category);

}
