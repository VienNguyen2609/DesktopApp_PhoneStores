/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DatabaseConnection.SQLConnector;
import Model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Danh Thao
 */
public class ClientController {
    public static ClientController instance;
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static boolean isInitiallized = false;
    private final String insertClientSql="INSERT INTO Clients(nameClient,telClient"
            + ",gmailClient) VALUES(?,?,?)";
    
    private final String deleteClientSql="DELETE FROM Clients WHERE nameClient = ? AND telClient=?";
    
    private final String updateClientSql="UPDATE Clients SET nameClient=?,telClient=?,"
            + "gmailClient=? WHERE idClient=?";
    
    public static void init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new ClientController();
        isInitiallized = true;
    }
    
    private final String loadDataClientSQL="SELECT * FROM Clients";
    
    private void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhoneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<Client> loadDataAccounts() {
        List<Client> li=new ArrayList<Client>();
        try {
            setupDatabaseCommand(loadDataClientSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClient");
                String name = rs.getString("nameClient");
                String phone = rs.getString("telClient");
                String address = rs.getString("addressClient");
                String gmail = rs.getString("gmailClient");
                Client _client = new Client(id, name, phone, address,gmail);
                li.add(_client);
            }
                    

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return li;
    }
    
    public void addClient(Client cl) throws SQLException{
        setupDatabaseCommand(insertClientSql);
        
        ps.setString(1, cl.getNameClient());
        ps.setString(2, cl.getTelClient());
        ps.setString(3, cl.getGmailClient());
        
        int rss=ps.executeUpdate();
        System.out.println(rss);
        
    }
    
    public void delClient(String name, String telephone){
        try {
            setupDatabaseCommand(deleteClientSql);
            ps.setString(1, name);
            ps.setString(2, telephone);
            
            int rss=ps.executeUpdate();
            System.out.println(rss);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateClient(Client cl){
        try {
            setupDatabaseCommand(updateClientSql);
            ps.setString(1, cl.getNameClient());
            ps.setString(2, cl.getTelClient());
            ps.setString(3, cl.getGmailClient());
            ps.setInt(4, cl.getIdClient());
            
            int rss=ps.executeUpdate();
            System.out.println(rss);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
