package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="stage")
public class Stage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private LocalDateTime horaire;

    @ManyToMany(fetch = FetchType.EAGER) // collections are lazy_loaded by defaut
    List<Personne> stagaires = new ArrayList<>();

    public void addStagaire(Personne personne){
        stagaires.add(personne);
    }
    
    public Stage(String nom, LocalDateTime horaire) {
        this.nom = nom;
        this.horaire = horaire;
    }
    public Stage() {
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
    public LocalDateTime getHoraire() {
        return horaire;
    }
    public void setHoraire(LocalDateTime horaire) {
        this.horaire = horaire;
    }
    @Override
    public String toString() {
        return "Stage [id=" + id + ", nom=" + nom + ", horaire=" + horaire + "]";
    }
    public List<Personne> getStagaires() {
        return stagaires;
    }
    public void setStagaires(List<Personne> stagaires) {
        this.stagaires = stagaires;
    }
}
