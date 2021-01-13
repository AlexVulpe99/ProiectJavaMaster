package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/all")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get")
    public Customer getCustomerById(@RequestParam int id) { return customerService.getCustomerById(id); }

    @GetMapping("get/address/all")
    public List<Address> getAddresses() { return customerService.getAllAddresses(); }

    @GetMapping("get/address")
    public Address getAddressById(@RequestParam int id) { return customerService.getAddressById(id); }

    @PostMapping("/add")
    public boolean addNewCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //TODO add the logic for adding a customer with a new address and add the address
}
