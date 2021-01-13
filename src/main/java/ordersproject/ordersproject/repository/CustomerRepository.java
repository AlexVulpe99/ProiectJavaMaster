package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.querys.CustomerQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers() {
        try{
            return jdbcTemplate.query(CustomerQuerys.GET_ALL_CUSTOMERS, new BeanPropertyRowMapper<>(Customer.class));
        }
        catch (Exception e){
            // TODO error management
            return null;
        }
    }

    public boolean addCustomer(Customer customer) {
        try{
            jdbcTemplate.update(CustomerQuerys.ADD_CUSTOMER, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber());
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public boolean deleteCustomer(int id) {
        try{
            jdbcTemplate.update(CustomerQuerys.DELETE_CUSTOMER, id);
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public Customer getCustomerById(int id) {
        try{
            var queryResult = jdbcTemplate.query(CustomerQuerys.GET_CUSTOMER_BY_ID, new BeanPropertyRowMapper<>(Customer.class), id);
            // return the first object, since customer id should be unique
            if (queryResult != null && queryResult.size() > 0)
                return queryResult.get(0);
            else
                return null;
        }
        catch (Exception e){
            return null;
        }
    }
}
