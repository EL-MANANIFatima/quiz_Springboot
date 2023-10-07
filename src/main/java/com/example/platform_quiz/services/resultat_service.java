package com.example.platform_quiz.services;

import com.example.platform_quiz.models.Resultat;
import org.springframework.stereotype.Service;

@Service
public interface resultat_service {
    public Resultat save(Resultat resultat);
}
