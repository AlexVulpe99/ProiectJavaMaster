package ordersproject.ordersproject.querys;

public class MenuQuerys {
    public final static String GET_ALL_MENUS = "select * from menus";
    public final static String ADD_MENU ="INSERT INTO menus(name,price,description) values (?,?,?)";
    public final static String DELETE_MENU ="DELETE FROM menus where id = ?";
    public final static String UPDATE_MENU ="UPDATE menus SET name=?, price=?, description=? WHERE id=?";
    public final static String GET_MENU = "SELECT * FROM menus WHERE id=?";
    public final static String GET_MENU_DISHES = "SELECT d.id,d.name,d.price,d.description FROM dishes d join menudishes md on d.id = md.dishID join menus m on m.id = md.menuID where m.id =?";
    public final static String ADD_DISH_TO_MENU ="INSERT INTO menudishes(menuID,dishID) values (?,?)";
}
