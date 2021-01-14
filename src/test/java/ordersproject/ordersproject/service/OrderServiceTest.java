package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.*;
import ordersproject.ordersproject.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private DishRepository dishRepository;
    @Mock
    private MenuRepository menuRepository;
    @Mock
    private OrderRepository orderRepository;

    @Test
    @DisplayName("Adding a new order")
    public void addOrderTest() {
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address = new Address(90,"Third street", "Bucharest", "122", null);
        Order order = new Order(10,customer,address, 900);

        //arrange
        when(orderRepository.getAllOrders()).thenReturn(null);
        when(orderRepository.addOrder(order)).thenReturn(true);
        when(orderRepository.getAllOrders()).thenReturn(Arrays.asList(order));

        //act
        boolean result = orderService.addOrder(order);
        List<Order> resultList = orderService.getAllOrders();

        //assert
        assertEquals(true, result);
        assertEquals(resultList.size(), 1);
    }

    @Test
    @DisplayName("Retrieving an order by id")
    public void getOrderByIdTest(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address = new Address(90,"Third street", "Bucharest", "122", null);
        Order order = new Order(10,customer,address, 900);

        //arrange
        when(orderRepository.getOrderById(10)).thenReturn(order);

        //act
        Order result = orderService.getOrderById(10);

        //assert
        assertEquals(result.getCustomer().getId(), order.getCustomer().getId());
        assertEquals(result.getAddress().getId(), order.getAddress().getId());
    }

    @Test
    @DisplayName("Deleting an order")
    public void deleteOrderTest(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address = new Address(90,"Third street", "Bucharest", "122", null);
        Order order = new Order(10,customer,address, 900);

        //arrange
        when(orderRepository.getOrderById(10)).thenReturn(order);
        when(orderRepository.deleteOrder(10)).thenReturn(true);
        when(orderRepository.getOrderById(10)).thenReturn(null);

        //act
        boolean result = orderService.deleteOrder(10);
        Order resultOrder = orderService.getOrderById(10);

        //assert
        assertNull(resultOrder);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Updating an order")
    public void updateOrder(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address = new Address(90,"Third street", "Bucharest", "122", null);
        Order order = new Order(10,customer,address, 900);
        Order order1 = new Order(10, customer, address, 90);
        //arrange
        when(orderRepository.getOrderById(10)).thenReturn(order);
        when(orderRepository.updateOrder(order1)).thenReturn(true);
        when(orderRepository.getOrderById(10)).thenReturn(order1);

        //act
        boolean result = orderService.updateOrder(order1);
        Order resultOrder = orderService.getOrderById(10);

        //assert
        assertEquals(result, true);
        assertEquals(resultOrder.getTotalPrice(), order1.getTotalPrice());
    }

    @Test
    @DisplayName("Adding a dish to an order")
    public void addDishToOrderTest(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address = new Address(90,"Third street", "Bucharest", "122", null);
        Order order = new Order(10,customer,address, 900);
        Dish dish = new Dish(99,"Burger", 10, "beef burger");

        //assert
        when(orderRepository.getOrderDishes(10)).thenReturn(null);
        when(orderRepository.addDishToOrder(10,99)).thenReturn(true);
        when(orderRepository.getOrderDishes(10)).thenReturn(Arrays.asList(dish));

        //act
        boolean result = orderService.addDishToOrder(10,99);
        List<Dish> resultList = orderService.getOrderDishes(10);

        //assert
        assertEquals(result, true);
        assertEquals(resultList.size(), 1);
    }

    @Test
    @DisplayName("Adding a menu to an order")
    public void addMenuToOrderTest(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address = new Address(90,"Third street", "Bucharest", "122", null);
        Order order = new Order(10,customer,address, 900);
        Menu menu = new Menu(1,"Menu Beef", "Burger, fries and cola", 15, null);

        //assert
        when(orderRepository.getOrderMenus(10)).thenReturn(null);
        when(orderRepository.addMenuToOrder(10,1)).thenReturn(true);
        when(orderRepository.getOrderMenus(10)).thenReturn(Arrays.asList(menu));

        //act
        boolean result = orderService.addMenuToOrder(10,1);
        List<Menu> resultList = orderService.getOrderMenus(10);

        //assert
        assertEquals(result, true);
        assertEquals(resultList.size(), 1);
    }

}
