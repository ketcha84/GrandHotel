package pl.grandhotel.grandhotel.exceptions;

public class UserException extends Exception {
    public UserException(String message) {
        super("User exception " + message);
    }
}
