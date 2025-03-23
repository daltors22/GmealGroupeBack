package group.aca.api.Service;

import group.aca.api.Entity.Commandes;
import group.aca.api.Repository.CommandesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Commandes getCommandeById(Integer id) {
        return commandesRepository.findById(id).orElse(null);
    }

    public Commandes createOrUpdateCommande(Commandes commande) {
        return commandesRepository.save(commande);
    }

    public void deleteCommande(Integer id) {
        commandesRepository.deleteById(id);
    }
}
