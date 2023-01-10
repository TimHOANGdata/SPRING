package com.example.demo.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnnuaireDatabaseService;
import com.example.demo.Personne;
// add controller pour definir la route a la fichier html
@Controller
public class PersonneMvcController {
    @Autowired
    private AnnuaireDatabaseService annuaireDatabaseService;

    @GetMapping("personnes")
    public String affichePersonnes(Model model, @RequestParam String prenom,@RequestParam Integer age){

        // String prenom = "Tim";

        String nom = "HOANG";
        
        model.addAttribute("nom", nom);
        model.addAttribute("prenom", prenom);

        model.addAttribute("age", age);        
        List<Personne> personnes = annuaireDatabaseService.getPersonnes();
        model.addAttribute("personnes", personnes);
        System.out.println(personnes);
        return "personnes.html";
    }

    @PostMapping("personnes")
    public String ajouterPersonne(Personne personne, Model model){
        annuaireDatabaseService.addPersonne(personne);
        List<Personne> personnes = annuaireDatabaseService.getPersonnes();
        model.addAttribute("personnes", personnes);
        return "personnes.html";
    }
}
