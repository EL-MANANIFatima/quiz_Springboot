package com.example.platform_quiz.services;
import com.example.platform_quiz.DAO.Responce_DAO;
import com.example.platform_quiz.DAO.Resultat_DAO;
import com.example.platform_quiz.DAO.category_DAO;
import com.example.platform_quiz.DTO.QuestionChoixDto;
import com.example.platform_quiz.DTO.ReponseDto;
import com.example.platform_quiz.DTO.SaveReponseDto;
import com.example.platform_quiz.DTO.ScoreDto;
import com.example.platform_quiz.models.*;
import com.example.platform_quiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    UserRepository userRepository;
    @Autowired
    category_DAO categoryDao;


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
    public List<SaveReponseDto> send(User user , List<QuestionChoix> reponses ){
        List<SaveReponseDto> reponseDTOs = new ArrayList<>();

        for (QuestionChoix reponse : reponses) {
            Reponce saved = insert(user, reponse.getChoix(), reponse.getQuestion());
            SaveReponseDto resonse = new SaveReponseDto(saved.getQuestion().getEnnonce(),saved.getChoix().getDescription());
            reponseDTOs.add(resonse);
        }

        return reponseDTOs;
    }

    @Override
    public int getScoreById(Integer id_user, Integer id_category) {
        List<Reponce> reponces=responce_dao.findReponcesByUser_IdAndQuestion_Category_Id(id_user,id_category);
        int score=0;
        for (Reponce reponce:reponces) {
            score+=reponce.getChoix().getNote();
        }
        User user= userRepository.findById(id_user).orElse(null);
        resultat.setUser(user);
        resultat.setId_category(id_category);
        resultat.setScore_category(score);
        resultat_dao.save(resultat);

        return score;
    }

     @Override
    public ScoreDto getScoreGlobale(Integer id_user)
    {
        ScoreDto scoreDto = new ScoreDto();
        List<Category> categories = categoryDao.findAll();
        int globalScore = 0;
        for (Category category : categories) {
            int categoryId = category.getId();
            String categoryName = category.getLibelle();
            int categoryScore = getScoreById(id_user, categoryId);
            globalScore += categoryScore;
            scoreDto.getCategoryScores().put(categoryName, categoryScore);
        }
        scoreDto.setGlobalScore(globalScore);
        return scoreDto;
    }
}
