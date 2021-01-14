package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/get/all")
    public List<Dish> getDishes() {
        return dishService.getAllDishes();
    }

    @PostMapping("/add")
    public boolean addNewDish(@RequestBody Dish dish){
        return dishService.addDish(dish);
    }

    @GetMapping("/get")
    public Dish getDishById(@RequestParam int id) { return dishService.getDishById(id); }

    @DeleteMapping("/delete")
    public boolean deleteDishById(@RequestParam int id) { return dishService.deleteDish(id); }

    @PatchMapping("/patch")
    public  boolean patchDish(@RequestBody Dish dish) { return dishService.updateDish(dish); }
}
