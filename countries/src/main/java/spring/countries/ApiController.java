package spring.countries;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ApiController {
    
    @Autowired
    AnnuaireDatabaseService annuaireDatabaseService;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("games")
    public CountryDTO startGame(){
        CountryMapper countryMapper = new CountryMapper();
        Country country = annuaireDatabaseService.getRandomCountry();
        CountryDTO dto = countryMapper.convertToDTO(country);
        return  dto;
    }


    @PostMapping("games/{id}")
    public ResponseEntity playGame(@PathVariable Integer id, @RequestBody Capital capital){
        Country country = annuaireDatabaseService.getCountryById(id);
        String capitalLowerCase = country.getCapital().toLowerCase();
        String guessCapitalLowerCase = capital.getCapital().toLowerCase();
        if(capitalLowerCase.equals(guessCapitalLowerCase)){
            return ResponseEntity.ok("CORRECT");
        }else{
            return ResponseEntity.badRequest().body("WRONG - "+country);
        }
    }

    @GetMapping("games/{id}")
    public Country getCountryById(@PathVariable Integer Id){
        return countryRepository.findById(Id).get();
    }
}
