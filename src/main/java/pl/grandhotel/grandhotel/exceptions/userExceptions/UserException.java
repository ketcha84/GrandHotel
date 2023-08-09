package pl.grandhotel.grandhotel.exceptions.userExceptions;

public class UserException extends Exception {
    public UserException(String message) {
        super("User exception " + message);
    }
}
