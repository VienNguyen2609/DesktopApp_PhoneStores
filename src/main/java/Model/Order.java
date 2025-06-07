package Model;


import java.util.Date;

public class Order {
    private int idOrder;
    private String nameOrder;
    private Date timeOfBookingOrder;
    private String statusOrder;
    private double totalOrder;
    private String addressOrder;
    private int idClient;
    private int idStaff;

    // Constructors
    public Order() {}

    public Order(int idOrder, String nameOrder, Date timeOfBookingOrder, String statusOrder, 
            double totalOrder, String addressOrder, int idClient, int idStaff) {
        this.idOrder = idOrder;
        this.nameOrder = nameOrder;
        this.timeOfBookingOrder = timeOfBookingOrder;
        this.statusOrder = statusOrder;
        this.totalOrder = totalOrder;
        this.addressOrder = addressOrder;
        this.idClient = idClient;
        this.idStaff = idStaff;
    }

    // Getters and Setters
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public Date getTimeOfBookingOrder() {
        return timeOfBookingOrder;
    }

    public void setTimeOfBookingOrder(Date timeOfBookingOrder) {
        this.timeOfBookingOrder = timeOfBookingOrder;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }
}

