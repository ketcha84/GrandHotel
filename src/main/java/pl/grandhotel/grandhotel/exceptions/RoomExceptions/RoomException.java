package pl.grandhotel.grandhotel.exceptions.RoomExceptions;

public class RoomException extends Exception {
    public RoomException() {
        super();
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomException(String message) {
        super(message);
    }

    public RoomException(Throwable cause){
        super(cause);
    }
}
