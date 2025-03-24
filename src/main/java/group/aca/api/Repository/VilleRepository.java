package group.aca.api.Repository;

import group.aca.api.Entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, String> {
    List<Ville> findByNameStartingWithIgnoreCase(String prefix);
    List<Ville> findByNameContainingIgnoreCase(String keyword);
}


