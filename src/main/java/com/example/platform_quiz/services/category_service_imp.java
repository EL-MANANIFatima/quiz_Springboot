package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.category_DAO;
import com.example.platform_quiz.models.Category;
import com.example.platform_quiz.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class category_service_imp implements category_service{
    @Autowired
    category_DAO category_dao;

    public category_service_imp(category_DAO category_dao) {
        this.category_dao = category_dao;
    }

    @Override
    public Category save(Category category) {

        return category_dao.save(category);
    }

    @Override
    public Category getCategory(Integer id_category) {
        Category category=category_dao.findById(id_category).orElse(null);
        return category;
    }

    @Override
    public List<Category> getAll() {
       return category_dao.findAll();
    }


}
