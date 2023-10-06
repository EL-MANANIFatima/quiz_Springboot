package com.example.platform_quiz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reponces")
public class Reponce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_question")
    @MapsId("id")
    private Question question;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_choix")
    private  Choice choix;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_user")
    private  User user;



}
