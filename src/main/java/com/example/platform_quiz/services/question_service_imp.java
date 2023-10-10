package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.Question_DAO;
import com.example.platform_quiz.DTO.question_request_DTO;
import com.example.platform_quiz.models.Category;
import com.example.platform_quiz.models.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.platform_quiz.DAO.category_DAO;

import java.util.List;

@Service
public class question_service_imp implements service_question{
    @Autowired
    Question_DAO question_dao;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    category_DAO category_da0;
    @Autowired
    category_service category_service;


    public question_service_imp(Question_DAO question_dao, ModelMapper modelMapper) {
        this.question_dao = question_dao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Question save(question_request_DTO question_request) {
        Category category=category_service.getCategory(question_request.getCategory_id());
        Question question=new Question();
        question.setEnnonce(question_request.getEnnonce());
        question.setCategory(category);
        question_dao.save(question);
        return question;

    }

    @Override
    public List<Question> getByCategoryId(Integer id_category) {
        Category category = category_service.getCategory(id_category);
        List<Question> list = question_dao.findByCategory(category);
        return list;
    }


    @Override
    public Question getQuestion(Integer id) {
        Question qst = question_dao.findById(id).orElse(null);
        return qst;
    }
}
