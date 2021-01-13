package ordersproject.ordersproject.querys;

public class CustomerQuerys {
    public final static String GET_ALL_CUSTOMERS = "select * from customers";
    public final static String ADD_CUSTOMER ="INSERT INTO customers(firstName,lastName,email,phoneNumber) values (?,?,?,?)";
    public final static String DELETE_CUSTOMER ="DELETE FROM customers where id = ?";
    public final static String GET_CUSTOMER_BY_ID ="SELECT * from customers where id = ?";

}
