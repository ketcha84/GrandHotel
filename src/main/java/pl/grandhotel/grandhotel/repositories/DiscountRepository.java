package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}
