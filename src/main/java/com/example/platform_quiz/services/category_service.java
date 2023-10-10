package com.example.platform_quiz.services;

import com.example.platform_quiz.models.Category;
import com.example.platform_quiz.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface category_service {
    Category save(Category category);
    Category getCategory(Integer id_category);
    List<Category> getAll();

}
