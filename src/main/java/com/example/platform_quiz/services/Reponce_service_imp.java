package com.example.platform_quiz.services;
import com.example.platform_quiz.DAO.Question_DAO;
import com.example.platform_quiz.DAO.Responce_DAO;
import com.example.platform_quiz.DAO.Resultat_DAO;
import com.example.platform_quiz.DAO.User_DAO;
import com.example.platform_quiz.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Reponce_service_imp implements reponce_service{
    @Autowired
    Responce_DAO responce_dao;
    @Autowired
    Resultat resultat;
    @Autowired
    Resultat_DAO resultat_dao;
    @Autowired
    User_DAO user_dao;


    @Override
    public Reponce insert(User user, Choice choix, Question question) {
        Reponce reponce=new Reponce();
        reponce.setChoix(choix);
        reponce.setUser(user);
        reponce.setQuestion(question);
        Reponce saved =  responce_dao.save(reponce);
        return saved;
    }

    @Override
    public int getScoreById(Integer id_user, Integer id_category) {
        List<Reponce> reponces=responce_dao.findReponcesByUser_IdAndQuestion_Category_Id(id_user,id_category);
        int score=0;
        for (Reponce reponce:reponces) {
            score+=reponce.getChoix().getNote();
        }
        User user= (User) user_dao.findById(id_user).orElse(null);
        resultat.setUser(user);
        resultat.setId_category(id_category);
        resultat.setScore_category(score);
        resultat_dao.save(resultat);

        return score;
    }


}
