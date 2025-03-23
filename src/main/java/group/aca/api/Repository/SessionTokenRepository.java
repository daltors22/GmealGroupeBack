package group.aca.api.Repository;
import group.aca.api.Entity.SessionToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface SessionTokenRepository extends JpaRepository<SessionToken, Long> {
    Optional<SessionToken> findByToken(String token);
    void deleteByToken(String token); // Pour invalider un token si nécessaire
    SessionToken findByTokenAndExpiresAtAfter(String token, Date currentDate);

}
