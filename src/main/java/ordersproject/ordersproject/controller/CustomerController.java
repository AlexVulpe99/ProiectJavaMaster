package ordersproject.ordersproject.controller;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.service.CustomerService;
import ordersproject.ordersproject.wrapper.CustomerAddressesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get")
    public Customer getCustomerById(@RequestParam int id) { return customerService.getCustomerById(id); }

    @GetMapping("/get/address/all")
    public List<Address> getAllAddresses() { return customerService.getAllAddresses(); }

    @GetMapping("/get/address")
    public Address getAddressById(@RequestParam int id) { return customerService.getAddressById(id); }

    @GetMapping("/get/addresses")
    public List<Address> getCustomerAddresses(@RequestParam int id) { return customerService.getCustomerAddresses(id); }

    @PostMapping("/add")
    public boolean addNewCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/add/address")
    public boolean addNewAddressToCustomer(@RequestParam int customerId, @RequestBody Address address) { return customerService.addAddressToCustomer(address, customerId); }

    @PostMapping("/add/withAddresses")
    public boolean addNewCustomerWithAddresses(@RequestBody CustomerAddressesWrapper customerAddressesWrapper) { return customerService.addCustomerWithAddresses(customerAddressesWrapper.getCustomer(), customerAddressesWrapper.getAddressList()); }
}
