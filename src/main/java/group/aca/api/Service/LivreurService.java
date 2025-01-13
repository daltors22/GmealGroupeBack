package group.aca.api.Service;

import group.aca.api.Entity.Livreur;
import group.aca.api.Repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurService {

    @Autowired
    private LivreurRepository livreurRepository;

    public List<Livreur> getAllLivreurs() {
        return livreurRepository.findAll();
    }

    public Livreur getLivreurById(Integer id) {
        return livreurRepository.findById(id).orElse(null);
    }

    public Livreur createOrUpdateLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    public void deleteLivreur(Integer id) {
        livreurRepository.deleteById(id);
    }
}
