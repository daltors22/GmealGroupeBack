package group.aca.api.Controller;

import group.aca.api.dto.RegisterRequest;
import group.aca.api.Entity.Connexion;
import group.aca.api.Security.JwtResponse;
import group.aca.api.Entity.LoginRequest;
import group.aca.api.Entity.SessionToken;
import group.aca.api.Entity.User;
import group.aca.api.Repository.ConnexionRepository;
import group.aca.api.Repository.SessionTokenRepository;
import group.aca.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import group.aca.api.Security.JwtTokenProvider;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConnexionRepository connexionRepository;

    @Autowired
    private SessionTokenRepository sessionTokenRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    /**
     * Login utilisateur : génère un JWT et crée une session utilisateur.
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // 1. Récupérer l'utilisateur via l'email
            User user = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec cet email : " + loginRequest.getEmail()));

            // 2. Vérifier le mot de passe via la table Connexion
            Connexion connexion = connexionRepository.findByUserId(user.getId())
                    .orElseThrow(() -> new RuntimeException("Connexion non trouvée pour l'utilisateur : " + loginRequest.getEmail()));

            if (!passwordMatches(loginRequest.getMotDePasse(), connexion.getMotDePasse())) {
                throw new RuntimeException("Mot de passe incorrect.");
            }

            // 3. Générer un token JWT
            String token = jwtTokenProvider.generateToken(user);

            // 4. Créer une session utilisateur et stocker dans la base
            SessionToken sessionToken = new SessionToken();
            sessionToken.setToken(token);
            sessionToken.setUserId(user.getId());
            sessionToken.setCreatedAt(new Date());
            sessionToken.setExpiresAt(jwtTokenProvider.getExpirationDateFromToken(token)); // Stocker la date d'expiration du token
            sessionTokenRepository.save(sessionToken);

            // 5. Retourner le token JWT au client
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erreur : " + ex.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            // Vérifier si un utilisateur avec cet email existe déjà
            Optional<User> existingUser = userRepository.findByEmail(registerRequest.getEmail());
            if(existingUser.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Email déjà utilisé.");
            }

            // Créer l'objet User avec les informations du RegisterRequest
            User user = new User();
            user.setNom(registerRequest.getNom());
            user.setPrenom(registerRequest.getPrenom());
            user.setTelephone(registerRequest.getTelephone());
            user.setTypeUtilisateur(registerRequest.getTypeUtilisateur()); // TypeUtilisateur est un enum
            user.setEmail(registerRequest.getEmail());
            // Vous pouvez initialiser le sessionToken à null ou le générer lors de la connexion
            user.setSessionToken(null);

            // Sauvegarder l'utilisateur dans la table 'user'
            user = userRepository.save(user);

            // Créer l'objet Connexion pour enregistrer le mot de passe hashé
            Connexion connexion = new Connexion();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(registerRequest.getMotDePasse());
            connexion.setMotDePasse(encodedPassword);
            // Lier cette connexion à l'utilisateur en utilisant son ID
            connexion.setUserId(user.getId());
            connexionRepository.save(connexion);

            return ResponseEntity.ok(user);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Erreur : " + ex.getMessage());
        }
    }



    /**
     * Déconnexion utilisateur : invalider une session en supprimant le token côté backend.
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); // Enlève le "Bearer "
        Optional<SessionToken> session = sessionTokenRepository.findByToken(token);

        if (session.isPresent()) {
            sessionTokenRepository.delete(session.get());
            return ResponseEntity.ok("Déconnexion réussie.");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session invalide ou déjà déconnectée.");
    }

    /**
     * Valider un token JWT et vérifier la session correspondante.
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); // Enlève le "Bearer "

        if (jwtTokenProvider.validateToken(token)) {
            Optional<SessionToken> session = sessionTokenRepository.findByToken(token);
            if (session.isPresent() && !session.get().isExpired()) {
                return ResponseEntity.ok("Token valide et session active.");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token invalide ou session expirée.");
    }

    // Méthode pour vérifier le mot de passe
    private boolean passwordMatches(String rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
