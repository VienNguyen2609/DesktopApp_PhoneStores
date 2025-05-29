
package Model;


public class Phone {
   
    private int phoneId ; 
    private String namePhone; 
    private String brandPhone; 
    private double pricePhone;
    private int quantityPhone; 
    private String operatingSystem;
    private byte[] imagePhone;
    private String description; 

    public Phone(String namePhone, String brandPhone, double pricePhone, int quantityPhone, String operatingSystem, byte[] imagePhone, String description) {
        this.namePhone = namePhone;
        this.brandPhone = brandPhone;
        this.pricePhone = pricePhone;
        this.quantityPhone = quantityPhone;
        this.operatingSystem = operatingSystem;
        this.imagePhone = imagePhone;
        this.description = description;
    }

    
    
    public Phone(int phoneId, String namePhone, String brandPhone, double pricePhone, int quantityPhone, String operatingSystem, byte[] imagePhone, String description) {
        this.phoneId = phoneId;
        this.namePhone = namePhone;
        this.brandPhone = brandPhone;
        this.pricePhone = pricePhone;
        this.quantityPhone = quantityPhone;
        this.operatingSystem = operatingSystem;
        this.imagePhone = imagePhone;
        this.description = description;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
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

    public int getQuantityPhone() {
        return quantityPhone;
    }

    public void setQuantityPhone(int quantityPhone) {
        this.quantityPhone = quantityPhone;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public byte[] getImagePhone() {
        return imagePhone;
    }

    public void setImagePhone(byte[] imagePhone) {
        this.imagePhone = imagePhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 }
