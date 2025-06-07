/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Danh Thao
 */
public class OrderForClient {
    private String nameClient;
    private String telClient;
 
    private String namePhone;
    private String brandPhone;
    private double pricePhone;
    private int quantity;

    public OrderForClient() {
    }

    public OrderForClient(String nameClient, String telClient, String namePhone, 
            String brandPhone, double pricePhone, int quantity) {
        this.nameClient = nameClient;
        this.telClient = telClient;
        this.namePhone = namePhone;
        this.brandPhone = brandPhone;
        this.pricePhone = pricePhone;
        this.quantity = quantity;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public String getBrandPhone() {
        return brandPhone;
    }

    public void setBrandPhone(String brandPhone) {
        this.brandPhone = brandPhone;
    }

    public double getPricePhone() {
        return pricePhone;
    }

    public void setPricePhone(double pricePhone) {
        this.pricePhone = pricePhone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
