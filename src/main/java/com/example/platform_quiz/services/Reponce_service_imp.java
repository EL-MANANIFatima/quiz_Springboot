package com.example.platform_quiz.services;
import com.example.platform_quiz.DAO.Responce_DAO;
import com.example.platform_quiz.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Reponce_service_imp implements reponce_service{
    @Autowired
    Responce_DAO responce_dao;
    Reponce reponce;
    resultat_service resultatRepository;


    @Override
    public Reponce insert(User user, Choice choix, Question question) {
Reponce reponce=new Reponce();
reponce.setChoix(choix);
reponce.setUser(user);
reponce.setQuestion(question);
Reponce saved =  responce_dao.save(reponce);
return saved;
    }


}
