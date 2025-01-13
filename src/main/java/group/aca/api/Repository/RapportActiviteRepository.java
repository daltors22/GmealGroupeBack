package group.aca.api.Repository;

import group.aca.api.Entity.RapportActivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportActiviteRepository extends JpaRepository<RapportActivite, Integer> {
}
