package group.aca.api.Repository;

import group.aca.api.Entity.Commandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CommandesRepository extends JpaRepository<Commandes, Integer> {
    @Service
    public class CommandesService {

        @Autowired
        private CommandesRepository commandesRepository;

        public List<Commandes> getAllCommandes() {
            return commandesRepository.findAll();
        }

        // Autres méthodes…
    }

    List<Commandes> findByUserId(Integer userId);
}
