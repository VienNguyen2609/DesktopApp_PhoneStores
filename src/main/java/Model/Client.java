
package Model;

/**
 *
 * @author Danh Thao
 */
public class Client {
    
    private int idClient;
    private String nameClient;
    private String telClient;
    private String addressClient;
    private String gmailClient;

    public Client() {
    }

    public Client(int idClient, String nameClient, String telClient, String gmailClient) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.telClient = telClient;
        this.gmailClient = gmailClient;
    }

    public Client(String telClient) {
        this.telClient = telClient;
    }

    public Client(String nameClient, String telClient, String addressClient, String gmailClient) {
        this.nameClient = nameClient;
        this.telClient = telClient;
        this.addressClient = addressClient;
        this.gmailClient = gmailClient;
    }

    public Client(String nameClient, String telClient, String gmailClient) {
        this.nameClient = nameClient;
        this.telClient = telClient;
        this.gmailClient = gmailClient;
    }



    public Client(int idClient, String nameClient, String telClient, String addressClient, String gmailClient) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.telClient = telClient;
        this.addressClient = addressClient;
        this.gmailClient = gmailClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public String getGmailClient() {
        return gmailClient;
    }

    public void setGmailClient(String gmailClient) {
        this.gmailClient = gmailClient;
    }
    
}
