package group.aca.api;

import group.aca.api.Entity.Connexion;
import group.aca.api.Repository.ConnexionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasswordEncoderUpdater {

    @Autowired
    private ConnexionRepository connexionRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void encodePasswords() {
        List<Connexion> connexions = connexionRepository.findAll(); // Récupère toutes les connexions
        for (Connexion connexion : connexions) {
            String motDePasse = connexion.getMotDePasse();
            if (!motDePasse.startsWith("$2a$")) { // Vérifie si le mot de passe n'est pas déjà encodé
                String encodedPassword = passwordEncoder.encode(motDePasse);
                connexion.setMotDePasse(encodedPassword);
                connexionRepository.save(connexion); // Met à jour la base
                System.out.println("Mot de passe encodé pour l'utilisateur avec l'ID : " + connexion.getUserId());
            }
        }
    }
}
