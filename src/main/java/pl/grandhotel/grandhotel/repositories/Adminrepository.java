package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grandhotel.grandhotel.model.Account;

public interface Adminrepository extends JpaRepository<Account, Integer> {
}
