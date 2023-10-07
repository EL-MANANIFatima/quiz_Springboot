package com.example.platform_quiz;

import com.example.platform_quiz.models.Resultat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Resultat resultat() {
        return new Resultat();
    }
}
