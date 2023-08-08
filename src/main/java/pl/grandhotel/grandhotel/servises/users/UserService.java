package pl.grandhotel.grandhotel.servises.users;

import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.repositories.UserRepository;

@Service
public class UserService {
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

}
