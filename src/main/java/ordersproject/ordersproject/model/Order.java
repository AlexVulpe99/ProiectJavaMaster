package ordersproject.ordersproject.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private Address address;
    private double totalPrice;
    private String paymentMethod;
    private List<Dish> dishList;
    private List<Menu> menuList;

    public Order() {}

    public Order(Customer customer, Address address, String paymentMethod) {
        this.customer = customer;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.menuList = new ArrayList<>();
        this.dishList = new ArrayList<>();
    }

    public Order(Customer customer, Address address, String paymentMethod, List<Dish> dishList, List<Menu> menuList) {
        this.customer = customer;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.dishList = dishList;
        this.menuList = menuList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
