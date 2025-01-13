package group.aca.api.Service;

import group.aca.api.Entity.RapportActivite;
import group.aca.api.Repository.RapportActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportActiviteService {

    @Autowired
    private RapportActiviteRepository rapportActiviteRepository;

    public List<RapportActivite> getAllRapports() {
        return rapportActiviteRepository.findAll();
    }

    public RapportActivite getRapportById(Integer id) {
        return rapportActiviteRepository.findById(id).orElse(null);
    }

    public RapportActivite createOrUpdateRapport(RapportActivite rapport) {
        return rapportActiviteRepository.save(rapport);
    }

    public void deleteRapport(Integer id) {
        rapportActiviteRepository.deleteById(id);
    }
}