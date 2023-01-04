package spring.villes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VilleRepository extends JpaRepository<Ville,Integer> {
    //dans jpaRepository  il faut la classe de entity et la class de integer
    //cette interface permet d'utiliser le personneRepository comme un DAO
    //interface va etre injecter par autowired
}

