package Model;

import java.util.Date;

/**
 *
 * @author VIEN
 */
public class BillDisplay {

    private int billId;
    private String userName;
    private String phoneName;
    private int quantity;
    private double price;
    private double totalAmount;
    private Date billDate;
    private boolean PaymentStatus ; 

    public BillDisplay(int billId, String userName, String phoneName, int quantity, double price, double totalAmount, Date billDate, boolean PaymentStatus) {
        this.billId = billId;
        this.userName = userName;
        this.phoneName = phoneName;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
        this.PaymentStatus = PaymentStatus;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
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

    public boolean isPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(boolean PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }
    
    
    
    
}
