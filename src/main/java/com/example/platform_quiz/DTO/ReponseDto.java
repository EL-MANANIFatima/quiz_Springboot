package com.example.platform_quiz.DTO;

import com.example.platform_quiz.models.QuestionChoix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseDto {

    private Integer userId;
    private List<QuestionChoixDto> responses;
}
