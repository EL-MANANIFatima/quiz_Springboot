package com.example.platform_quiz.DTO;

import lombok.*;

@NoArgsConstructor
@Data
@Getter
@Setter
public class LoginDto {
    private String email;
    private String password;

    public LoginDto(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

}
