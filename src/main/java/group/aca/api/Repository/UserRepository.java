package group.aca.api.Repository;
import group.aca.api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Ajoute des requêtes personnalisées ici si nécessaire
    User findByEmail(String email);

}

