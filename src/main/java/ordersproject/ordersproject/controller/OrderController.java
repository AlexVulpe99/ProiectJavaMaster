package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.service.OrderService;
import ordersproject.ordersproject.wrapper.OrderMenusDishesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/add")
    public boolean addNewOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @DeleteMapping("/delete")
    public boolean deleteOrderById(@RequestParam int id) { return orderService.deleteOrder(id); }

    @GetMapping("/get")
    public Order getOrderById(@RequestParam int id) { return orderService.getOrderById(id); }

    @PatchMapping("/patch")
    public boolean patchOrder(@RequestBody Order order) { return orderService.updateOrder(order); }

    @GetMapping("/get/dishes")
    public List<Dish> getOrderDishes(@RequestParam int id) { return orderService.getOrderDishes(id); }

    @GetMapping("/get/menus")
    public List<Menu> getOrderMenus(@RequestParam int id) { return orderService.getOrderMenus(id); }

    @PostMapping("/add/withDishesMenus")
    public boolean addOrderWithDishesMenus(@RequestBody OrderMenusDishesWrapper wrapper) { return orderService.addOrderWithMenusAndDishes(wrapper); }

    @PostMapping("/add/dish")
    public boolean addDishToOrder(@RequestBody int dishId, @RequestParam int orderId) { return orderService.addDishToOrder(orderId, dishId); }

    @PostMapping("/add/menu")
    public boolean addMenuToOrder(@RequestBody int menuId, @RequestParam int orderId) { return orderService.addMenuToOrder(orderId, menuId); }

}
