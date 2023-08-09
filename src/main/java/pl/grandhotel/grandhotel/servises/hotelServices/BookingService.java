package pl.grandhotel.grandhotel.servises.hotelServices;

import org.springframework.stereotype.Service;
import pl.grandhotel.grandhotel.model.Order;
import pl.grandhotel.grandhotel.repositories.*;
import pl.grandhotel.grandhotel.servises.users.UserService;

@Service
public class BookingService {
    DiscountRepository discountRepository;
    FoodRepository foodRepository;
    OrderRepository orderRepository;
    RoomRepository roomRepository;
    VatRepository vatRepository;
    UserService userService;

    public BookingService(DiscountRepository discountRepository,
                          FoodRepository foodRepository,
                          OrderRepository orderRepository,
                          RoomRepository roomRepository,
                          VatRepository vatRepository,
                          UserService userService) {
        this.discountRepository = discountRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
        this.roomRepository = roomRepository;
        this.vatRepository = vatRepository;
        this.userService = userService;
    }

    public Order bookARoom(Order order) {

        return new Order();
    }

    /* you can not book existing order with same date
    you can't book room with end_date <= start_date
    you can't book room with 0 amount of normal discounts
    you can't book room with user wich banned or not confirmed
     *
     *
     */
    private boolean checkOrder(Order order){

        return false;
    }
}