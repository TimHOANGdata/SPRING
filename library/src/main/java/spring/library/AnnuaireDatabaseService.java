package spring.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.library.Auteur.Auteur;
import spring.library.Auteur.AuteurRepository;
import spring.library.Categorie.Categorie;
import spring.library.Categorie.CategorieRepository;
import spring.library.Livre.Livre;
import spring.library.Livre.LivreRepository;

@Service
public class AnnuaireDatabaseService {
    @Autowired
    LivreRepository livreRepository;

    @Autowired
    AuteurRepository auteurRepository;

    @Autowired
    CategorieRepository categorieRepository;

    // Livre
    public void addLivre(Livre livre) {
        livreRepository.save(livre);
    }

    public List<Livre> getLivres() {
        return livreRepository.findAll();
    }

    public List<Livre> getLivresDispo() {
        List<Livre> dispo = livreRepository.findAllByDisponibilite(true);
        return dispo;
    }

    public void update(Livre livre, Integer id) {
        livreRepository.save(livre);
    }

    public Optional<Livre> getLivreById(Integer id) {
        Optional<Livre> optional = livreRepository.findById(id);
        // optional est un conteneur soid vide , soid contenir Personne
        return optional;
    }

    // Auteur
    public void addAuteur(Auteur auteur) {
        auteurRepository.save(auteur);
    }

    public List<Auteur> getAuteurs() {
        return auteurRepository.findAll();
    }

    public void update(Auteur auteur, Integer id) {
        auteurRepository.save(auteur);
    }

    public Optional<Auteur> getAuteurById(Integer id) {
        Optional<Auteur> optional = auteurRepository.findById(id);
        // optional est un conteneur soid vide , soid contenir Personne
        return optional;
    }

    // Categorie
    public void addCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    public void update(Categorie categorie, Integer id) {
        categorieRepository.save(categorie);
    }

    public Optional<Categorie> getCategorieById(Integer id) {
        Optional<Categorie> optional = categorieRepository.findById(id);
        // optional est un conteneur soid vide , soid contenir Personne
        return optional;
    }

    // Action

    public void empruntLivre(Livre livre) {
        livre.setDispoibilite(false);
        livre.setDateEmprunt(LocalDateTime.now());
        livre.setDateRetour(LocalDateTime.now().plusDays(30));
        livreRepository.save(livre);
    }

    public void retourneLivre(Livre livre) {
        livre.setDispoibilite(true);
        livre.setDateEmprunt(null);
        livre.setDateRetour(null);
        livreRepository.save(livre);
    }

    public List<Livre> rechercheLivre(List<Livre> livres, String text) {
        List<Livre> livreRecherche = new ArrayList<>();
        String textLowerCase = text.toLowerCase();

        for (Livre l : livres) {

            String nomLowerCase = l.getNom().toLowerCase();
            
            if (l.getResume()==null) {
                if (nomLowerCase.contains(textLowerCase)) {
                    livreRecherche.add(l);
                }
            }else{
                String resumeLowerCase = l.getResume().toLowerCase();
                if (nomLowerCase.contains(textLowerCase) || resumeLowerCase.contains(textLowerCase)){
                    livreRecherche.add(l);
                }  
            }
        }
        return livreRecherche;
    }
}
