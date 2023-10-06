package com.example.platform_quiz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Choice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;
    private int note;

    @OneToMany(mappedBy = "choix",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reponce> reponces;
}
