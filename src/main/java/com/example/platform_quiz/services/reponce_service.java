package com.example.platform_quiz.services;

import com.example.platform_quiz.models.Choice;
import com.example.platform_quiz.models.Question;
import com.example.platform_quiz.models.Reponce;
import com.example.platform_quiz.models.User;

public interface reponce_service {

    public Reponce insert(User user, Choice choix, Question question);

}
