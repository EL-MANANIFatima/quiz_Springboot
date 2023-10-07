package com.example.platform_quiz.repositories;

import com.example.platform_quiz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
