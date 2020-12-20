package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/get")
    public List<Menu> getMenus() {
        return menuService.getMenus();
    }

    @PostMapping("/add")
    public List<Menu> addNewMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }
}
