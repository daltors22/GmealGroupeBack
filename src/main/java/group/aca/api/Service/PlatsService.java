package group.aca.api.Service;

import group.aca.api.Entity.Plats;
import group.aca.api.Repository.PlatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatsService {

    @Autowired
    private PlatsRepository platsRepository;

    public List<Plats> getAllPlats() {
        return platsRepository.findAll();
    }

    public Plats getPlatById(Integer id) {
        return platsRepository.findById(id).orElse(null);
    }

    public Plats createOrUpdatePlat(Plats plat) {
        return platsRepository.save(plat);
    }

    public void deletePlat(Integer id) {
        platsRepository.deleteById(id);
    }
}
