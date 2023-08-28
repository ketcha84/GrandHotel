package pl.grandhotel.grandhotel.exceptions.userExceptions;

public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
        super("User does not exists");
    }
}
