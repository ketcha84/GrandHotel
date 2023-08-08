package pl.grandhotel.grandhotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grandhotel.grandhotel.model.User;
import pl.grandhotel.grandhotel.model.types.Status;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByUserLastnameContainsIgnoreCase(String lastName);
    Optional<User> findUserByUserEmail(String email);
    Optional<User> findUserByUserPhone(String phone);
    Optional<User> findUserByUserStatus(Status status);
}
