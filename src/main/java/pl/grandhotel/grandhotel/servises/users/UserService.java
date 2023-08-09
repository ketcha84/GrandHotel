package pl.grandhotel.grandhotel.servises.users;

import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.model.User;
import pl.grandhotel.grandhotel.model.types.Status;
import pl.grandhotel.grandhotel.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /* ----------------------------------gettery--------------------------------------------------->
     */
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    public Optional<User> getByLastName(String lastName) {
        return repository.findUserByUserLastnameContainsIgnoreCase(lastName);
    }

    public Optional<User> getByEmail(String email) {
        return repository.findUserByUserEmail(email);
    }

    public Optional<User> getByPhone(String phone) {
        return repository.findUserByUserPhone(phone);
    }

    public List<User> getByStatus(Status status) {
        return repository.findUserByUserStatus(status);
    }
}
