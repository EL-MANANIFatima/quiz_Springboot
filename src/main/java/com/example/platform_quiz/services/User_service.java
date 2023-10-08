package com.example.platform_quiz.services;

import com.example.platform_quiz.models.User;

import java.util.List;

public interface User_service {
    public User save(User user);
    public List<User> get();

}
