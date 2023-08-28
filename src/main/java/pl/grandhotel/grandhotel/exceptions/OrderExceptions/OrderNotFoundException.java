package pl.grandhotel.grandhotel.exceptions.OrderExceptions;

public class OrderNotFoundException extends OrderException{

    public OrderNotFoundException(){
        super("Order not found");
    }
    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotFoundException(Throwable cause) {
        super(cause);
    }
}
