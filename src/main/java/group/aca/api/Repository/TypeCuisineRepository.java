package group.aca.api.Repository;

import group.aca.api.Entity.TypeCuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCuisineRepository extends JpaRepository<TypeCuisine, Integer> {
}
