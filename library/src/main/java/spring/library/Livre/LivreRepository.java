package spring.library.Livre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre,Integer> {
    public List<Livre> findAllByDisponibilite(Boolean disponibilite);

    public List<Livre> findAllByNom(String nom);
    public List<Livre> findAllByNomContainingIgnoreCaseOrResumeContainingIgnoreCase(String text,String text1);
}

