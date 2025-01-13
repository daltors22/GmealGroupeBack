package group.aca.api.Service;

import group.aca.api.Entity.Ville;
import group.aca.api.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    public Ville getVilleById(Integer id) {
        return villeRepository.findById(id).orElse(null);
    }

    public Ville createOrUpdateVille(Ville ville) {
        return villeRepository.save(ville);
    }

    public void deleteVille(Integer id) {
        villeRepository.deleteById(id);
    }
}
