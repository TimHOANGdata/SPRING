package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {
    //dans jpaRepository  il faut la classe de entity et la class de integer
    //cette interface permet d'utiliser le personneRepository comme un DAO
    //interface va etre injecter par autowired

    public List<Personne> findAllByNom(String nom);     
    public List<Personne> findAllByNomAndPrenom(String nom, String prenom);    
}
