package ordersproject.ordersproject.wrapper;

import ordersproject.ordersproject.model.Order;

import java.util.List;

public class OrderMenusDishesWrapper {
    private Order order;
    private List<Integer> menuList;
    private List<Integer> dishList;

    public OrderMenusDishesWrapper() {
    }

    public OrderMenusDishesWrapper(Order order, List<Integer> menuList, List<Integer> dishList) {
        this.order = order;
        this.menuList = menuList;
        this.dishList = dishList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Integer> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Integer> menuList) {
        this.menuList = menuList;
    }

    public List<Integer> getDishList() {
        return dishList;
    }

    public void setDishList(List<Integer> dishList) {
        this.dishList = dishList;
    }
}
