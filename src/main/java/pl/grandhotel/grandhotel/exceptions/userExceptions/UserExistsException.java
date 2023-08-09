package pl.grandhotel.grandhotel.exceptions.userExceptions;

public class UserExistsException extends UserException{
    public UserExistsException() {
        super("This user is exist");
    }
}
