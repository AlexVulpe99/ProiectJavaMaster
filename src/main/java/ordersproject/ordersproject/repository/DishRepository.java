package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.querys.DishQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Dish> getAllDishes() {
        try{
            return jdbcTemplate.query(DishQuerys.GET_ALL_DISHES, new BeanPropertyRowMapper<>(Dish.class));
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean addDish(Dish dish) {
        try{
            jdbcTemplate.update(DishQuerys.ADD_DISH, dish.getName(), dish.getPrice(), dish.getDescription());
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteDish(int id) {
        try{
            jdbcTemplate.update(DishQuerys.DELETE_DISH, id);
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Dish getDishById(int id) {
        try{
            var queryResult = jdbcTemplate.query(DishQuerys.GET_DISH, new BeanPropertyRowMapper<>(Dish.class), id);
            // return the first object, since dish id should be unique
            if (queryResult != null && queryResult.size() > 0)
                return queryResult.get(0);
            else
                return null;
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updateDish(Dish dish) {
        try{
            jdbcTemplate.update(DishQuerys.UPDATE_DISH, dish.getName(), dish.getPrice(), dish.getDescription(), dish.getId());
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }
}
