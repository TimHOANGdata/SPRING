package spring.library.MVC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.library.AnnuaireDatabaseService;
import spring.library.Auteur.Auteur;
import spring.library.Categorie.Categorie;
import spring.library.Livre.Livre;



@Controller
public class MvcController {
    @Autowired
    private AnnuaireDatabaseService annuaireDatabaseService;
    
    @GetMapping("livres")
    public String afficherLivres(Model model){
        List<Livre> livres = annuaireDatabaseService.getLivres();
        model.addAttribute("livres", livres);
        return "library.html";
    }
    @GetMapping ("livre")
    public String afficherLivreById(Model model, @RequestParam Integer id){
        Livre livre = annuaireDatabaseService.getLivreById(id).get();
        model.addAttribute("livre", livre);
        return "book.html";
    }

    @GetMapping("modifier")
    public String AfficherPageModifier(Model model){
        List<Auteur> auteurs = annuaireDatabaseService.getAuteurs();
        List<Categorie> categories = annuaireDatabaseService.getCategories();
        List<Livre> livres = annuaireDatabaseService.getLivres();
        model.addAttribute("livres", livres);
        model.addAttribute("auteurs", auteurs);
        model.addAttribute("categories", categories);
        return "modifier.html";
    }

    @PostMapping("auteurs")
    public String putAuteur(Model model, Auteur auteur){
        annuaireDatabaseService.addAuteur(auteur);
        List<Auteur> auteurs = annuaireDatabaseService.getAuteurs();
        List<Categorie> categories = annuaireDatabaseService.getCategories();
        List<Livre> livres = annuaireDatabaseService.getLivres();
        model.addAttribute("livres", livres);
        model.addAttribute("auteurs", auteurs);
        model.addAttribute("categories", categories);
        return "modifier.html";
        
    }
    @PostMapping("categories")
    public String putAuteur(Model model, Categorie categorie){
        annuaireDatabaseService.addCategorie(categorie);
        List<Auteur> auteurs = annuaireDatabaseService.getAuteurs();
        List<Categorie> categories = annuaireDatabaseService.getCategories();
        List<Livre> livres = annuaireDatabaseService.getLivres();
        model.addAttribute("livres", livres);
        model.addAttribute("auteurs", auteurs);
        model.addAttribute("categories", categories);
        return "modifier.html";   
    }

    @PostMapping("livres")
    public String putLivre(Model model, Livre livre){
        List<Auteur> auteurs = annuaireDatabaseService.getAuteurs();
        List<Categorie> categories = annuaireDatabaseService.getCategories();
        List<Livre> livres = annuaireDatabaseService.getLivres();
        model.addAttribute("livres", livres);
        model.addAttribute("auteurs", auteurs);
        model.addAttribute("categories", categories);
        livre.setDispoibilite(true);
        annuaireDatabaseService.addLivre(livre);
        return "modifier.html";
}
}
