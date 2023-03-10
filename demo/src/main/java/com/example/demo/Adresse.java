package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name="addresses")
public class Adresse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int numero;
    private String rue;
    private String codePostal;
    private String ville;
    public Adresse(int numero, String rue, String codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    public Adresse() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    @Override
    public String toString() {
        return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
                + ville + "]";
    }
    
    
}
