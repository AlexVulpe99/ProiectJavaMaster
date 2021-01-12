package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenericRepository {
    private static final List<Dish> dishes = new ArrayList<>();
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Menu> menus = new ArrayList<>();
    private static final List<Customer> customers = new ArrayList<>();
    private static final List<Address> addresses = new ArrayList<>();

    public GenericRepository() {
        dishes.add(new Dish("Burger", 10, "beef burger"));
        dishes.add(new Dish("French fries", 5,""));
        dishes.add(new Dish("Chicken crispy", 12,"5 strips"));
        dishes.add(new Dish("Cola", 4, "2L bottle"));
        dishes.add(new Dish("Sprite", 4, "2L bottle"));

        menus.add((new Menu("Menu Beef", "Burger, fries and cola", 15)));
        // TODO don't need this after the ORM implementation
        menus.get(0).getDishList().add(dishes.get(0)); // Burger
        menus.get(0).getDishList().add(dishes.get(1)); // Fries
        menus.get(0).getDishList().add(dishes.get(3)); // Cola

        customers.add(new Customer("Alexandru", "Vulpe", "alexandru.vulpe@me.com", "0123456789"));

        addresses.add(new Address("Main street", "Bucharest", "34", customers.get(0)));
        addresses.add(new Address("Second street", "Bucharest", "54", customers.get(0)));

        orders.add(new Order(customers.get(0), addresses.get(0), "cash"));
        orders.get(0).getMenuList().add(menus.get(0));
        orders.get(0).getDishList().add(dishes.get(4));
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Dish> addNewDish(Dish dish) {
        dishes.add(dish);
        return dishes;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> addNewOrder(Order order) {
        orders.add(order);
        return orders;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public List<Menu> addNewMenu(Menu menu) {
        menus.add(menu);
        return menus;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Customer> addNewCustomer(Customer customer) {
        customers.add(customer);
        return customers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Address> addNewAddress(Address address) {
        addresses.add(address);
        return addresses;
    }

    // TODO make a new repository for each entity
}
