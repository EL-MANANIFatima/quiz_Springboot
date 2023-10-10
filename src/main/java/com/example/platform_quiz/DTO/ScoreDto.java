package com.example.platform_quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {

    private Map<String, Integer> categoryScores = new HashMap<>();
    private int globalScore;
}
