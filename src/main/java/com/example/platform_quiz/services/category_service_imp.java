package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.category_DAO;
import com.example.platform_quiz.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class category_service_imp implements category_service{
    category_DAO category_dao;

    public category_service_imp(category_DAO category_dao) {
        this.category_dao = category_dao;
    }

    @Override
    public Category save(Category category) {
        return category_dao.save(category);
    }

    @Override
    public List<Category> getAll() {
       return category_dao.findAll();
    }
}