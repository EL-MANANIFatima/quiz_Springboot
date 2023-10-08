package com.example.platform_quiz.services;

import com.example.platform_quiz.DAO.User_DAO;
import com.example.platform_quiz.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_service_imp implements User_service {
    @Autowired
    User_DAO user_dao;
    @Override
    public User save(User user) {
        return (User) user_dao.save(user);
    }

    @Override
    public List<User> get() {
        return user_dao.findAll();
    }
}
