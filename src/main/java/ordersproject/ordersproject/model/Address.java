package ordersproject.ordersproject.model;

public class Address {
    private int id;
    private String streetName;
    private String cityName;
    private String streetNumber;
    private Customer customer;

    public Address() {}

    public Address(String streetName, String cityName, String streetNumber, Customer customer) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.streetNumber = streetNumber;
        this.customer = customer;
    }

    public Address(int id, String streetName, String cityName, String streetNumber, Customer customer) {
        this.id = id;
        this.streetName = streetName;
        this.cityName = cityName;
        this.streetNumber = streetNumber;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
