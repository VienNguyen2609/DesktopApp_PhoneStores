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
            setupDatabaseCommand("SELECT * FROM Phones");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPhone");
                String name = rs.getString("namePhone");
                String brand = rs.getString("brandPhone");
                double price = rs.getDouble("pricePhone");
                int quantity = rs.getInt("quantity");
                String operating = rs.getString("operatingSystem");
                byte[] image = rs.getBytes("imagePhone");
                String descriptionPhone = rs.getString("descriptionPhone");
                Phone _phone = new Phone(id, name, brand, price, quantity, operating, image, descriptionPhone);
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
        for (Phone phone : listPhones) {
            model.addRow(new Object[]{n++, phone.getPhoneId(), phone.getNamePhone(), phone.getBrandPhone(),
                phone.getPricePhone(), phone.getQuantityPhone(), phone.getOperatingSystem(), phone.getImagePhone(), phone.getDescription()});
        }
    }

    public boolean addProduct(String name, String brand, double price, int quantity, String operatingSystem, byte[] image, String descriptionPhone) {
        if (image == null) {
            JOptionPane.showMessageDialog(null, "PRODUCT IMAGE MUST NOT BE EMPTY!");
            return false;
        }
        boolean check = false;
        try {
            setupDatabaseCommand("INSERT INTO Phones (namePhone, brandPhone, pricePhone, quantity , operatingSystem ,imagePhone,descriptionPhone ) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, operatingSystem);
            ps.setBytes(6, image);
            ps.setString(7, descriptionPhone);
            int n = ps.executeUpdate();

            if (n > 0) {
                Phone _phone = new Phone( name, brand, price, quantity, operatingSystem , image, descriptionPhone);
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

//    public boolean updateProduct(String name, int size, int quantity, float price, String color, byte[] image, int idProduct) {
//        boolean check = false;
//
//        try {
//            setupDatabaseCommand("UPDATE Products SET ProductName =? , ProductSize =? , ProductPrice = ?, ProductQuantity = ?, ProductColor = ? , ProductImage =? WHERE ProductId  = ?");
//            ps.setString(1, name);
//            ps.setInt(2, size);
//            ps.setFloat(3, price);
//            ps.setInt(4, quantity);
//            ps.setString(5, color);
//            ps.setBytes(6, image);
//            ps.setInt(7, idProduct);
//            int rowsAffected = ps.executeUpdate();
//            if (rowsAffected > 0) {
//                for (Shoes shoes : listPhones) {
//                    if (shoes.getProductId() == idProduct) {
//                        shoes.setProductName(name);
//                        shoes.setProductSize(size);
//                        shoes.setProductQuantity(quantity);
//                        shoes.setProductPrice(price);
//                        shoes.setProductColor(color);
//                        shoes.setProductAvatar(image);
//                        check = true;
//                        break;
//                    }
//                }
//            }
//            conn.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return check;
//    }

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
//    public boolean deleteProduct(String ProductName) {
//        boolean check = false;
//        try {
//            setupDatabaseCommand("delete from Products where ProductName = ?");
//            ps.setString(1, ProductName);
//            int rowsAffected = ps.executeUpdate();
//            if (rowsAffected > 0) {
//                for (Shoes shoes : listPhones) {
//                    if (shoes.getProductName().equalsIgnoreCase(ProductName)) {
//                        listPhones.remove(shoes);
//                        check = true;
//                        break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return check;
//    }
//
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

}
