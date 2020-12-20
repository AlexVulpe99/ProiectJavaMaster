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

    @GetMapping("/get")
    public List<Dish> getDishes() {
        return dishService.getDishes();
    }

    @PostMapping("/add")
    public List<Dish> addNewDish(@RequestBody Dish dish){
        return dishService.addDish(dish);
    }
}
