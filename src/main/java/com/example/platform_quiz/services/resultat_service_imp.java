package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.Resultat_DAO;
import com.example.platform_quiz.models.Resultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resultat_service_imp implements resultat_service{
    @Autowired
    Resultat_DAO resultat_dao;
    @Override
    public Resultat save(Resultat resultat) {
        return resultat_dao.save(resultat);
    }
}
