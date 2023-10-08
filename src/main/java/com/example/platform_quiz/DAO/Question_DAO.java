package com.example.platform_quiz.DAO;

import com.example.platform_quiz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Question_DAO extends JpaRepository<Question,Integer> {

      List<Question> findByCategoryId(Integer category_id);

}
