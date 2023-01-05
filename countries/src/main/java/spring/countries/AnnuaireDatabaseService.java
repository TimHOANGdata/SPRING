package spring.countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnnuaireDatabaseService {
    
    @Autowired
    CountryRepository countryRepository;

    public Country getRandomCountry(){
        int lenght = countryRepository.findAll().size();
        int random = (int)Math.floor(Math.random()*(lenght)+1);
        return countryRepository.findById(random).get();
    }

    public Country getCountryByCapital(String capital){
        return countryRepository.findByCapital(capital);
    }
    public Country getCountryById(Integer id){
        return countryRepository.findById(id).get();
    }
}
