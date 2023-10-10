package com.example.platform_quiz.DTO;

import com.example.platform_quiz.models.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionChoixDto {

    private Integer  questionId;
    private Integer choixId;

}
