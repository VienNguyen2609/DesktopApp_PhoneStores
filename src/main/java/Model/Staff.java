package Model;

public class Staff {

    private int id;
    private String name;
    private String password;
    private String email;
    private String position;
    private boolean status;
    private byte[] avatar;

    public Staff(String name, String password, String email ) {
        this(name, password, email , null);
    }

   
    public Staff(int id, String name, String password, String email, String position, boolean status ,byte[] avatar) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.position = position;
        this.status = status;
        this.avatar = avatar;
    }
    public Staff(String name, String password, String email, String position, byte[] avatar) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.position = position;
        this.avatar = avatar;
    }
    

    public Staff(String name, String password, String email,  byte[] avatar) {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
    
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

}
