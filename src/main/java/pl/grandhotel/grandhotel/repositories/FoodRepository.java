package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
