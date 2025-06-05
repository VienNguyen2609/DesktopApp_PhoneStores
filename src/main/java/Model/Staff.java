
package Model;


public class Staff {
    
    private int id ; 
    private String name; 
    private String password; 
    private String email; 
    private byte [] avatar; 

    public Staff(String name, String password, String email) {
        this( name, password, email, null);
    }

    public Staff(int id, String name, String password, String email, byte[] avatar) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }

    public Staff(String name, String password, String email, byte[] avatar) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
   
    
}
