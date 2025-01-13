package group.aca.api.Repository;

import group.aca.api.Entity.Connexion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnexionRepository extends JpaRepository<Connexion, Integer> {
    Connexion findByUserId(Integer userId);
}

