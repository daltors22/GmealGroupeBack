package group.aca.api.Service;

import group.aca.api.Entity.Promotion;
import group.aca.api.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getPromotionById(Integer id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public Promotion createOrUpdatePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public void deletePromotion(Integer id) {
        promotionRepository.deleteById(id);
    }
}
