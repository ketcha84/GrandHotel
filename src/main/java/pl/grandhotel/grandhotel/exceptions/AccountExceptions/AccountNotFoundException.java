package pl.grandhotel.grandhotel.exceptions.AccountExceptions;

public class AccountNotFoundException extends AccountException{
    public AccountNotFoundException() {
        super("Account not found");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundException(Throwable cause) {
        super(cause);
    }
}
