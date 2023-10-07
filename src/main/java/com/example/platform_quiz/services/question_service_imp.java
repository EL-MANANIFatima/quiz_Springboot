package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.Question_DAO;
import com.example.platform_quiz.DTO.question_request_DTO;
import com.example.platform_quiz.models.Question;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class question_service_imp implements service_question{
    Question_DAO question_dao;
    ModelMapper modelMapper;

    public question_service_imp(Question_DAO question_dao, ModelMapper modelMapper) {
        this.question_dao = question_dao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Question save(question_request_DTO question_request) {
             Question question= modelMapper.map(question_request,Question.class);
             question_dao.save(question);
             return question;
    }

    @Override
    public List<Question> getByCategoryId(Integer category_id) {
        return question_dao.findByCategoryId(category_id);
    }

    @Override
    public Question getQuestion(Integer id) {
        Question qst = question_dao.findById(id).orElse(null);
        return qst;
    }
}
