package pl.grandhotel.grandhotel.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grandhotel.grandhotel.exceptions.OrderExceptions.OrderException;
import pl.grandhotel.grandhotel.exceptions.OrderExceptions.OrderNotFoundException;
import pl.grandhotel.grandhotel.model.Order;
import pl.grandhotel.grandhotel.model.types.Status;
import pl.grandhotel.grandhotel.repositories.OrderRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InvoiceService invoiceService;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) throws OrderException {
        var o = orderRepository.findById(id);
        if (o.isEmpty()) {
            throw new OrderNotFoundException();
        } else {
            return o.get();
        }
    }

    public List<Order> getOrdersByUserId(int userId) throws OrderException {
        var lO = orderRepository.findByUserId(userId);
        if (lO.isEmpty()) {
            throw new OrderNotFoundException("There is no Orders with userId: " + userId);
        } else {
            return lO;
        }
    }

    public List<Order> getOrdersByStatus(Status status) throws OrderException {
        var lo = orderRepository.findByOrderStatus(status);
        if (lo.isEmpty()) {
            throw new OrderNotFoundException("There is no orders with status: " + status.toString());
        } else {
            return lo;
        }
    }

    public List<Order> getOrdersinBetween(LocalDate startDate, LocalDate enddate) throws OrderException {
        var lo = orderRepository.findByStartDateAndEndDate(Date.valueOf(startDate), Date.valueOf(enddate));
        if (lo.isEmpty()) {
            throw new OrderNotFoundException(String.format("There is no order with start Date: %s, and end Date %s", startDate, enddate));
        } else {
            return lo;
        }
    }

    public Order createOrder(Order order){
//        todo napisać metody createOrder()
//                przede wszystkim powinno występować transactional i tworzenie oraz dodanie invoce.

        return null;
    }

}
