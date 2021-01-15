package ordersproject.ordersproject.service;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.repository.AddressRepository;
import ordersproject.ordersproject.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AddressRepository addressRepository;

    @Test
    @DisplayName("Adding a new customer")
    public void addCustomerTest() {
        //arrange
        Customer customer = new Customer("Rando", "Cardissian", "rando@me.com", "0120120123");
        when(customerRepository.addCustomer(customer)).thenReturn(true);

        //act
        boolean result = customerService.addCustomer(customer);

        //assert
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Retrieving a customer by id")
    public void getCustomerByIdTest(){
        Customer customer = new Customer(1,"Rando", "Cardissian", "rando@me.com", "0120120123");
        //arrange
        when(customerRepository.getCustomerById(1)).thenReturn(
                customer
        );

        //act
        Customer result = customerService.getCustomerById(1);

        //assert
        assertEquals(result.getEmail(), customer.getEmail());
        assertEquals(result.getFirstName(), customer.getFirstName());
    }

    @Test
    @DisplayName("Retrieving a customer addresses")
    public void getCustomerAddressesTest(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        Address address1 = new Address("Second street", "Bucharest", "54", customer);
        Address address2 = new Address("Main street", "Bucharest", "34", customer);
        Address address3 = new Address("Third street", "Bucharest", "122", null);
        //arrange
        when(addressRepository.getAddressesByCustomerId(3)).thenReturn(
                Arrays.asList(
                        address1, address2
                )
        );

        //act
        List<Address> result = customerService.getCustomerAddresses(customer.getId());

        //assert
        assertEquals(result.size(), 2);
    }

    @Test
    @DisplayName("Adding a customer with a list of addresses")
    public void addCustomerWithAddressesTest(){
        Customer customer = new Customer(3,"Bob", "Foo", "bob@me.com", "423241124");
        List<Address> addresses = Arrays.asList(
                new Address("Second street", "Bucharest", "54", customer),
                new Address("Main street", "Bucharest", "34", customer)
                );

        //arrange
        when(customerRepository.addCustomer(customer)).thenReturn(true);
        when(customerRepository.getAllCustomers()).thenReturn(Arrays.asList(customer));
        when(addressRepository.addAddress(addresses.get(0))).thenReturn(true);
        when(addressRepository.addAddress(addresses.get(1))).thenReturn(true);
        when(addressRepository.getAddressesByCustomerId(customer.getId())).thenReturn(addresses);

        //act
        boolean resultBoolean = customerService.addCustomerWithAddresses(customer, addresses);
        List<Address> resultList = customerService.getCustomerAddresses(customer.getId());

        //assert
        assertEquals(resultList.size(), 2);
        assertEquals(resultBoolean, true);
    }
}
