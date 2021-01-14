package ordersproject.ordersproject.wrapper;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;

import java.util.List;

public class MenuDishesWrapper {
    private Menu menu;
    private List<Integer> dishList;

    public MenuDishesWrapper() {
    }

    public MenuDishesWrapper(Menu menu, List<Integer> dishList) {
        this.menu = menu;
        this.dishList = dishList;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Integer> getDishList() {
        return dishList;
    }

    public void setDishList(List<Integer> dishList) {
        this.dishList = dishList;
    }
}
