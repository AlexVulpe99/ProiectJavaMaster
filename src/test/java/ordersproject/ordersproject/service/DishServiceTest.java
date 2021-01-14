package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.model.Dish;
import ordersproject.ordersproject.repository.AddressRepository;
import ordersproject.ordersproject.repository.CustomerRepository;
import ordersproject.ordersproject.repository.DishRepository;
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
public class DishServiceTest {
    @InjectMocks
    private DishService dishService;

    @Mock
    private DishRepository dishRepository;

    @Test
    @DisplayName("Adding a new dish")
    public void addDishTest() {
        //arrange
        Dish dish = new Dish("Burger", 10, "beef burger");
        when(dishRepository.addDish(dish)).thenReturn(true);

        //act
        boolean result = dishService.addDish(dish);

        //assert
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Retrieving a dish by id")
    public void getDishByIdTest(){
        Dish dish = new Dish(1,"Burger", 10, "beef burger");
        //arrange
        when(dishRepository.getDishById(1)).thenReturn(
                dish
        );

        //act
        Dish result = dishService.getDishById(1);

        //assert
        assertEquals(result.getName(), dish.getName());
        assertEquals(result.getDescription(), dish.getDescription());
    }

    @Test
    @DisplayName("Deleting a dish")
    public void deleteDishTest(){
        Dish dish = new Dish(1,"Burger", 10, "beef burger");
        //arrange
        when(dishRepository.getDishById(1)).thenReturn(dish);
        when(dishRepository.deleteDish(1)).thenReturn(true);
        when(dishRepository.getDishById(1)).thenReturn(null);

        //act
        boolean result = dishService.deleteDish(1);
        Dish resultDish = dishService.getDishById(1);

        //assert
        assertNull(resultDish);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Updating a dish")
    public void updateDishTest(){
        Dish dish = new Dish(1,"Burger", 10, "beef burger");
        Dish dish2 = new Dish(1, "Fries", 2, "");
        //arrange
        when(dishRepository.getDishById(1)).thenReturn(dish);
        when(dishRepository.updateDish(dish2)).thenReturn(true);
        when(dishRepository.getDishById(1)).thenReturn(dish2);

        //act
        boolean result = dishService.updateDish(dish2);
        Dish resultDish = dishService.getDishById(1);

        //assert
        assertEquals(result, true);
        assertEquals(resultDish.getName(), dish2.getName());
    }
}
