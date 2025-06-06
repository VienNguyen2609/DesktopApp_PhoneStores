package Controllers;

import Model.Staff;
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

    private ArrayList<Staff> listStaff = new ArrayList<>();

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

    private final String loadDataAccount_SQL = "select * from Staffs";
    private final String insertAccountWithAvatarSql = "INSERT INTO Staffs (nameStaff, passwordStaff , emailStaff , positionStaff ,avatarStaff) VALUES (?,?,?,?,?)";
    private final String insertAccountSql = "INSERT INTO Staffs (nameStaff, passwordStaff, emailStaff ) VALUES (?,?,?)";
    private final String deleteAccountByIdSql = "Delete From Staffs where idStaff =?";
    private final String updateAccountByNameSql = "UPDATE Staffs SET nameStaff = ? , passwordStaff = ?  , emailStaff = ? WHERE nameStaff = ?";
    private final String updateAccountByIdSql = "UPDATE Staffs SET nameStaff = ? , passwordStaff = ?  , emailStaff = ? , positionStaff =?  WHERE idStaff = ?";
    private final String updateAvatarByUsernameSql = "UPDATE Staffs SET avatarStaff = ? WHERE nameStaff = ?";

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
        listStaff.clear();
        try {
            setupDatabaseCommand(loadDataAccount_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idStaff");
                String name = rs.getString("nameStaff");
                String pass = rs.getString("passwordStaff");
                String gmail = rs.getString("emailStaff");
                String position = rs.getString("positionStaff");
                byte[] avatar = rs.getBytes("avatarStaff");
                Staff _staff = new Staff(id, name, pass, gmail, position, avatar);
                this.listStaff.add(_staff);
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
        for (Staff staff : listStaff) {
            model.addRow(new Object[]{n++, staff.getId(), staff.getName(),
                staff.getPassword(), staff.getEmail(), staff.getPosition(), staff.getAvatar()});
        }
    }

    public boolean checkLogin(String name, String pass) {
        try {

            if (name.isEmpty() || pass.isEmpty()) {
                return false;// JOptionPane.showMessageDialog(null, "INFORMATION CAN NOT BE EMPTY", "ERROR", JOptionPane.CANCEL_OPTION);

            } else {
                for (Staff staff : this.listStaff) {
                    if (staff.getName().equalsIgnoreCase(name) && (String.valueOf(staff.getPassword()).equalsIgnoreCase(pass))) {
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addAccount(String name, String pass, String gmail, String position , byte[] image) {
        try {
            if (image != null) {
                setupDatabaseCommand(insertAccountWithAvatarSql);
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, gmail);
                ps.setString(4, position);
                ps.setBytes(5, image);
            } else {
                setupDatabaseCommand(insertAccountSql);
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, gmail);
            }
            int n = ps.executeUpdate();
            if (n != 0) {
                Staff staff;
                if (image != null) {
                    staff = new Staff(name, pass, gmail, image);
                } else {
                    staff = new Staff(name, pass, gmail);
                }
                this.listStaff.add(staff);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error: NAME IS EXIST!");
        }

        return false;
    }

    public boolean deleteAccount(int id) {

        try {
            setupDatabaseCommand(deleteAccountByIdSql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Staff staff : this.listStaff) {
                    if (staff.getId() == id) {
                        this.listStaff.remove(staff);
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
    public Staff updateAccount(String name, String pass, String gmail, String Username) {

        try {
            setupDatabaseCommand(updateAccountByNameSql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setString(4, Username);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Staff staff : listStaff) {
                    if (staff.getName().equalsIgnoreCase(Username)) {
                        staff.setName(name);
                        staff.setPassword(pass);
                        staff.setEmail(gmail);
                        return staff;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateAccountManager(String name, String pass, String gmail, String position, int id) {

        try {
            setupDatabaseCommand(updateAccountByIdSql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setString(4, position);
            ps.setInt(5, id);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Staff staff : listStaff) {
                    if (staff.getId() == id) {
                        staff.setName(name);
                        staff.setPassword(pass);
                        staff.setEmail(gmail);
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

    public boolean checkAccountIsAdmin(String name, String password, String gmail, int status) {

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
            if (status == 1) {
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
            setupDatabaseCommand(updateAvatarByUsernameSql);
            ps.setBinaryStream(1, fis, (int) selectedFile.length());
            ps.setString(2, nameUser);
            int n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Staff getAccountByUsername(String username) {
        for (Staff staff : listStaff) {
            if (staff.getName().equalsIgnoreCase(username)) {
                return staff;
            }
        }
        return null;
    }

    public ArrayList<Staff> getDataAccount() {
        return listStaff;
    }
}
