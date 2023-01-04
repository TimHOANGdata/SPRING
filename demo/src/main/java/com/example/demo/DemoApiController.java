package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
//ajoute un prefix pour l'url
class DemoApiController {

    @Autowired
    //autowired permet de verifier si cet objet existe deja dans le spring components
    // si non il va le creer et met dans le spring components
    AnnuaireDatabaseService annuaireDatabaseService; //= new AnnuaireService();

    @Autowired
    PersonneMapper personneMapper;
    
    @GetMapping("personnes")
    public List<PersonneDTO> getPersonnes(){
        List<PersonneDTO> dtos = new ArrayList<>();

        List<Personne> entities = annuaireDatabaseService.getPersonnes();

        for(Personne p : entities){
            PersonneDTO dto = personneMapper.convertToDTO(p);
            dtos.add(dto);
        }
        return dtos;
    }

    @PostMapping("personnes")
    public void createPersonne(@RequestBody Personne personne){
        System.out.println(personne);
        annuaireDatabaseService.addPersonne(personne);
    }

    @GetMapping("personnes/{id}")
    public ResponseEntity getPersonne(@PathVariable Integer id){
        Optional<Personne> p = annuaireDatabaseService.getPersonneById(id);
        if (p.isEmpty()) {
            // indiquer status : 404 not found
            return ResponseEntity.notFound().build();
        } else {
        return ResponseEntity.ok(annuaireDatabaseService.getPersonneById(id).get());
        }
    }

    //findallbynom?nom=tim
    @GetMapping("findallbynom")
    public ResponseEntity getPersonnesByNom(@RequestParam String nom){
        List<Personne> personnes = annuaireDatabaseService.getPersonnesByNom(nom);
        if(personnes.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(personnes);
        }
    }

     //findallbynomandprenom?nom=tim&prenom=hoang
     @GetMapping("findallbynomandprenom")
     public ResponseEntity getPersonnesByNomAndPrenom(@RequestParam String nom,@RequestParam String prenom){
         List<Personne> personnes = annuaireDatabaseService.getPersonnesByNomAndPrenom(nom,prenom);
         if(personnes.isEmpty()){
             return ResponseEntity.notFound().build();
         }else{
             return ResponseEntity.ok(personnes);
         }
     }
}       