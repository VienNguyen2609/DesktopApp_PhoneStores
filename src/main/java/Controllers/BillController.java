package Controllers;

/**
 *
 * @author VIEN
 */
import DatabaseConnection.SQLConnector;
import Model.Bill;
import Model.BillDisplay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BillController {

    private ArrayList<Bill> listBill = new ArrayList<>();

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    public DefaultTableModel model;

    private static boolean isInitiallized = false;
    public static BillController instance;

    public static void init() {
        if (isInitiallized == true) {
            return;
        } else {
            instance = new BillController();
            isInitiallized = true;
        }
    }

    private void setupDatabaseCommand(String sql) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            ps = conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void loadBills(JTable table, String name) {
//        listBill.clear();
//        model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0);
//
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        for (int i = 0; i < table.getColumnCount(); i++) {
//            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//        }
//        try {
//            if (name.equalsIgnoreCase("admin")) {
//                setupDatabaseCommand("SELECT b.BillId, u.UserName, p.ProductName, p.ProductSize, b.Quantity, b.Price, b.TotalAmount, b.BillDate "
//                        + "FROM Bill b "
//                        + "JOIN UserAccount u ON b.UserId = u.UserId "
//                        + "JOIN Products p ON b.ProductId = p.ProductId ");
//            } else {
//                setupDatabaseCommand("SELECT b.BillId, u.UserName, p.ProductName, p.ProductSize, b.Quantity, b.Price, b.TotalAmount, b.BillDate "
//                        + "FROM Bill b "
//                        + "JOIN UserAccount u ON b.UserId = u.UserId "
//                        + "JOIN Products p ON b.ProductId = p.ProductId "
//                        + "WHERE u.UserName = ?");
//                ps.setString(1, name);
//            }
//            rs = ps.executeQuery();
//            int n = 0;
//            while (rs.next()) {
//                model.addRow(new Object[]{n++,
//                    rs.getInt("BillId"),
//                    rs.getString("UserName"),
//                    rs.getString("ProductName"),
//                    rs.getInt("ProductSize"),
//                    rs.getInt("Quantity"),
//                    rs.getFloat("Price"),
//                    rs.getFloat("TotalAmount"),
//                    rs.getDate("BillDate")
//                });
//            }
//
//            rs.close();
//            ps.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public boolean addBill(int userId, int idPhone, Date billDate, int quantity, double price) {

        try {
            setupDatabaseCommand("INSERT INTO Bills ( UserId, idPhone  , BillDate ,Quantity ,Price) VALUES (?,?,?,?,?)");
            ps.setInt(1, userId);
            ps.setInt(2, idPhone);
            ps.setDate(3, new java.sql.Date(billDate.getTime()));
            ps.setInt(4, quantity);
            ps.setDouble(5, price);
            int n = ps.executeUpdate();
            ps.close();

            if (n > 0) {

                // Nếu thêm thành công, cập nhật số lượng sản phẩm
                setupDatabaseCommand("UPDATE Phones SET Quantity = Quantity - ? WHERE idPhone = ?");
                ps.setInt(1, quantity);
                ps.setInt(2, idPhone);
                int m = ps.executeUpdate(); // Thực thi UPDATE
                ps.close();

                if (m > 0) {

                    // Nếu UPDATE thành công, thêm vào listBill
                    Bill bill = new Bill(userId, idPhone, quantity, price, billDate);
                    listBill.add(bill);
                    return true;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteBill(int billId, String namePhone, int quantity ) {
        try {
            setupDatabaseCommand("UPDATE Phones SET Quantity = Quantity + ? WHERE namePhone = ?");
            ps.setInt(1, quantity);
            ps.setString(2, namePhone);
            ps.executeUpdate();
            ps.close();

            setupDatabaseCommand("DELETE FROM Bills WHERE BillId = ?");
            ps.setInt(1, billId);
            int n = ps.executeUpdate();
            ps.close();

            if (n > 0) {
                listBill.removeIf(b -> b.getBillId() == billId);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAllBills() {
        try {
            // 1. Lấy tất cả hóa đơn để phục hồi số lượng về Phones
            setupDatabaseCommand("SELECT idPhone, Quantity FROM Bills");
            ResultSet rs = ps.executeQuery();

            // Tạm lưu số lượng cần cộng lại vào Phones
            Map<Integer, Integer> phoneUpdateMap = new HashMap<>();
            while (rs.next()) {
                int idPhone = rs.getInt("idPhone");
                int quantity = rs.getInt("Quantity");
                phoneUpdateMap.put(idPhone, phoneUpdateMap.getOrDefault(idPhone, 0) + quantity);
            }
            rs.close();
            ps.close();

            // 2. Cập nhật số lượng hàng tồn kho cho từng idPhone
            for (Map.Entry<Integer, Integer> entry : phoneUpdateMap.entrySet()) {
                setupDatabaseCommand("UPDATE Phones SET Quantity = Quantity + ? WHERE idPhone = ?");
                ps.setInt(1, entry.getValue());
                ps.setInt(2, entry.getKey());
                ps.executeUpdate();
                ps.close();
            }

            // 3. Xóa toàn bộ bill
            setupDatabaseCommand("DELETE FROM Bills");
            int rows = ps.executeUpdate();
            ps.close();

            // 4. Xóa toàn bộ trong listBill
            listBill.clear();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAllBillsByUserName(String nameUser) {
        try {
            // 1. Tìm UserId theo tên người dùng
            setupDatabaseCommand("SELECT UserId FROM Accounts WHERE UserName = ?");
            ps.setString(1, nameUser);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Không tìm thấy user có tên: " + nameUser);
                return false;
            }

            int userId = rs.getInt("UserId");
            rs.close();
            ps.close();

            // 2. Lấy các bill của user này
            setupDatabaseCommand("SELECT idPhone, Quantity FROM Bills WHERE UserId = ?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            Map<Integer, Integer> phoneUpdateMap = new HashMap<>();
            while (rs.next()) {
                int idPhone = rs.getInt("idPhone");
                int quantity = rs.getInt("Quantity");
                phoneUpdateMap.put(idPhone, phoneUpdateMap.getOrDefault(idPhone, 0) + quantity);
            }
            rs.close();
            ps.close();

            // 3. Cập nhật lại tồn kho trong Phones
            for (Map.Entry<Integer, Integer> entry : phoneUpdateMap.entrySet()) {
                setupDatabaseCommand("UPDATE Phones SET Quantity = Quantity + ? WHERE idPhone = ?");
                ps.setInt(1, entry.getValue());
                ps.setInt(2, entry.getKey());
                ps.executeUpdate();
                ps.close();
            }

            // 4. Xóa bills của user
            setupDatabaseCommand("DELETE FROM Bills WHERE UserId = ?");
            ps.setInt(1, userId);
            int rows = ps.executeUpdate();
            ps.close();

            // 5. Xóa khỏi listBill
            listBill.removeIf(b -> b.getUserId() == userId);

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public boolean updateBill(int billId, int quantity, double price, Date date, boolean status) {
//    try {
//        setupDatabaseCommand("UPDATE Bills SET Quantity = ?, Price = ?, BillDate = ?, PaymentStatus = ? WHERE BillId = ?");
//        ps.setInt(1, quantity);
//        ps.setDouble(2, price);
//        ps.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
//        ps.setBoolean(4, status);
//        ps.setInt(5, billId);
//
//        int rows = ps.executeUpdate();
//        ps.close();
//        return rows > 0;
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return false;
//}
    public ArrayList<Bill> getDataBills() {
        return listBill;
    }

    public ArrayList<BillDisplay> getDisplayBills(String name) {
        ArrayList<BillDisplay> list = new ArrayList<>();

        try {
            String sql;
            if (name.equalsIgnoreCase("admin")) {
                sql = """
                SELECT b.BillId, u.UserName, p.namePhone, b.Quantity, b.Price, b.TotalAmount, b.BillDate , b.PaymentStatus
                FROM Bills b
                JOIN Accounts u ON b.UserId = u.UserId
                JOIN Phones p ON b.idPhone = p.idPhone
            """;
                setupDatabaseCommand(sql);
            } else {
                sql = """
                SELECT b.BillId, u.UserName, p.namePhone, b.Quantity, b.Price, b.TotalAmount, b.BillDate , b.PaymentStatus
                FROM Bills b
                JOIN Accounts u ON b.UserId = u.UserId
                JOIN Phones p ON b.idPhone = p.idPhone
                WHERE u.UserName = ?
            """;
                setupDatabaseCommand(sql);
                ps.setString(1, name);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                BillDisplay b = new BillDisplay(
                        rs.getInt("BillId"),
                        rs.getString("UserName"),
                        rs.getString("namePhone"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price"),
                        rs.getDouble("TotalAmount"),
                        rs.getDate("BillDate"),
                        rs.getBoolean("PaymentStatus")
                );
                list.add(b);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void showBillDisplayToTable(JTable table, ArrayList<BillDisplay> list) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        int n = 1;
        String status = "";
        for (BillDisplay b : list) {
            if (b.isPaymentStatus() == false) {
                status = "Unpaid";
                model.addRow(new Object[]{
                    n++,
                    b.getBillId(),
                    b.getUserName(),
                    b.getPhoneName(),
                    b.getQuantity(),
                    b.getPrice(),
                    b.getTotalAmount(),
                    b.getBillDate(),
                    status
                });
            } else {
                status = "Paid";
                model.addRow(new Object[]{
                    n++,
                    b.getBillId(),
                    b.getUserName(),
                    b.getPhoneName(),
                    b.getQuantity(),
                    b.getPrice(),
                    b.getTotalAmount(),
                    b.getBillDate(),
                    status
                });
            }

        }
    }

}
