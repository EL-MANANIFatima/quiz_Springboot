package com.example.platform_quiz.DAO;

import com.example.platform_quiz.models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Choix_DAO  extends JpaRepository<Choice,Integer> {
}
