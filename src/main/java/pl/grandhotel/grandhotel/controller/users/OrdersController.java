package pl.grandhotel.grandhotel.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.grandhotel.grandhotel.servises.BookingService;

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    BookingService bookingService;


}
