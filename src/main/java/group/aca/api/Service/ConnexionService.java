package group.aca.api.Service;

import group.aca.api.Entity.Connexion;
import group.aca.api.Repository.ConnexionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnexionService {

    @Autowired
    private ConnexionRepository connexionRepository;

    public List<Connexion> getAllConnexions() {
        return connexionRepository.findAll(); // Vérifiez que cela ne retourne pas une liste vide
    }

    public Connexion getConnexionById(Integer id) {
        return connexionRepository.findById(id).orElse(null); // Vérifiez que cet ID existe bien dans la base
    }
}


