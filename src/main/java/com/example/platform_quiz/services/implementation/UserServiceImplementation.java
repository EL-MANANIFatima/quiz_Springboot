package com.example.platform_quiz.services.implementation;

import com.example.platform_quiz.Dto.LoginDto;
import com.example.platform_quiz.Dto.UserDto;
import com.example.platform_quiz.models.User;
import com.example.platform_quiz.repositories.UserRepository;
import com.example.platform_quiz.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;


    public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public User addUser(UserDto userDto) {

        if (userDto.getEmail() == null || userDto.getPassword() == null || userDto.getNom()== null || userDto.getPhone() == null|| userDto.getAdresse() == null) {
            throw new IllegalArgumentException("Please fill all the fields");
        }

        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        User user = new User();
        user =modelMapper.map(userDto, User.class);
        User saved = userRepository.save(user);
        return saved;

    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream().map(el -> modelMapper.map(el, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public User login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user != null && passwordEncoder.matches(loginDto.getPassword().trim(), user.getPassword())){
                return user;
        }
		return null;
}
}