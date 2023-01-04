package spring.villes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnuaireDatabaseService {
    
    @Autowired
    VilleRepository villeRepository;
    

    public void addVille(Ville ville) {
        villeRepository.save(ville);
    }

    public List<Ville> getVilles() {
        return villeRepository.findAll();
    }

    public void delete(Integer id) {
        villeRepository.deleteById(id);
    }

    public void update(Ville ville, Integer id) {
        villeRepository.save(ville);
    }

    public Optional<Ville> getVilleById(Integer id){
        Optional<Ville> optional = villeRepository.findById(id);
        //optional est un conteneur soid vide , soid contenir Personne
        return optional;
    }
}
