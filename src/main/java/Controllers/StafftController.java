package Controllers;

/**
 *
 * @author VIEN
 */

import Model.Staff;
import DatabaseConnection.SQLConnector;
import Forms.Components.EffectComponents;
import Forms.Components.ViewTabel;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StafftController {
    
    private ArrayList<Staff> listStaff = new ArrayList<>();
    
    private ViewTabel viewTabel = new ViewTabel();
    
    public static StafftController instance;
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private static boolean isInitiallized = false;
    
    public static void init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new StafftController();
        isInitiallized = true;
    }
    
    private final String loadDataStaff_SQL = "select * from Staffs";
    
    private final String insertStaffWithAvatarSQL = "INSERT INTO Staffs (nameStaff, passwordStaff "
            + ", emailStaff , positionStaff ,avatarStaff) VALUES (?,?,?,?,?)";
    
    private final String insertStaffSQL = "INSERT INTO Staffs (nameStaff, passwordStaff, positionStaff , "
            + " emailStaff ) VALUES (?,?,?,?)";
    
    private final String deleteStaffByIdSQL = "Delete From Staffs where idStaff =?";
    
    private final String updateStaffByNameSQL = "UPDATE Staffs SET nameStaff = ? , passwordStaff = ?  ,"
            + " emailStaff = ?   WHERE nameStaff = ?";
    
    private final String updateStaffByIdSQL = "UPDATE Staffs SET nameStaff = ? , passwordStaff = ?  , "
            + "emailStaff = ? , positionStaff =? , statusStaff =?   WHERE idStaff = ?";
    
    private final String updateAvatarByUsernameSQL = "UPDATE Staffs SET avatarStaff = ? WHERE nameStaff = ?";
    
    private void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadDataStaffs() {
        listStaff.clear();
        try {
            setupDatabaseCommand(loadDataStaff_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idStaff");
                String name = rs.getString("nameStaff");
                String pass = rs.getString("passwordStaff");
                String gmail = rs.getString("emailStaff");
                String position = rs.getString("positionStaff");
                boolean status = rs.getBoolean("statusStaff");
                byte[] avatar = rs.getBytes("avatarStaff");
                Staff _staff = new Staff(id, name, pass, gmail, position, status, avatar);
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
    
    public void loadTableStaff(JTable table) {
        
        viewTabel.view(table);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        loadDataStaffs();
        int n = 0;
        String status = "";
        for (Staff staff : listStaff) {
            if (staff.isStatus() == false) {
                status = "Inactive";
                model.addRow(new Object[]{n++, staff.getId(), staff.getName(),
                    staff.getPassword(), staff.getEmail(), staff.getPosition(), status, staff.getAvatar()});
            } else {
                status = "Active";
                model.addRow(new Object[]{n++, staff.getId(), staff.getName(),
                    staff.getPassword(), staff.getEmail(), staff.getPosition(), status, staff.getAvatar()});
            }
        }
    }
    
    public boolean checkLogin(String name, String pass) {
        try {
            
            if (name.isEmpty() || pass.isEmpty()) {
                return false;// JOptionPane.showMessageDialog(null, "INFORMATION CAN NOT BE EMPTY", "ERROR", JOptionPane.CANCEL_OPTION);

            } else {
                for (Staff staff : this.listStaff) {
                    if (staff.getName().equalsIgnoreCase(name) && (String.valueOf(staff.getPassword()).equalsIgnoreCase(pass))) {
                        if (staff.isStatus() == false) {
                            JOptionPane.showMessageDialog(null, "This account is currently inactive!");
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LOGIN FAILURE");
        }
        return false;
    }
    
    public boolean addStaff(String name, String pass, String gmail, String position, byte[] image) {
        try {
            if (image != null) {
                setupDatabaseCommand(insertStaffWithAvatarSQL);
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, gmail);
                ps.setString(4, position);
                ps.setBytes(5, image);
            } else {
                setupDatabaseCommand(insertStaffSQL);
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, position);
                ps.setString(4, gmail);
                
            }
            int n = ps.executeUpdate();
            if (n != 0) {
                Staff staff;
                if (image != null) {
                    staff = new Staff(name, pass, gmail, "No position", image);
                } else {
                    staff = new Staff(name, pass, gmail, "No position");
                }
                this.listStaff.add(staff);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error: NAME IS EXIST!");
        }
        
        return false;
    }
    
    public boolean deleteStaff(int id) {
        
        try {
            setupDatabaseCommand(deleteStaffByIdSQL);
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

    //update cho panel profile trả kiểu staff
    public Staff updateStaff(String name, String pass, String gmail, String nameStaff) {
        
        try {
            setupDatabaseCommand(updateStaffByNameSQL);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setString(4, nameStaff);
            int n = ps.executeUpdate();
            if (n > 0) {
                for (Staff staff : listStaff) {
                    if (staff.getName().equalsIgnoreCase(nameStaff)) {
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
    
    public boolean updateStaffManager(String name, String pass, String gmail, String position, boolean status, int id) {
        
        try {
            setupDatabaseCommand(updateStaffByIdSQL);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, gmail);
            ps.setString(4, position);
            ps.setBoolean(5, status);
            ps.setInt(6, id);
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
            JOptionPane.showMessageDialog(null, "CAN NOT UPDATE THIS NAME IS AVAILBLE");
        }
        return false;
    }
    
    public boolean checkStaffLogin(String name, String password, String gmail) {
        
        if (password.length() < 5 || name.length() < 4 ) {
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
        
        return true;
    }
    
    public boolean checkLoginIsAdmin(String name, String password, String gmail, int status) {
        
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
        if (name.contains("admin")) {
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
            setupDatabaseCommand(updateAvatarByUsernameSQL);
            ps.setBinaryStream(1, fis, (int) selectedFile.length());
            ps.setString(2, nameUser);
            int n = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SAVE AVATAR FAILURE!");
        }
        
    }
    
    public Staff getStaffByUsername(String username) {
        for (Staff staff : listStaff) {
            if (staff.getName().equalsIgnoreCase(username)) {
                return staff;
            }
        }
        return null;
    }
    
    public ArrayList<Staff> getDataStaff() {
        return listStaff;
    }
}
