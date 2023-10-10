package com.example.platform_quiz.services;

import com.example.platform_quiz.DTO.LoginDto;
import com.example.platform_quiz.DTO.UserDto;
import com.example.platform_quiz.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User addUser(UserDto userDto);

    List<UserDto> findAll();

    User login(LoginDto loginDto);
    User getUser(Integer id);
}
