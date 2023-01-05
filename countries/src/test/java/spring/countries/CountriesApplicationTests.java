package spring.countries;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountriesApplicationTests {
	@Autowired
	AnnuaireDatabaseService annuaireDatabaseService;
	
	@Autowired
	ApiController apiController;
	
	@Test
	void TestPlayGame() {
		Capital monaco = new Capital();
		monaco.setCapital("monaco");

		String response = apiController.playGame(39,monaco).getBody().toString();
		assertEquals("CORRECT",response);

		// List<Personne> familleDelon = annuaireDatabaseService.getPersonnesByNom("Delon");
		// assertEquals(2, familleDelon.size());
	}


}
