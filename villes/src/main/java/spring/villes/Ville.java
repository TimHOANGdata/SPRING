package spring.villes;

import jakarta.persistence.*;

@Entity
@Table(name="Villes")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String pays;
    @Column(name="nombre_habitant")
    private int nombreHabitant;
    
    public Ville(String nom, String pays, int nombreHabitant) {
        this.nom = nom;
        this.pays = pays;
        this.nombreHabitant = nombreHabitant;
    }
    
    public Ville() {
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }


    @Override
    public String toString() {
        return "Ville [id=" + id + ", nom=" + nom + ", pays=" + pays +"]";
    }

    public int getNombreHabitant() {
        return nombreHabitant;
    }

    public void setNombreHabitant(int nombreHabitant) {
        this.nombreHabitant = nombreHabitant;
    }
  
}

