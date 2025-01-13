package group.aca.api.Repository;

import group.aca.api.Entity.Plats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatsRepository extends JpaRepository<Plats, Integer> {
}
