package ordersproject.ordersproject.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private String name;
    private String description;
    private double price;
    private List<Dish> dishList;

    public Menu() {}

    public Menu(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dishList = new ArrayList<>();
    }

    public Menu(String name, String description, double price, List<Dish> dishList) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dishList = dishList;
    }

    public Menu(int id, String name, String description, double price, List<Dish> dishList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dishList = dishList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
