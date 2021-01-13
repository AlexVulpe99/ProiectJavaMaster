package ordersproject.ordersproject.repository;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;
import ordersproject.ordersproject.querys.AddressQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Address> getAllAddresses() {
        try{
            return jdbcTemplate.query(AddressQuerys.GET_ALL_ADDRESSES, new BeanPropertyRowMapper<>(Address.class));
        }
        catch (Exception e){
            // TODO error management
            return null;
        }
    }

    public boolean addAddress(Address address) {
        try{
            jdbcTemplate.update(AddressQuerys.ADD_ADDRESS, address.getStreetName(), address.getCityName(), address.getStreetNumber(), address.getCustomer().getId());
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public boolean deleteAddressById(int id) {
        try{
            jdbcTemplate.update(AddressQuerys.DELETE_ADDRESS_BY_ID, id);
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public boolean deleteAddressesByCustomerId(int id) {
        try{
            jdbcTemplate.update(AddressQuerys.DELETE_CUSTOMER_ADDRESSES, id);
            return true;
        }
        catch (Exception e){
            // TODO error management
            return false;
        }
    }

    public Address getAddressById(int id) {
        try{
            var queryResult = jdbcTemplate.query(AddressQuerys.GET_ADDRESS_BY_ID, new BeanPropertyRowMapper<>(Address.class), id);
            // return the first object, since address id should be unique
            if (queryResult != null && queryResult.size() > 0)
                return queryResult.get(0);
            else
                return null;
        }
        catch (Exception e){
            return null;
        }
    }

    public List<Address> getAddressesByCustomerId(int id) {
        try{
            return jdbcTemplate.query(AddressQuerys.GET_ADDRESSES_BY_CUSTOMER_ID, new BeanPropertyRowMapper<>(Address.class), id);
        }
        catch (Exception e){
            // TODO error management
            return null;
        }
    }
}
