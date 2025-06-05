package Model;

/**
 *
 * @author VIEN
 */
public class OrderDetail {

    private int idOrder;
    private int idPhone;
    private int quantity;

    // Constructors
    public OrderDetail() {
    }

    public OrderDetail(int idOrder, int idPhone, int quantity) {
        this.idOrder = idOrder;
        this.idPhone = idPhone;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
