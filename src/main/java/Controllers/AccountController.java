package Controllers;

import Model.Account;
import DatabaseConnection.SQLConnector;
import Forms.Components.EffectComponents;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AccountController {

    private ArrayList<Account> listAccount = new ArrayList<>();

    public static AccountController instance;
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static boolean isInitiallized = false;

    public static void init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new AccountController();
        isInitiallized = true;
    }
   
    private final String loadDataAccount_SQL = "select * from Accounts";
    private final String insertAccountWithAvatarSql  = "INSERT INTO Accounts (UserName, UserPassword, UserGmail,UserAvatar) VALUES (?,?,?,?)";
    private final String insertAccountSql  = "INSERT INTO Accounts (UserName, UserPassword, UserGmail) VALUES (?,?,?)";
    private final String deleteAccountByIdSql  = "Delete From Accounts where UserId =?" ; 
    private final String updateAccountByNameSql  = "UPDATE Accounts SET UserName = ? , UserPassword = ?  , UserGmail = ? WHERE UserName = ?";
    private final String updateAccountByIdSql  = "UPDATE Accounts SET UserName = ? , UserPassword = ?  , UserGmail = ? WHERE UserId = ?";
    private final String updateAvatarByUsernameSql  = "UPDATE Accounts SET UserAvatar = ? WHERE UserName = ?" ; 

    private void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhoneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadDataAccounts() {
        listAccount.clear();
        try {
            setupDatabaseCommand(loadDataAccount_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("UserId");
                String name = rs.getString("UserName");
                String pass = rs.getString("UserPassword");
                String gmail = rs.getString("UserGmail");
                byte[] avatar = rs.getBytes("UserAvatar");
                Account _account = new Account(id, name, pass, gmail, avatar);
                this.listAccount.add(_account);
            }
            // Mỗi ResultSet/PreparedStatement chiếm bộ nhớ
            //Không đóng sẽ khiến bộ nhớ không được thu hồi           
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadTableAccount(JTable table) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        loadDataAccounts();
        int n = 0;
        for (Account account : listAccount) {
            model.addRow(new Object[]{n++, account.getUserId(), account.getUserName(),
                account.getUserPassword(), account.getUserGmail(), account.getAvatarUser()});
        }
    }

    public boolean checkLogin(String name, String pass) {
        try {

            if (name.isEmpty() || pass.isEmpty()) {
                return false;// JOptionPane.showMessageDialog(null, "INFORMATION CAN NOT BE EMPTY", "ERROR", JOptionPane.CANCEL_OPTION);

            } else {
                for (Account account : this.listAccount) {
                    if (account.getUserName().equalsIgnoreCase(name) && (String.valueOf(account.getUserPassword()).equalsIgnoreCase(pass))) {
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addAccount(String name, String pass, String gmail, byte[] image) {
        try {
            if (image != null) {
                setupDatabaseCommand(insertAccountWithAvatarSql );
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, gmail);
                ps.setBytes(4, image);
            } else {
                setupDatabaseCommand(insertAccountSql );
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, gmail);
            }
            int n = ps.executeUpdate();
            if (n != 0) {
                Account _account;
                if (image != null) {
                    _account = new Account(name, pass, gmail, image);
                } else {
                    _account = new Account(name, pass, gmail);
                }
                this.listAccount.add(_account);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error: NAME IS EXIST!");
        }

        return false;
    }

    public boolean deleteAccount(int id) {

        try {
            setupDatabaseCommand(deleteAccountByIdSql );
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : this.listAccount) {
                    if (account.getUserId() == id) {
                        this.listAccount.remove(account);
                        return true;

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //update cho panel profile 
    public Account updateAccount(String name, String pass, String gmail, String Username) {

        try {
            setupDatabaseCommand(updateAccountByNameSql );
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setString(4, Username);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : listAccount) {
                    if (account.getUserName().equalsIgnoreCase(Username)) {
                        account.setUserName(name);
                        account.setUserPassword(pass);
                        account.setUserGmail(gmail);
                        return account;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateAccountManager(String name, String pass, String gmail, int id) {

        try {
            setupDatabaseCommand(updateAccountByIdSql );
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setInt(4, id);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Account account : listAccount) {
                    if (account.getUserId() == id) {
                        account.setUserName(name);
                        account.setUserPassword(pass);
                        account.setUserGmail(gmail);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkAccount(String name, String password, String gmail) {

        if (password.length() < 7 || name.length() < 4) {
            JOptionPane.showMessageDialog(null, "error: LENGTH PASSWORD >= 7 AND NAME >=4");
            return false;
        }

        if (EffectComponents.instance.containsVietnameseCharacters(name)) {
            JOptionPane.showMessageDialog(null, "error: NAME WRONG!");
            return false;
        }
        if (name.isEmpty() || password.isEmpty() || gmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "error: INFORMATION CAN NOT EMPTY");
            return false;
        }

        if (!gmail.contains("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "error: GMAIL WRONG");
            return false;
        }
        if (name.equalsIgnoreCase("admin")) {
            JOptionPane.showMessageDialog(null, "error: NAME IS FOR ADMINISTRATOR USE ONLY!!");
            return false;
        }
        return true;
    }

    public boolean checkAccount1(String name, String password, String gmail, int status) {

        if (password.length() < 7 || name.length() < 4) {
            JOptionPane.showMessageDialog(null, "error: LENGTH PASSWORD >= 7 AND NAME >=4");
            return false;
        }

        if (EffectComponents.instance.containsVietnameseCharacters(name)) {
            JOptionPane.showMessageDialog(null, "error: NAME WRONG!");
            return false;
        }
        if (name.isEmpty() || password.isEmpty() || gmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "error: INFORMATION CAN NOT EMPTY");
            return false;
        }

        if (!gmail.contains("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "error: GMAIL WRONG");
            return false;
        }
        if (name.equalsIgnoreCase("admin")) {
            if (status == 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "error: NAME IS FOR ADMINISTRATOR USE ONLY!!");
                return false;

            }
        }
        return true;
    }

    public void saveAvatarToDatabase(File selectedFile, String nameUser) {
        
        try (FileInputStream fis = new FileInputStream(selectedFile)) {
            setupDatabaseCommand(updateAvatarByUsernameSql );
            ps.setBinaryStream(1, fis, (int) selectedFile.length());
            ps.setString(2, nameUser);
            int n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Account getAccountByUsername(String username) {
        for (Account account : listAccount) {
            if (account.getUserName().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getDataAccount() {
        return listAccount;
    }
}
