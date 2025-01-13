package group.aca.api.Service;

import group.aca.api.Entity.Adresse;
import group.aca.api.Repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    public Adresse getAdresseById(Integer id) {
        return adresseRepository.findById(id).orElse(null);
    }

    public Adresse createAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    public void deleteAdresse(Integer id) {
        adresseRepository.deleteById(id);
    }
}
