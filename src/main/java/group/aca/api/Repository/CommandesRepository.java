package group.aca.api.Repository;

import group.aca.api.Entity.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandesRepository extends JpaRepository<Commandes, Integer> {
}
