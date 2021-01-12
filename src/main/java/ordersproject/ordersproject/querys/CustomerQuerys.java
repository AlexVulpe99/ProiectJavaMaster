package ordersproject.ordersproject.querys;

public class CustomerQuerys {
    public final static String GET_ALL_CUSTOMERS = "select * from persoana";
    public final static String ADD_CUSTOMER ="INSERT INTO persoana(idPersoana,numePersoana,prenumePersoana) values (null,?,?)";
    public final static String DELETE_CUSTOMER ="DELETE FROM persoana where idPersoana = ?";

}
