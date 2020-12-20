package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Menu;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private GenericRepository genericRepository;

    public List<Menu> getMenus(){
        return genericRepository.getMenus();
    }

    public List<Menu> addMenu(Menu menu){
        return genericRepository.addNewMenu(menu);
    }
}
