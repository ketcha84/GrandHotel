package pl.grandhotel.grandhotel.exceptions.AccountExceptions;

public class AccountIllegalArgumentException extends AccountException{
    public AccountIllegalArgumentException() {
        super("Account is not valid, check entered data");
    }

    public AccountIllegalArgumentException(String message) {
        super(message);
    }

    public AccountIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
