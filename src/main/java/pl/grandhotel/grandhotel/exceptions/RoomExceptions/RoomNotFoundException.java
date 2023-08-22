package pl.grandhotel.grandhotel.exceptions.RoomExceptions;

public class RoomNotFoundException extends RoomException {
    public RoomNotFoundException() {
        super("Room Not Found");
    }

    public RoomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomNotFoundException(Throwable cause) {
        super(cause);
    }
}
