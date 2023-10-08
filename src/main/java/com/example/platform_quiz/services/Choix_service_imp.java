package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.Choix_DAO;
import com.example.platform_quiz.models.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Choix_service_imp implements choix_service{
    @Autowired
    Choix_DAO choix_dao;

    @Override
    public List<Choice> getAll() {
        return choix_dao.findAll();
    }

    @Override
    public Choice save(Choice choice) {
        return (Choice) choix_dao.save(choice);
    }

    @Override
    public Choice getChoix(Integer id) {
        Choice choice = choix_dao.findById(id).orElse(null);
        return choice;
    }
}
