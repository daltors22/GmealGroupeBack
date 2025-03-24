package group.aca.api.Service;

import group.aca.api.Entity.Ville;
import group.aca.api.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    public Ville getVilleById(String id) {
        return villeRepository.findById(id).orElse(null);
    }

    public Ville createOrUpdateVille(Ville ville) {
        return villeRepository.save(ville);
    }

    public void deleteVille(String id) {
        villeRepository.deleteById(id);
    }

    public List<Ville> searchVillesPrioritized(String query) {
        List<Ville> startWith = villeRepository.findByNameStartingWithIgnoreCase(query);
        List<Ville> containing = villeRepository.findByNameContainingIgnoreCase(query);

        // Supprimer les doublons (via ID)
        Set<String> idsStartWith = startWith.stream()
                .map(Ville::getIdVille)
                .collect(Collectors.toSet());

        List<Ville> filtered = containing.stream()
                .filter(v -> !idsStartWith.contains(v.getIdVille()))
                .collect(Collectors.toList());

        // Fusionner
        List<Ville> result = new ArrayList<>();
        result.addAll(startWith);
        result.addAll(filtered);

        // 🔥 Trier pour mettre "query" exact en haut, puis le reste par ordre alpha
        result.sort(Comparator.comparing((Ville v) -> !v.getName().equalsIgnoreCase(query)) // exact match en haut
                .thenComparing(v -> !v.getName().toLowerCase().startsWith(query.toLowerCase())) // ensuite ceux qui commencent par
                .thenComparing(Ville::getName)); // puis trie alpha

        return result;
    }




}
