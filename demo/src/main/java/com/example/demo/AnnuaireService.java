package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

@Service
// Service permet le spring de creer des objet de cette classe et les injecter
// dans la components spring;
public class AnnuaireService {
    private ArrayList<Personne> personnes = new ArrayList<>();
    private int nextId = 0;

    public void addPersonne(Personne personne) {
        nextId++;
        personne.setId(nextId);
        personnes.add(personne);
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public void delete(Integer id) {
        Iterator<Personne> it = personnes.iterator();
        while (it.hasNext()) {
            Personne p = it.next();
            if (p.getId().equals(id)) {
                it.remove();
            }
        }
    }

    public void update(Personne personne, Integer id) {
        for(int i =0; i<personnes.size(); i++){
            if(personnes.get(i).getId()==id){            
               personnes.set(i,personne);
            }
        }  
    }

    public Personne getPersonneById(Integer id){
        Iterator<Personne> it = personnes.iterator();
        while (it.hasNext()) {
            Personne i = it.next();
            if (i.getId().equals(id)) {
               return i;
            }
        }
        return null;
    }
}