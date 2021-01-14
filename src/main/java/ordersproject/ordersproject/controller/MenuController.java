package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.service.MenuService;
import ordersproject.ordersproject.wrapper.MenuDishesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/get/all")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @PostMapping("/add")
    public boolean addNewMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }

    @PostMapping("/add/withDishes")
    public boolean addMenuWithDishes(@RequestBody MenuDishesWrapper menuDishesWrapper) { return menuService.addMenuWithDishes(menuDishesWrapper.getMenu(), menuDishesWrapper.getDishList()); }

    @DeleteMapping("/delete")
    public boolean deleteMenuById(@RequestParam int id) { return menuService.deleteMenu(id); }

    @GetMapping("/get")
    public Menu getMenuById(@RequestParam int id) { return menuService.getMenuById(id); }

    @PatchMapping("/patch")
    public boolean patchMenu(@RequestBody Menu menu) { return menuService.updateMenu(menu); }

    @PostMapping("/add/dish")
    public boolean addDishToMenu(@RequestBody int dishId, @RequestParam int menuId) { return menuService.addDishToMenu(menuId, dishId); }

    @GetMapping("/get/dishes")
    public List<Dish> getMenuDishes(@RequestParam int id) { return menuService.getMenuDishes(id); }
}
