package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.*;
import ordersproject.ordersproject.querys.OrderQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> getAllOrders() {
        try{
            return jdbcTemplate.query(OrderQuerys.GET_ALL_ORDERS, new OrderRowMapper());
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Order getOrderById(int id) {
        try{
            var queryResult = jdbcTemplate.query(OrderQuerys.GET_ORDER_BY_ID, new OrderRowMapper(), id);
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
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Dish> getOrderDishes(int id) {
        try{
            return jdbcTemplate.query(OrderQuerys.GET_ORDER_DISHES, new BeanPropertyRowMapper<>(Dish.class), id);
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Menu> getOrderMenus(int id) {
        try{
            return jdbcTemplate.query(OrderQuerys.GET_ORDER_MENUS, new BeanPropertyRowMapper<>(Menu.class), id);
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            return false;
        }
    }

    public class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            var customer = new Customer(
                    resultSet.getInt("c.id"),
                    resultSet.getString("c.firstName"),
                    resultSet.getString("c.lastName"),
                    resultSet.getString("c.email"),
                    resultSet.getString("c.phoneNumber")
            );
            var address = new Address(
                    resultSet.getInt("a.id"),
                    resultSet.getString("a.streetName"),
                    resultSet.getString("a.cityName"),
                    resultSet.getString("a.streetNumber"),
                    customer
            );
            return new Order(
                    resultSet.getInt("o.id"),
                    customer,
                    address,
                    resultSet.getDouble("o.totalPrice")
            );

        }
    }
}
