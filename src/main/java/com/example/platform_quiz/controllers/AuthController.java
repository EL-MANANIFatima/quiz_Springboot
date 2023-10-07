package com.example.platform_quiz.controllers;


import com.example.platform_quiz.Dto.LoginDto;
import com.example.platform_quiz.models.User;
import com.example.platform_quiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.platform_quiz.Dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthController {


    @Autowired
     UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping("")
    public List<UserDto> getUsers(){
        return  userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody() UserDto userDto){

        try {
            userService.addUser(userDto);
            return ResponseEntity.ok("The user has been added succesfully");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Please fill all the fields");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Email already exists");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody() LoginDto loginDto) {
        User user = userService.login(loginDto);
        if ( user != null)
            return ResponseEntity.ok("ur logged in");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("email ou password invalide");
    }

    }




