package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        var result = menuRepository.getAllMenus();
        for (Menu menu: result)
        {
            menu.setDishList(this.getMenuDishes(menu.getId()));
        }

        return result;
    }

    public boolean addMenu(Menu menu) { return menuRepository.addMenu(menu); }

    public boolean deleteMenu(int id) { return menuRepository.deleteMenu(id); }

    public Menu getMenuById(int id) {
        try{
            var result = menuRepository.getMenuById(id);
            result.setDishList(this.getMenuDishes(result.getId()));
            return result;
        }
        catch (Exception e){
            //TODO error management
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean updateMenu(Menu menu) { return menuRepository.updateMenu(menu); }

    public List<Dish> getMenuDishes(int id) { return menuRepository.getMenuDishes(id); }

    public boolean addDishToMenu(int menuID, int dishID) { return menuRepository.addDishToMenu(menuID, dishID); }

    public boolean addMenuWithDishes(Menu menu, List<Integer> dishList){
        boolean result = true;
        this.addMenu(menu);
        //refresh the menu object to get the id
        //TODO change the add method to return the newly created object
        //TODO remove this hack
        var menus = this.getAllMenus();
        menu = menus.get(menus.size() - 1);
        for(Integer id : dishList){
            result = result && this.addDishToMenu(menu.getId(), id);
        }

        return result;
    }

}
