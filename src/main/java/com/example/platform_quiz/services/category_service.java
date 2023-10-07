package com.example.platform_quiz.services;

import com.example.platform_quiz.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface category_service {
    Category save(Category category);
    List<Category> getAll();
}
