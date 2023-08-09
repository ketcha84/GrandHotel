package pl.grandhotel.grandhotel.servises.users;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.exceptions.userExceptions.UserException;
import pl.grandhotel.grandhotel.exceptions.userExceptions.UserExistsException;
import pl.grandhotel.grandhotel.exceptions.userExceptions.UserIllegalParametersException;
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

    /*
    -------------------Setters----------------------------------->
     */

    public User createUser(User user) throws UserException {
        if (repository.exists(Example.of(user))) {
            throw new UserExistsException();
        }
        if (isValid(user)) {
            user.setUserStatus(Status.NEW);
            repository.save(user);
            return user;
        } else {
            throw new UserIllegalParametersException();
        }
    }

    public User updateUser(User user) throws UserException {
        if (!isValid(user)) {
            throw new UserIllegalParametersException();
        }
        if (!repository.exists(Example.of(user))) {
            throw new UserException("User not found.");
        }
        return repository.save(user);
    }

    public boolean deleteUser(User user) {
        if (!isValid(user)) {
            return false;
        }
        if (!repository.existsById(user.getUserId())) {
            return false;
        }
        repository.delete(user);
        return true;
    }

    private boolean isValid(User user) {
        return user.getUserName() != null
                && !user.getUserName().equals("")
                && user.getUserLastname() != null
                && !user.getUserLastname().equals("")
                && user.getUserEmail() != null
                && checkEmail(user.getUserEmail())
                && user.getUserPassword() != null
                && !user.getUserPassword().equals("")
                && checkPhone(user.getUserPhone());
    }

    private boolean checkPhone(String userPhone) {
        return userPhone.matches("^[1-9]\\d{8}");
    }

    private boolean checkEmail(String email) {
        return email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$");
    }
}
