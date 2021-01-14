package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.MenuRepository;
import ordersproject.ordersproject.repository.OrderRepository;
import ordersproject.ordersproject.wrapper.OrderMenusDishesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        var result = orderRepository.getAllOrders();
        for(Order order: result){
            order.setDishList(this.getOrderDishes(order.getId()));
            order.setMenuList(this.getOrderMenus(order.getId()));
        }

        return result;
    }

    public boolean addOrder(Order order) { return orderRepository.addOrder(order); }

    public boolean deleteOrder(int id) { return orderRepository.deleteOrder(id); }

    public Order getOrderById(int id) {
        try{
            var result = orderRepository.getOrderById(id);

            result.setMenuList(this.getOrderMenus(result.getId()));
            result.setDishList(this.getOrderDishes(result.getId()));

            return result;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean updateOrder(Order order) { return orderRepository.updateOrder(order); }

    public List<Dish> getOrderDishes(int id) { return orderRepository.getOrderDishes(id); }

    public List<Menu> getOrderMenus(int id) { return orderRepository.getOrderMenus(id); }

    public boolean addDishToOrder(int orderID, int dishID) { return orderRepository.addDishToOrder(orderID, dishID); }

    public boolean addMenuToOrder(int orderID, int menuID) { return orderRepository.addMenuToOrder(orderID, menuID); }

    public boolean addOrderWithMenusAndDishes(OrderMenusDishesWrapper wrapper){
        boolean result = true;
        var order = wrapper.getOrder();
        this.addOrder(order);
        //TODO change the add method to return the newly created object
        //TODO remove this hack
        var orders = this.getAllOrders();
        order = orders.get(orders.size() - 1);
        for(Integer id : wrapper.getDishList()){
            result = result && this.addDishToOrder(order.getId(), id);
        }

        for(Integer id : wrapper.getMenuList()){
            result = result && this.addMenuToOrder(order.getId(), id);
        }

        return result;
    }
}
