package pl.grandhotel.grandhotel.exceptions.RoomExceptions;

public class RoomNotFoundException extends RoomException {
    public RoomNotFoundException() {
        super("Room Not Found");
    }
}
