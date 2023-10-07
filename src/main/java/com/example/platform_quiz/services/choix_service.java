package com.example.platform_quiz.services;

import com.example.platform_quiz.models.Choice;

import java.util.List;
import java.util.Optional;

public interface choix_service {

public List<Choice> getAll();
public Choice save(Choice choice);
public Choice getChoix(Integer id);

}
