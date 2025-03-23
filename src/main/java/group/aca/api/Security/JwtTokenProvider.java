package group.aca.api.Security;

import group.aca.api.Entity.User;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}") // Clé secrète codée en Base64
    private String jwtSecret;

    @Value("${jwt.expiration}") // Temps d'expiration du token (en millisecondes)
    private int jwtExpirationMs;

    private byte[] decodedSecret;

    @PostConstruct
    public void decodeSecret() {
        decodedSecret = Base64.getDecoder().decode(jwtSecret);
        System.out.println("Clé secrète décodée avec succès.");
    }

    // 1. Méthode pour générer le token JWT
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("typeUtilisateur", user.getTypeUtilisateur())
                .claim("email", user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, decodedSecret) // Utilise la clé décodée
                .compact();
    }

    // 2. Méthode pour extraire le subject (ID utilisateur) depuis le token
    public String getUserIdFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(decodedSecret) // Utilise la clé décodée
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 3. Méthode pour valider le token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(decodedSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.err.println("Signature JWT invalide : " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.err.println("Token JWT invalide : " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.err.println("Token JWT expiré : " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.println("Token JWT non supporté : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Les claims JWT sont vides : " + e.getMessage());
        }
        return false;
    }
    public Date getExpirationDateFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(decodedSecret) // Utilise la clé décodée
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
