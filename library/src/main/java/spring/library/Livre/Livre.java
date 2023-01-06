package spring.library.Livre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import spring.library.Auteur.Auteur;
import spring.library.Categorie.Categorie;

@Entity
@Table(name="livres")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String resume;
    private boolean disponibilite;
    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRetour;
    
    @ManyToOne
    private Auteur auteur;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Categorie> categories = new ArrayList<>();

    public Livre(String nom) {
        this.nom = nom;
    }

    public Livre(String nom, String resume, boolean disponibilite, LocalDateTime dateEmprunt, LocalDateTime dateRetour,
            Auteur auteur, List<Categorie> categories) {
        this.nom = nom;
        this.resume = resume;
        this.disponibilite = disponibilite;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.auteur = auteur;
        this.categories = categories;
    }

    public Livre() {
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

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
    
    public void addCategorie(Categorie categorie){
        categories.add(categorie);
    }

    
    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDispoibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public LocalDateTime getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDateTime dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDateTime getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDateTime dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public String toString() {
        return "Livre [id=" + id + ", nom=" + nom + ", resume=" + resume + ", disponibilite=" + disponibilite
                + ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour + ", auteur=" + auteur + ", categories="
                + categories + "]";
    }

   

   
}
