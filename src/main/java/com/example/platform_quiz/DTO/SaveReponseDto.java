package com.example.platform_quiz.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveReponseDto {

    private String qst ;
    private String text;
}
