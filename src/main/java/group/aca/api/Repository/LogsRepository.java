package group.aca.api.Repository;

import group.aca.api.Entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Integer> {
}
