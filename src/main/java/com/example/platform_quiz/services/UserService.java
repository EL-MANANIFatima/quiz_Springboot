package com.example.platform_quiz.services;

import com.example.platform_quiz.Dto.LoginDto;
import com.example.platform_quiz.Dto.UserDto;
import com.example.platform_quiz.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User addUser(UserDto userDto);

    List<UserDto> findAll();

    User login(LoginDto loginDto);
}
