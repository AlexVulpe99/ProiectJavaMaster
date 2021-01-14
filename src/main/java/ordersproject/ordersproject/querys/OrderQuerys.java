package ordersproject.ordersproject.querys;

public class OrderQuerys {
    public final static String GET_ALL_ORDERS = "Select o.id, o.totalPrice, a.id, a.streetName, a.cityName, a.streetNumber, c.id, c.firstName, c.lastName, c.email, c.phoneNumber from orders o join customers c on c.id = o.customerID join addresses a on a.id = o.addressID";
    public final static String ADD_ORDER ="INSERT INTO orders(totalPrice,customerID,addressID) values (?,?,?)";
    public final static String DELETE_ORDER ="DELETE FROM orders where id = ?";
    public final static String GET_ORDER_BY_ID ="Select o.id, o.totalPrice, a.id, a.streetName, a.cityName, a.streetNumber, c.id, c.firstName, c.lastName, c.email, c.phoneNumber from orders o join customers c on c.id = o.customerID join addresses a on a.id = o.addressID WHERE o.id=?";
    public final static String UPDATE_ORDER ="UPDATE orders SET totalPrice=?, customerID=?, addressID=? WHERE id=?";
    public final static String GET_ORDER_DISHES ="SELECT d.id,d.name,d.price,d.description FROM dishes d join orderdishes od on d.id = od.dishID join orders o on o.id = od.orderID where o.id =?";
    public final static String GET_ORDER_MENUS = "SELECT m.id,m.name,m.price,m.description FROM menus m join ordermenus om on m.id = om.menuID join orders o on o.id = om.orderID where o.id =?";
    public final static String ADD_DISH_TO_ORDER ="INSERT INTO orderdishes(orderID,dishID) values (?,?)";
    public final static String ADD_MENU_TO_ORDER ="INSERT INTO ordermenus(orderID,menuID) values (?,?)";
}
