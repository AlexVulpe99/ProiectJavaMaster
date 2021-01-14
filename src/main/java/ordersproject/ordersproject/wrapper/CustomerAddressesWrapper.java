package ordersproject.ordersproject.wrapper;

import ordersproject.ordersproject.model.Address;
import ordersproject.ordersproject.model.Customer;

import java.util.List;

public class CustomerAddressesWrapper {
    private Customer customer;
    private List<Address> addressList;

    public CustomerAddressesWrapper() {
    }

    public CustomerAddressesWrapper(Customer customer, List<Address> addressList) {
        this.customer = customer;
        this.addressList = addressList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
