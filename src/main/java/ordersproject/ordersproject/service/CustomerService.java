package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.repository.AddressRepository;
import ordersproject.ordersproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Customer getCustomerById(int id) { return customerRepository.getCustomerById(id); }

    public boolean addCustomer(Customer customer){
        return customerRepository.addCustomer(customer);
    }

    public boolean deleteCustomer(int id) { return customerRepository.deleteCustomer(id); }

    public List<Address> getCustomerAddresses(int customerId) { return addressRepository.getAddressesByCustomerId(customerId); }

    public boolean addAddressToCustomer(Address address, int customerID) {
        // If customerID = 0, it means the customer is defined in the address object
        if (customerID != 0)
            address.setCustomer(this.getCustomerById(customerID));
        return addressRepository.addAddress(address);
    }

    public List<Address> getAllAddresses() { return addressRepository.getAllAddresses(); }

    public Address getAddressById(int id) { return addressRepository.getAddressById(id); }

    public boolean deleteAddressById(int id) { return addressRepository.deleteAddressById(id); }

    public boolean deleteAddressesByCustomerId(int id) { return addressRepository.deleteAddressesByCustomerId(id); }

    public boolean addCustomerWithAddresses(Customer customer, List<Address> addresses) {
        boolean result = true;
        // Add the customer to the DB.
        this.addCustomer(customer);
        //TODO change the add method to return the newly created object
        //TODO remove this hack
        var customers = this.getAllCustomers();
        customer = customers.get(customers.size() - 1);
        // For each address, add the reference to the customer then add the address to DB
        for(Address address : addresses){
            address.setCustomer(customer);
            result = result && this.addAddressToCustomer(address, 0);
        }

        return result;
    }
}
