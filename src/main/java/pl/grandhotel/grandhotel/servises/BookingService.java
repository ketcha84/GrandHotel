package pl.grandhotel.grandhotel.servises;

import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.model.Order;
import pl.grandhotel.grandhotel.repositories.*;

import java.util.List;

@Service
public class BookingService {
    DiscountRepository discountRepository;
    OrderRepository orderRepository;
    RoomRepository roomRepository;
    VatRepository vatRepository;
    UserService userService;

    public BookingService(DiscountRepository discountRepository,
                          OrderRepository orderRepository,
                          RoomRepository roomRepository,
                          VatRepository vatRepository,
                          UserService userService) {
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.roomRepository = roomRepository;
        this.vatRepository = vatRepository;
        this.userService = userService;
    }

    public Order bookARoom(Order order) {
        if (checkOrder(order)) {
            return order;
        }
        return new Order();
    }

    private boolean checkOrder(Order order) {
        if (order.getEndDate() == null || order.getStartDate() == null) {
            return false;
        }
        if (order.getStartDate().equals(order.getEndDate())
                || order.getStartDate().after(order.getEndDate())) {
            return false;
        }

        List<Order> l = orderRepository.findByRoomIdAndMaxEndDate(order.getRoomId(), order.getStartDate(), order.getEndDate());
        if (!l.isEmpty()) return false;

        if (order.getAmountNormal() == 0 && order.getAmountInvalid() == 0 && order.getAmountPensioner() == 0) {
            return false;
        }

        return true;
    }
}
