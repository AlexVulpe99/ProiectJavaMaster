package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() { return dishRepository.getAllDishes(); }

    public boolean addDish(Dish dish) { return dishRepository.addDish(dish); }

    public boolean deleteDish(int id) { return dishRepository.deleteDish(id); }

    public Dish getDishById(int id) { return dishRepository.getDishById(id); }

    public boolean updateDish(Dish dish) { return dishRepository.updateDish(dish); }

}
