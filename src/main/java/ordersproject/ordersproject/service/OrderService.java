package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private GenericRepository genericRepository;

    public List<Order> getOrders(){
        return genericRepository.getOrders();
    }

    public List<Order> addOrder(Order order){
        return genericRepository.addNewOrder(order);
    }
}
