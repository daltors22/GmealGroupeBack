package group.aca.api.Controller;

import group.aca.api.Entity.Connexion;
import group.aca.api.Entity.*;
import group.aca.api.Repository.ConnexionRepository;
import group.aca.api.Repository.UserRepository;
import group.aca.api.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")

public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConnexionRepository connexionRepository;

    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String motDePasse = loginRequest.getMotDePasse();

        // Recherche de l'utilisateur par email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non trouvé");
        }

        // Vérification du mot de passe
        Connexion connexion = connexionRepository.findByUserId(user.getId());
        if (connexion == null || !connexion.getMotDePasse().equals(motDePasse)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
        }

        // Logique pour générer un token ou autre
        return ResponseEntity.ok("Connexion réussie");
    }
}
