package com.example.platform_quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class question_request_DTO {

    private Integer category_id;
    private String ennonce;

}
