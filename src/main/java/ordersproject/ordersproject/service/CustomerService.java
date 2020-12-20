package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private GenericRepository genericRepository;

    public List<Customer> getCustomers(){
        return genericRepository.getCustomers();
    }

    public List<Customer> addCustomer(Customer customer){
        return genericRepository.addNewCustomer(customer);
    }

    // TODO add the logic for addresses here
}
