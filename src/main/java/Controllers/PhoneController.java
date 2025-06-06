package Controllers;

import DatabaseConnection.SQLConnector;
import Model.Phone;
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

public class PhoneController {

    private ArrayList<Phone> listPhones = new ArrayList<>();

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static PhoneController instance;
    private static boolean isInitiallized = false;

    public static void init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new PhoneController();
            isInitiallized = true;
        }
    }

    private final String selectPhoneSQL = "SELECT * FROM Phones";
    private final String selectPhoneSQLByName = "SELECT * FROM Phones WHERE namePhone LIKE ?";

    private final String insertPhoneSQL = "INSERT INTO Phones (namePhone, brandPhone, pricePhone"
            + ", quantityPhone , operatingSystemPhone ,imagePhone,descriptionPhone , statusPhone) VALUES (?,?,?,?,?,?,?,?)";

    private final String updatePhoneById = "UPDATE Phones SET namePhone =? , brandPhone =? , pricePhone = ?, "
            + "quantityPhone = ?, operatingSystemPhone = ? , imagePhone =? , descriptionPhone=?  , statusPhone = ?  WHERE idPhone  = ?";

    private final String deletePhoneById = "delete from Phones where idPhone = ?";

    private void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataProducts() {
        listPhones.clear();
        try {

            setupDatabaseCommand(selectPhoneSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPhone");
                String name = rs.getString("namePhone");
                String brand = rs.getString("brandPhone");
                double price = rs.getDouble("pricePhone");
                int quantity = rs.getInt("quantityPhone");
                String operating = rs.getString("operatingSystemPhone");
                byte[] image = rs.getBytes("imagePhone");
                String descriptionPhone = rs.getString("descriptionPhone");
                boolean status = rs.getBoolean("statusPhone");
                Phone _phone = new Phone(id, name, brand, price, quantity, operating, image, descriptionPhone, status);
                listPhones.add(_phone);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchByName(String name) {
        listPhones.clear();
        try {

            setupDatabaseCommand(selectPhoneSQLByName);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPhone");
                String _name = rs.getString("namePhone");
                String brand = rs.getString("brandPhone");
                double price = rs.getDouble("pricePhone");
                int quantity = rs.getInt("quantityPhone");
                String operating = rs.getString("operatingSystemPhone");
                byte[] image = rs.getBytes("imagePhone");
                String descriptionPhone = rs.getString("descriptionPhone");
                boolean status = rs.getBoolean("statusPhone");
                Phone _phone = new Phone(id, _name, brand, price, quantity, operating, image, descriptionPhone, status);
                listPhones.add(_phone);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadTableProduct(JTable table) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        loadDataProducts();
        int n = 0;
        String status = "";
        for (Phone phone : listPhones) {
            if (phone.isStatusPhone() == false) {
                status = "Unavailable";
                model.addRow(new Object[]{n++,
                    phone.getPhoneId(), phone.getNamePhone(), phone.getBrandPhone(),
                    phone.getPricePhone(), phone.getQuantityPhone(), phone.getOperatingSystem(),
                    phone.getImagePhone(), phone.getDescription(), status});
            } else {
                status = "Availabel";
                model.addRow(new Object[]{n++,
                    phone.getPhoneId(), phone.getNamePhone(), phone.getBrandPhone(),
                    phone.getPricePhone(), phone.getQuantityPhone(), phone.getOperatingSystem(),
                    phone.getImagePhone(), phone.getDescription(), status});
            }
        }
    }

    public boolean addProduct(String name, String brand, double price, int quantity, String operatingSystem, byte[] image, String descriptionPhone, boolean status) {
        if (image == null) {
            JOptionPane.showMessageDialog(null, "PRODUCT IMAGE CAN NOT BE EMPTY!");
            return false;
        }
        boolean check = false;
        try {

            setupDatabaseCommand(insertPhoneSQL);
            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, operatingSystem);
            ps.setBytes(6, image);
            ps.setString(7, descriptionPhone);
            ps.setBoolean(8, status);
            int n = ps.executeUpdate();

            if (n > 0) {
                Phone _phone = new Phone(name, brand, price, quantity, operatingSystem, image, descriptionPhone, status);
                listPhones.add(_phone);
                check = true;
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter correct format", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public boolean updateProduct(String name, String brand, double price, int quantity, String operatingSystem, byte[] image, String descriptionPhone, boolean status, int idProduct) {

        try {
            setupDatabaseCommand(updatePhoneById);
            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, operatingSystem);
            ps.setBytes(6, image);
            ps.setString(7, descriptionPhone);
            ps.setBoolean(8, status);
            ps.setInt(9, idProduct);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                for (Phone phone : listPhones) {
                    if (phone.getPhoneId() == idProduct) {
                        phone.setNamePhone(name);
                        phone.setBrandPhone(brand);
                        phone.setPricePhone(price);
                        phone.setQuantityPhone(quantity);
                        phone.setOperatingSystem(operatingSystem);
                        phone.setImagePhone(image);
                        phone.setDescription(descriptionPhone);
                        phone.setStatusPhone(status);
                        return true;
                    }
                }
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

//    public boolean Find(String name) {
//        boolean check = false;
//        try {
//            for (Shoes shoes : listShoes) {
//                if (shoes.getProductName().equalsIgnoreCase(name)) {
//                    check = true;
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return check;
//    }
//    public void findProduct(String name, JTable tbProduct) {
//        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
//        model.setNumRows(0);
//        int temp = 0;
//        try {
//            for (Shoes shoes : listShoes) {
//                if (shoes.getProductName().equalsIgnoreCase(name)) {
//                    temp++;
//                    int a = listShoes.indexOf(shoes);
//                    model.addRow(new Object[]{a++, shoes.getProductId(), shoes.getProductName(), shoes.getProductPrice(), shoes.getProductQuantity(), shoes.getProductColor(), shoes.getTotalProduct()});
//                }
//            }
//            if (temp == 0) {
//                JOptionPane.showMessageDialog(null, "NAME: " + name + "   \nFAILD!");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public boolean deleteProduct(int id) {
        boolean check = false;
        try {

            setupDatabaseCommand(deletePhoneById);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                for (Phone phone : listPhones) {
                    if (phone.getPhoneId() == id) {
                        listPhones.remove(phone);
                        check = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public ArrayList<Phone> getDataProduct() {
        return listPhones;
    }
//
//    public Shoes searchProductByName(String keyword) {
//        if (keyword == null || keyword.trim().isEmpty()) {
//            return null; // Không có từ khóa thì không tìm
//        }
//
//        String finalKeyword = keyword.toLowerCase();
//        return getDataProduct().stream()
//                .filter(shoes -> shoes.getProductName() != null
//                && shoes.getProductName().toLowerCase().equals(finalKeyword))
//                .findFirst()
//                .orElse(null); // Trả về null nếu không tìm thấy
//    }
    
//    public void In(){
//        for(Phone a : listPhones){
//            System.out.println(a.getNamePhone());
//        }
//    }
//    public static void main(String[] args) {
//        PhoneController.init();
//        PhoneController.instance.loadDataProducts();
//        PhoneController.instance.In();
//    }

}


