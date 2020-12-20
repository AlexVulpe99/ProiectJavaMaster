package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private GenericRepository genericRepository;

    public List<Dish> getDishes(){
        return genericRepository.getDishes();
    }

    public List<Dish> addDish(Dish dish){
        return genericRepository.addNewDish(dish);
    }
}
