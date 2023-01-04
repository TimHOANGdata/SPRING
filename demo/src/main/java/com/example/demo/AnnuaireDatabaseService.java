package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnnuaireDatabaseService {
    
    @Autowired
    PersonneRepository personneRepository;
    

    public void addPersonne(Personne personne) {
        personneRepository.save(personne);
    }

    public List<Personne> getPersonnes() {
        return personneRepository.findAll();
    }

    public void delete(Integer id) {
        personneRepository.deleteById(id);
    }

    public void update(Personne personne, Integer id) {
        personneRepository.save(personne);
    }

    public Optional<Personne> getPersonneById(Integer id){
        Optional<Personne> optional = personneRepository.findById(id);
        //optional est un conteneur soid vide , soid contenir Personne
        return optional;
    }

    public List<Personne> getPersonnesByNom(String nom){
        return personneRepository.findAllByNom(nom);
    }

    public List<Personne> getPersonnesByNomAndPrenom(String nom, String prenom){
        return personneRepository.findAllByNomAndPrenom(nom,prenom);
    }
}