package Model;

import java.util.Date;

/**
 *
 * @author VIEN
 */
public class BillDisplay {

    private int billId;
    private String nameClient;
    private String namePhone;
    private int quantity;
    private double price;
    private double totalAmount;
    private Date billDate;
    private String paymentStatus ; 
    private String nameStaff ; 

    public BillDisplay(int billId, String nameClient, String namePhone, int quantity, 
            double price, double totalAmount, Date billDate, String paymentStatus, String nameStaff) {
        this.billId = billId;
        this.nameClient = nameClient;
        this.namePhone = namePhone;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
        this.paymentStatus = paymentStatus;
        this.nameStaff = nameStaff;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }
    
    
    
    
}
