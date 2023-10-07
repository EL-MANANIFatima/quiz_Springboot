package com.example.platform_quiz.DAO;

import com.example.platform_quiz.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface category_DAO extends JpaRepository<Category,Integer> {
}
