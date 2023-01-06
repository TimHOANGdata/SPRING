package com.example.demo;

import java.time.LocalDateTime;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper.StandardWarningHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StagesSpringTests {
    
    @Autowired
    StageRepository stageRepository;

    @Autowired
    PersonneRepository personneRepository;

    @Test
    void testEntityStage(){
        Stage salsa = new Stage("Initiation a la salsa",LocalDateTime.of(2023,06,21,18,0));
        stageRepository.save(salsa);
    }

    @Test
    void testManyToMany(){
        Stage salsa = stageRepository.findById(1).get();
        Personne alain = personneRepository.findById(5).get();
        Personne marie = personneRepository.findById(6).get();

        salsa.addStagaire(marie);
        salsa.addStagaire(alain);
        stageRepository.save(salsa);
    }
}
