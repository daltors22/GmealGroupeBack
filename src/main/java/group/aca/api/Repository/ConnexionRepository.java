package group.aca.api.Repository;

import group.aca.api.Entity.Connexion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConnexionRepository extends JpaRepository<Connexion, Integer> {
    Optional<Connexion> findByUserId(Integer userId);

}

