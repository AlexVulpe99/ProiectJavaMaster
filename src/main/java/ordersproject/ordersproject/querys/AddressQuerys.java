package ordersproject.ordersproject.querys;

public class AddressQuerys {
    public final static String GET_ALL_ADDRESSES = "Select a.id, a.streetName, a.cityName, a.streetNumber, c.id, c.firstName, c.lastName, c.email, c.phoneNumber from addresses a join customers c on c.id = a.customerID";
    public final static String ADD_ADDRESS ="INSERT INTO addresses(streetName,cityName,streetNumber,customerID) values (?,?,?,?)";
    public final static String DELETE_ADDRESS_BY_ID ="DELETE FROM addresses where id = ?";
    public final static String DELETE_CUSTOMER_ADDRESSES ="DELETE FROM addresses where customerID = ?";
    public final static String GET_ADDRESS_BY_ID = "Select a.id, a.streetName, a.cityName, a.streetNumber, c.id, c.firstName, c.lastName, c.email, c.phoneNumber from addresses a join customers c on c.id = a.customerID WHERE a.id =?";
    public final static String GET_ADDRESSES_BY_CUSTOMER_ID = "Select a.id, a.streetName, a.cityName, a.streetNumber, c.id, c.firstName, c.lastName, c.email, c.phoneNumber from addresses a join customers c on c.id = a.customerID WHERE a.customerID =?";
}
