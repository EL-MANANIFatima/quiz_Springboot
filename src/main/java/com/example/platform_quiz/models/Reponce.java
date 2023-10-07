package com.example.platform_quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reponces")
@Getter
@Setter
public class Reponce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    //@JoinColumn(name = "id_question")
    @JsonIgnore
    private Question question;
    @ManyToOne
    @JsonIgnore
    //@JoinColumn(name = "id_choix")
    private  Choice choix;

    @ManyToOne
    @JsonIgnore
    //@JoinColumn(name = "id_user")
    private  User user;



}
