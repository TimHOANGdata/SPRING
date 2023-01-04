package spring.villes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApiController {
    
    @Autowired
    AnnuaireDatabaseService annuaireDatabaseService;

    @GetMapping("villes")
    public List<Ville> getVilles(){
        return annuaireDatabaseService.getVilles();
    }

    @GetMapping("villes/{id}")
    public ResponseEntity getVilleById(@PathVariable Integer id){
        Optional<Ville> optional = annuaireDatabaseService.getVilleById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(optional.get());
        }
    }

    @PostMapping("villes")
    public void addVille(@RequestBody Ville ville){
        annuaireDatabaseService.addVille(ville);
        System.out.println(ville);
    }

    @DeleteMapping("villes/{id}")
    public ResponseEntity DeleteById(@PathVariable Integer id){
        Optional<Ville> optional = annuaireDatabaseService.getVilleById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            annuaireDatabaseService.delete(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("villes/{id}")
    public ResponseEntity Update(@PathVariable Integer id,  @RequestBody Ville ville){
        Optional<Ville> optional = annuaireDatabaseService.getVilleById(id);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            if(ville.getId().equals(id)){
                annuaireDatabaseService.update(ville, id);
                return ResponseEntity.ok(optional.get());
            }else{
                return ResponseEntity.badRequest().build();
            }
        }    
    }
}
