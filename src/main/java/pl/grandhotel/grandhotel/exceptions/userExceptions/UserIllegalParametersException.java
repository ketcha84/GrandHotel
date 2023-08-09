package pl.grandhotel.grandhotel.exceptions.userExceptions;

public class UserIllegalParametersException extends UserException{
    public UserIllegalParametersException() {
        super("Invalid parameters of entity User");
    }
}
