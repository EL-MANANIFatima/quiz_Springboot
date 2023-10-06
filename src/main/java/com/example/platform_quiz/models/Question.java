package com.example.platform_quiz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
    private Category category;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reponce> reponces;
}
