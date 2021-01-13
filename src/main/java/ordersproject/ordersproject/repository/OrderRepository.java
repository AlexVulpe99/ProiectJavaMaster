package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.querys.OrderQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> getAllOrders() {
        try{
            return jdbcTemplate.query(OrderQuerys.GET_ALL_ORDERS, new BeanPropertyRowMapper<>(Order.class));
        }
        catch (Exception e){
            // TODO error management
            return null;
        }
    }

    public boolean addOrder(Order order) {
        try{
            jdbcTemplate.update(OrderQuerys.ADD_ORDER, order.getTotalPrice(), order.getCustomer().getId(), order.getAddress().getId());
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public boolean deleteOrder(int id) {
        try{
            jdbcTemplate.update(OrderQuerys.DELETE_ORDER, id);
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public Order getOrderById(int id) {
        try{
            var queryResult = jdbcTemplate.query(OrderQuerys.GET_ORDER_BY_ID, new BeanPropertyRowMapper<>(Order.class), id);
            // return the first object, since order id should be unique
            if (queryResult != null && queryResult.size() > 0)
                return queryResult.get(0);
            else
                return null;
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updateOrder(Order order) {
        try{
            jdbcTemplate.update(OrderQuerys.UPDATE_ORDER, order.getTotalPrice(), order.getCustomer().getId(), order.getAddress().getId());
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public List<Dish> getOrderDishes(int id) {
        try{
            return jdbcTemplate.query(OrderQuerys.GET_ORDER_DISHES, new BeanPropertyRowMapper<>(Dish.class), id);
        }
        catch (Exception e){
            // TODO error management
            return null;
        }
    }

    public List<Menu> getOrderMenus(int id) {
        try{
            return jdbcTemplate.query(OrderQuerys.GET_ORDER_MENUS, new BeanPropertyRowMapper<>(Menu.class), id);
        }
        catch (Exception e){
            // TODO error management
            return null;
        }
    }

    public boolean addDishToOrder(int orderId, int dishId) {
        try{
            jdbcTemplate.update(OrderQuerys.ADD_DISH_TO_ORDER, orderId, dishId);
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public boolean addMenuToOrder(int orderId, int menuId) {
        try{
            jdbcTemplate.update(OrderQuerys.ADD_MENU_TO_ORDER, orderId, menuId);
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }
}
