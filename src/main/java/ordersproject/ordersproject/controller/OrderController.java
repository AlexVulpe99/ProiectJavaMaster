package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/add")
    public List<Order> addNewOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
}
