package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.querys.MenuQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Menu> getAllMenus() {
        try{
            return jdbcTemplate.query(MenuQuerys.GET_ALL_MENUS, new BeanPropertyRowMapper<>(Menu.class));
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean addMenu(Menu menu) {
        try{
            jdbcTemplate.update(MenuQuerys.ADD_MENU, menu.getName(), menu.getPrice(), menu.getDescription());
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteMenu(int id) {
        try{
            jdbcTemplate.update(MenuQuerys.DELETE_MENU, id);
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Menu getMenuById(int id) {
        try{
            var queryResult = jdbcTemplate.query(MenuQuerys.GET_MENU, new BeanPropertyRowMapper<>(Menu.class), id);
            // return the first object, since menu id should be unique
            if (queryResult != null && queryResult.size() > 0)
                return queryResult.get(0);
            else
                return null;
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updateMenu(Menu menu) {
        try{
            jdbcTemplate.update(MenuQuerys.UPDATE_MENU, menu.getName(), menu.getPrice(), menu.getDescription(), menu.getId());
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Dish> getMenuDishes(int id) {
        try{
            return jdbcTemplate.query(MenuQuerys.GET_MENU_DISHES, new BeanPropertyRowMapper<>(Dish.class), id);
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean addDishToMenu(int menuId, int dishId) {
        try{
            jdbcTemplate.update(MenuQuerys.ADD_DISH_TO_MENU, menuId, dishId);
            return true;
        }
        catch (Exception e){
            // TODO error management
            System.out.println(e.getMessage());
            return false;
        }
    }
}
