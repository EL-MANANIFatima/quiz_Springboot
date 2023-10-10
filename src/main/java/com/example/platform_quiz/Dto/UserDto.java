package com.example.platform_quiz.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String email;
    private String password;
    private String nom;
    private String adresse;
    private String phone;

    public UserDto(String email, String password, String nom, String adresse, String phone) {
        super();
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.adresse = adresse;
        this.phone = phone;
    }


}
