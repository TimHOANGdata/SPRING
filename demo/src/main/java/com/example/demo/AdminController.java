package com.example.demo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/api")
public class AdminController {

    @Autowired
    private AnnuaireDatabaseService annuaireDatabaseService;

    @DeleteMapping("personnes/{id}")
    public ResponseEntity deletePersonne(@PathVariable Integer id) {
        Optional<Personne> optional = annuaireDatabaseService.getPersonneById(id);
        if (optional.isEmpty()) {
            // indiquer status : 404 not found
            return ResponseEntity.notFound().build();
        } else {
            // indiquer status: 200 ok
            annuaireDatabaseService.delete(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("personnes/{id}")
    public ResponseEntity updatePersonne(@RequestBody Personne personne, @PathVariable Integer id) {
        Optional<Personne> p = annuaireDatabaseService.getPersonneById(id);
        if (p.isEmpty()) {
            // indiquer status : 404 not found
            return ResponseEntity.notFound().build();
        } else {
            if (personne.getId() == id) {
                annuaireDatabaseService.update(personne, id);
                return ResponseEntity.accepted().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
    }
}
