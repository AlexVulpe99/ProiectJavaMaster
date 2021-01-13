package ordersproject.ordersproject.querys;

public class DishQuerys {
    public final static String GET_ALL_DISHES= "select * from dishes";
    public final static String ADD_DISH ="INSERT INTO dishes(name,price,description) values (?,?,?)";
    public final static String DELETE_DISH ="DELETE FROM dishes where id = ?";
    public final static String UPDATE_DISH ="UPDATE dishes SET name=?, price=?, description=? WHERE id=?";
    public final static String GET_DISH = "SELECT * FROM dishes WHERE id=?";
}
