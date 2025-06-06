
package Model;

/**
 *
 * @author VIEN
 */
public class Client {
    
    private int id ; 
    private String name ; 
    private String address ; 
    private String numberPhone; 
    private String email ; 

    public Client(int id, String name, String address, String numberPhone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
