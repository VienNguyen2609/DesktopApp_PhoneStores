
package Model;

import java.util.Date;


public class Bill {
    
    private int billId;
    private int userId;
    private int phoneId;
    private int quantity;
    private double totalAmount;
    private double price;
    private Date billDate;

    private static boolean isInitiallized = false;
    private static Bill instance;

    public static void init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new Bill();
            isInitiallized = true;
        }
    }

    public Bill(int billId, int userId, int phoneId, int quantity, double totalAmount, double price, Date billDate) {
        this.billId = billId;
        this.userId = userId;
        this.phoneId = phoneId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.price = price;
        this.billDate = billDate;
    }

    
    
    public Bill() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return phoneId;
    }

    public void setProductId(int productId) {
        this.phoneId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
}
