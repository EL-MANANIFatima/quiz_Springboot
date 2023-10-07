package com.example.platform_quiz.DAO;

import com.example.platform_quiz.models.Reponce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Responce_DAO extends JpaRepository<Reponce,Integer> {

}
