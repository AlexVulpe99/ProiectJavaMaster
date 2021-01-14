package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.repository.AddressRepository;
import ordersproject.ordersproject.repository.CustomerRepository;
import ordersproject.ordersproject.repository.DishRepository;
import ordersproject.ordersproject.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MenuServiceTest {
    @InjectMocks
    private MenuService menuService;

    @Mock
    private DishRepository dishRepository;
    @Mock
    private MenuRepository menuRepository;

    @Test
    @DisplayName("Adding a new menu")
    public void addMenuTest() {
        Menu menu = new Menu("Menu Beef", "Burger, fries and cola", 15);
        //arrange
        when(menuRepository.getAllMenus()).thenReturn(null);
        when(menuRepository.addMenu(menu)).thenReturn(true);
        when(menuRepository.getAllMenus()).thenReturn(Arrays.asList(menu));

        //act
        boolean result = menuService.addMenu(menu);
        List<Menu> resultList = menuService.getAllMenus();

        //assert
        assertEquals(true, result);
        assertEquals(resultList.size(), 1);
    }

    @Test
    @DisplayName("Retrieving a menu by id")
    public void getMenuByIdTest(){
        Menu menu = new Menu(1,"Menu Beef", "Burger, fries and cola", 15, null);
        //arrange
        when(menuRepository.getMenuById(1)).thenReturn(menu);

        //act
        Menu result = menuService.getMenuById(1);

        //assert
        assertEquals(result.getName(), menu.getName());
        assertEquals(result.getDescription(), menu.getDescription());
    }

    @Test
    @DisplayName("Deleting a menu")
    public void deleteMenuTest(){
        Menu menu = new Menu(1,"Menu Beef", "Burger, fries and cola", 15, null);
        //arrange
        when(menuRepository.getMenuById(1)).thenReturn(menu);
        when(menuRepository.deleteMenu(1)).thenReturn(true);
        when(menuRepository.getMenuById(1)).thenReturn(null);

        //act
        boolean result = menuService.deleteMenu(1);
        Menu resultMenu = menuService.getMenuById(1);

        //assert
        assertNull(resultMenu);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Updating a menu")
    public void updateDishTest(){
        Menu menu = new Menu(1,"Menu Beef", "Burger, fries and cola", 15, null);
        Menu menu2 = new Menu(1,"Menu chicken","crispy",23,null);
        //arrange
        when(menuRepository.getMenuById(1)).thenReturn(menu);
        when(menuRepository.updateMenu(menu2)).thenReturn(true);
        when(menuRepository.getMenuById(1)).thenReturn(menu2);

        //act
        boolean result = menuService.updateMenu(menu2);
        Menu resultMenu = menuService.getMenuById(1);

        //assert
        assertEquals(result, true);
        assertEquals(resultMenu.getName(), menu2.getName());
    }

    @Test
    @DisplayName("Adding a dish to a menu")
    public void addDishToMenuTest(){
        Menu menu = new Menu(1,"Menu Beef", "Burger, fries and cola", 15, null);
        Dish dish = new Dish(99,"Burger", 10, "beef burger");

        //assert
        when(menuRepository.getMenuDishes(1)).thenReturn(null);
        when(menuRepository.addDishToMenu(1,99)).thenReturn(true);
        when(menuRepository.getMenuDishes(1)).thenReturn(Arrays.asList(dish));

        //act
        boolean result = menuService.addDishToMenu(1,99);
        List<Dish> resultList = menuService.getMenuDishes(1);

        //assert
        assertEquals(result, true);
        assertEquals(resultList.size(), 1);
    }

}
