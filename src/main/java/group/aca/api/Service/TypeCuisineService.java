package group.aca.api.Service;

import group.aca.api.Entity.TypeCuisine;
import group.aca.api.Repository.TypeCuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCuisineService {

    @Autowired
    private TypeCuisineRepository typeCuisineRepository;

    public List<TypeCuisine> getAllTypeCuisines() {
        return typeCuisineRepository.findAll();
    }

    public TypeCuisine getTypeCuisineById(Integer id) {
        return typeCuisineRepository.findById(id).orElse(null);
    }

    public TypeCuisine createOrUpdateTypeCuisine(TypeCuisine typeCuisine) {
        return typeCuisineRepository.save(typeCuisine);
    }

    public void deleteTypeCuisine(Integer id) {
        typeCuisineRepository.deleteById(id);
    }
}
