package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdressesSpringTests {
    
    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    PersonneRepository personneRepository;

    @Test
    void testAdresses(){
        Adresse marseilles = new Adresse(12,"Rue Dupont des Loges","13000","Marseilles");
        adresseRepository.save(marseilles);
    }

    @Test
    void testManyToOne(){
        Adresse marseilles = new Adresse(12,"Rue Dupont des Loges","13000","Marseilles");
        adresseRepository.save(marseilles);

        Personne alain = new Personne("alain","Bitchy");
        alain.setAdresse(marseilles);
        personneRepository.save(alain);
    }

    @Test
    void testAjoutDeuxiemeHabitant(){
        Adresse marseille = adresseRepository.findById(1).get();
        Personne marie = new Personne("marie","Bitchy");
        marie.setAdresse(marseille);
        personneRepository.save(marie);
    }
}
