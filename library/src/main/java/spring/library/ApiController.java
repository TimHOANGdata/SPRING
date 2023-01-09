package spring.library;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import spring.library.Auteur.Auteur;
import spring.library.Categorie.Categorie;
import spring.library.Livre.Livre;

@RestController
@RequestMapping("api")
public class ApiController {
    
    @Autowired
    AnnuaireDatabaseService annuaireDatabaseService;

    @PostMapping("categories")
    public void addCategorie(@RequestBody Categorie categorie){
        annuaireDatabaseService.addCategorie(categorie);
    }

    @PostMapping("auteurs")
    public void addAuteur(@RequestBody Auteur auteur){
        annuaireDatabaseService.addAuteur(auteur);
    }

    @PostMapping("livres")
    public void addLivre(@RequestBody Livre livre){
        livre.setDispoibilite(true);
        annuaireDatabaseService.addLivre(livre);
    }

    @GetMapping("livres")
    public List<Livre> getLivres(){
        return annuaireDatabaseService.getLivres();
    }

    @GetMapping("livresdisponible")
    public List<Livre> getLivreDispo(){
        return annuaireDatabaseService.getLivresDispo();
    }

    @GetMapping("recherche")
    public ResponseEntity rechercheLivre(@RequestParam String text){
        List<Livre> list = annuaireDatabaseService.rechercheLivre(annuaireDatabaseService.getLivres(), text);
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("recherche1")
    public List<Livre> rechercheLivre1(@RequestParam String text){
        return annuaireDatabaseService.rechercheLivre1(text);
    }

    @PostMapping("emprunt")
    public ResponseEntity empruntLivre(@RequestParam Integer id){
        Optional<Livre> livre = annuaireDatabaseService.getLivreById(id);
        if(livre.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Livre livre1 = livre.get();
            if(livre1.isDisponibilite()){
                annuaireDatabaseService.empruntLivre(livre1);
                return ResponseEntity.ok("emprunté" + livre1);
            }else{
                return ResponseEntity.ok("livre indisponible");
            }
        }
    }

    @PostMapping("retour")
    public ResponseEntity retourneLivre(@RequestParam Integer id){
        Optional<Livre> livre = annuaireDatabaseService.getLivreById(id);
        if(livre.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Livre livre1 = livre.get();
            if(livre1.isDisponibilite()){
                return ResponseEntity.ok("Livre deja retourne");
            }else{
                annuaireDatabaseService.retourneLivre(livre1);
                return ResponseEntity.ok("retourné" + livre1);
            }
        }
    }
    @GetMapping("tempsattend")
    public ResponseEntity tempsAttend(@RequestParam int id){
       Optional<Livre> livre = annuaireDatabaseService.getLivreById(id);
        if(livre.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            if(livre.get().isDisponibilite()){
                return ResponseEntity.ok("le livre est disponible");
            }else{
                long daysNumber = ChronoUnit.DAYS.between(LocalDateTime.now(),livre.get().getDateRetour());
                return ResponseEntity.ok("you have to wait for " +daysNumber+" days");
            }
        }
    }
}
