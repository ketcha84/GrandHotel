package pl.grandhotel.grandhotel.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.grandhotel.grandhotel.exceptions.OrderExceptions.OrderException;
import pl.grandhotel.grandhotel.model.Order;
import pl.grandhotel.grandhotel.servises.OrderService;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping()
    @ResponseBody
    public List<Order> getOrders(Model model) {
        var l = orderService.getOrders();
        model.addAttribute("orders", l);
        return l;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order getById(@PathVariable("id") Integer id) {
        try {
            var o = orderService.getOrderById(id);
            System.out.println(o);
            return o;
        } catch (OrderException e) {
            System.err.println(e);
        }
        return null;
    }


}
