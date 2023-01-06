package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name="chiens") 
public class Chien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @ManyToOne
    Personne maitre;

    public Chien(String nom) {
        this.nom = nom;
    }

    public Chien(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Personne getMaitre() {
        return maitre;
    }

    public void setMaitre(Personne maitre) {
        this.maitre = maitre;
    }

    
}
