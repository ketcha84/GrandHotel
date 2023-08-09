package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Vat;

@Repository
public interface VatRepository extends JpaRepository<Vat, Integer> {
}
