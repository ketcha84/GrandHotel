package pl.grandhotel.grandhotel.exceptions.RoomExceptions;

public class RoomIllegalArgumentException extends RoomException{
    public RoomIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public RoomIllegalArgumentException(){
        super("Room is not Valid, check entered data");
    }
}
