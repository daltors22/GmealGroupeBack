package group.aca.api.Service;

import group.aca.api.Entity.Commandes;
import group.aca.api.Entity.User;
import group.aca.api.Repository.CommandesRepository;
import group.aca.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommandesService {

    @Autowired
    private CommandesRepository commandesRepository;
    public List<Commandes> getAllCommandes() {
        return commandesRepository.findAll();
    }
    public List<Commandes> getCommandesByUserId(Integer userId) {
        return commandesRepository.findByUserId(userId);
    }

    @Autowired
    private UserRepository userRepository;

    public Commandes getCommandeById(Integer id) {
        return commandesRepository.findById(id).orElse(null);
    }

    public Commandes createOrUpdateCommande(Commandes commande) {
        commande.setStatusCommande("EN_ATTENTE"); // ou autre valeur par défaut
        commande.setDateCommande(LocalDateTime.now());
        commande.setDateLivraison(LocalDateTime.now());

        return commandesRepository.save(commande);
    }

    public void deleteCommande(Integer id) {
        commandesRepository.deleteById(id);
    }
}
