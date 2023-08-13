package pl.grandhotel.grandhotel.exceptions.RoomExceptions;

public class RoomException extends Exception {
    public RoomException(String message) {
        super("Room exception: " + message);
    }
}
