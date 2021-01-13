package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.model.Order;
import ordersproject.ordersproject.repository.AddressRepository;
import ordersproject.ordersproject.repository.CustomerRepository;
import ordersproject.ordersproject.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    public boolean addCustomer(Customer customer){
        return customerRepository.addCustomer(customer);
    }

    public List<Address> getCustomerAddresses(int customerId) { return addressRepository.getAddressesByCustomerId(customerId); }

    public boolean addAddressToCustomer(Address address) { return addressRepository.addAddress(address); }

    public List<Address> getAllAddresses() { return addressRepository.getAllAddresses(); }

}
