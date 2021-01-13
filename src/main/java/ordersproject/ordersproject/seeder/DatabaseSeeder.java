package ordersproject.ordersproject.seeder;

import ordersproject.ordersproject.model.*;
import ordersproject.ordersproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private OrderRepository orderRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        // First seed the customers and addresses in this order since they are dependent
        this.seedCustomers();
        System.out.println("SEEDED CUSTOMERS");
        this.seedAddresses();
        System.out.println("SEEDED ADDRESSES");
        // Then seed the dishes, menus and orders in that order since they are dependent
        this.seedDishes();
        System.out.println("SEEDED DISHES");
        this.seedMenus();
        System.out.println("SEEDED MENUS");
        this.seedOrders();
        System.out.println("SEEDED ORDERS");
    }

    public void seedDishes() {
        // Get all dishes
        var dishes = this.dishRepository.getAllDishes();
        // If the table is empty, seed the table
        if (dishes == null || dishes.size() == 0) {
            this.dishRepository.addDish(new Dish("Burger", 10, "beef burger"));
            this.dishRepository.addDish(new Dish("French fries", 5,""));
            this.dishRepository.addDish(new Dish("Chicken crispy", 12,"5 strips"));
            this.dishRepository.addDish(new Dish("Cola", 4, "2L bottle"));
            this.dishRepository.addDish(new Dish("Sprite", 4, "2L bottle"));
        }
    }

    public void seedCustomers() {
        // Get all customers
        var customers = this.customerRepository.getAllCustomers();
        // If the table is empty, seed the table
        if (customers == null || customers.size() == 0) {
            this.customerRepository.addCustomer(new Customer("Alexandru", "Vulpe", "alexandru.vulpe@me.com", "0123456789"));
            this.customerRepository.addCustomer(new Customer("Bob", "Foo", "bob.foo@me.com", "0101020203"));
            this.customerRepository.addCustomer(new Customer("Alice", "Lor", "alice.lor@me.com", "3020201010"));
        }
    }

    private void seedAddresses() {
        // Get all addresses
        var addresses = this.addressRepository.getAllAddresses();
        // If the table is empty, seed the table
        if (addresses == null || addresses.size() == 0){
            var customers = this.customerRepository.getAllCustomers();
            this.addressRepository.addAddress(new Address("Main street", "Bucharest", "34", customers.get(0)));
            this.addressRepository.addAddress(new Address("Second street", "Bucharest", "54", customers.get(1)));
        }
    }

    private void seedMenus() {
        // Get all menus
        var menus = this.menuRepository.getAllMenus();
        // If the table is empty, seed the table
        if (menus == null || menus.size() == 0){
            var dishes = this.dishRepository.getAllDishes();
            this.menuRepository.addMenu((new Menu("Menu Beef", "Burger, fries and cola", 15)));
            this.menuRepository.addDishToMenu(1,dishes.get(0).getId());// Burger
            this.menuRepository.addDishToMenu(1,dishes.get(1).getId());// Fries
            this.menuRepository.addDishToMenu(1,dishes.get(3).getId());// Cola
        }
    }

    private void seedOrders() {
        // Get all orders
        var orders = this.orderRepository.getAllOrders();
        // If the table is empty, seed the table
        if (orders == null || orders.size() == 0){
            var customers = this.customerRepository.getAllCustomers();
            var addresses = this.addressRepository.getAllAddresses();
            var menus = this.menuRepository.getAllMenus();
            var dishes = this.dishRepository.getAllDishes();
            this.orderRepository.addOrder(new Order(customers.get(0), addresses.get(0), "cash"));
            this.orderRepository.addMenuToOrder(1,menus.get(0).getId());
            this.orderRepository.addDishToOrder(1,dishes.get(4).getId()); //Sprite
        }
    }

}
