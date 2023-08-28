package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.Invoice;

@Repository
public interface InvoiceRepositiry extends JpaRepository<Invoice, Integer> {
}
