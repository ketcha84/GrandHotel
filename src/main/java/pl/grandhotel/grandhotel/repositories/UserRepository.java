package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
