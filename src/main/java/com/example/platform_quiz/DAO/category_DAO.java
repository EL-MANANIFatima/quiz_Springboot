package com.example.platform_quiz.DAO;

import com.example.platform_quiz.models.Category;
import com.example.platform_quiz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface category_DAO extends JpaRepository<Category,Integer> {


}
