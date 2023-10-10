package com.example.platform_quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Data
@Table(name = "questions")
@NoArgsConstructor
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ennonce;

    @ManyToOne
    @JsonIgnore
    private Category category;



    public Question(String ennonce, Category category) {
        this.ennonce = ennonce;
        this.category = category;
    }

}
