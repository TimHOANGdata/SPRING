package spring.library;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.library.Livre.Livre;
import spring.library.Livre.LivreRepository;

@SpringBootTest
public class TestRechercheLivre {
    
    @Autowired AnnuaireDatabaseService annuaireDatabaseService;
    @Autowired LivreRepository livreRepository;

    @Test
    void testRechercheLivre(){
        Livre livre1 = new Livre("abc","null",true,null,null,null,null);
        Livre livre2 = new Livre("hjk","null",true,null,null,null,null);
        Livre livre3 = new Livre("abc","abc",true,null,null,null,null);
        
        List<Livre> livres = new ArrayList<>();
        livres.add(livre1);
        livres.add(livre2);
        livres.add(livre3);
        List<Livre> livresRecherche = annuaireDatabaseService.rechercheLivre(livres, "abc");
        assertEquals(2,livresRecherche.size());
    }   
}
