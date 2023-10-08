package com.example.platform_quiz.controllers;

import com.example.platform_quiz.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.platform_quiz.services.category_service;

import java.util.List;

@RestController
@RequestMapping("categories")
public class category_controller {
   @Autowired
    private category_service category_service;

    public category_controller(category_service category_service) {
        this.category_service = category_service;
    }

    @GetMapping("/get")
    public List<Category> getALL(){
     return  category_service.getAll();
    }
    @PostMapping("/add")
    public Category add(@RequestBody Category category){
      return category_service.save(category);
    }

}
