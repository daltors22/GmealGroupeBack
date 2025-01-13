package group.aca.api.Service;

import group.aca.api.Entity.Administrateur;
import group.aca.api.Repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Administrateur getAdministrateurById(Integer id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    public Administrateur createAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public void deleteAdministrateur(Integer id) {
        administrateurRepository.deleteById(id);
    }
}