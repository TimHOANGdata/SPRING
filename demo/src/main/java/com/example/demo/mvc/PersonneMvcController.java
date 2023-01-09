package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// add controller pour definir la route a la fichier html
@Controller
public class PersonneMvcController {
    
    @GetMapping("personnes")
    public String affichePersonnes(Model model, @RequestParam String prenom){

        // String prenom = "Tim";
        
        String nom = "HOANG";
        
        model.addAttribute("nom", nom);
        model.addAttribute("prenom", prenom);

        return "personnes.html";
    }
}
