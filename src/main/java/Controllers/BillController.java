package Controllers;

/**
 *
 * @author VIEN
 */
import DatabaseConnection.SQLConnector;
import Model.Order;
import Model.BillDisplay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BillController {

    private ArrayList<Order> listBill = new ArrayList<>();

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

    private final String insertOrderSQL = "INSERT INTO Orders (timeOfBookingOrder, "
            + "statusOrder, totalOrder, addressOrder, idClient, idStaff) VALUES (?, ?, ?, ?, ?, ?)";

//    private final String updateQuantitySQL = "UPDATE Phones SET quantityPhone = quantityPhone + ? WHERE idPhone = ?";
    //private final String updatePhoneByNameSQL = "UPDATE Phones SET quantityPhone = quantityPhone + ? WHERE namePhone = ?";
    private final String deleteBillByIdSQL = "DELETE FROM Orders WHERE idOrder = ?";

    private final String getPhoneQtySql = "SELECT idPhone, quantity FROM "
            + "OrderDetails WHERE idOrder = ?";

    private final String updateQuantityPhoneByIdSQL = "UPDATE Phones SET quantityPhone = quantityPhone + ? WHERE idPhone = ?";

    private final String deleteBillSQL = "DELETE FROM Orders";

    private final String getUserIdByUserNamSQL = "SELECT idClient FROM Clients WHERE nameClient = ?";
    private final String getIdQuantityBillByIdSQL = "SELECT idPhone FROM Orders WHERE idClient = ?";
    private final String updateQuantityPhoneById = "UPDATE Phones SET quantityPhone = quantityPhone + ? WHERE idPhone = ?";
    private final String deleteBillById = "DELETE FROM Orders WHERE idClient = ?";

    private void setupDatabaseCommand(String sql, boolean returnGeneratedKeys) throws SQLException {
        try {
            SQLConnector.getForName();
            conn = SQLConnector.getConnection();
            if (returnGeneratedKeys) {
                ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            } else {
                ps = conn.prepareStatement(sql);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setupDatabaseCommand(String sql) throws SQLException {
        setupDatabaseCommand(sql, false);
    }

    public boolean deleteBill(int billId) {
        try {
            // 1. Kiểm tra trạng thái hóa đơn
            String checkStatusSQL = "SELECT statusOrder FROM Orders WHERE idOrder = ?";
            setupDatabaseCommand(checkStatusSQL);
            ps.setInt(1, billId);
            ResultSet rs = ps.executeQuery();

            boolean needRestoreQuantity = false;
            if (rs.next()) {
                String status = rs.getString("statusOrder");
                // Nếu chưa thanh toán thì mới cần cộng lại tồn kho
                if (!status.equalsIgnoreCase("Confirmed")) {
                    needRestoreQuantity = true;
                }
            } else {
                rs.close();
                ps.close();
                return false; // Không tìm thấy bill
            }
            rs.close();
            ps.close();

            // 2. Nếu chưa thanh toán, phục hồi lại số lượng Phones
            if (needRestoreQuantity) {
                String selectDetails = "SELECT idPhone, quantity FROM OrderDetails WHERE idOrder = ?";
                setupDatabaseCommand(selectDetails);
                ps.setInt(1, billId);
                rs = ps.executeQuery();

                Map<Integer, Integer> phoneUpdateMap = new HashMap<>();
                while (rs.next()) {
                    int idPhone = rs.getInt("idPhone");
                    int quantity = rs.getInt("quantity");
                    phoneUpdateMap.put(idPhone, phoneUpdateMap.getOrDefault(idPhone, 0) + quantity);
                }
                rs.close();
                ps.close();

                for (Map.Entry<Integer, Integer> entry : phoneUpdateMap.entrySet()) {
                    String updatePhoneQty = "UPDATE Phones SET quantityPhone = quantityPhone + ? WHERE idPhone = ?";
                    setupDatabaseCommand(updatePhoneQty);
                    ps.setInt(1, entry.getValue());
                    ps.setInt(2, entry.getKey());
                    ps.executeUpdate();
                    ps.close();
                }
            }

            // 3. Xóa chi tiết đơn hàng
            String deleteDetails = "DELETE FROM OrderDetails WHERE idOrder = ?";
            setupDatabaseCommand(deleteDetails);
            ps.setInt(1, billId);
            ps.executeUpdate();
            ps.close();

            // 4. Xóa hóa đơn
            String deleteOrder = "DELETE FROM Orders WHERE idOrder = ?";
            setupDatabaseCommand(deleteOrder);
            ps.setInt(1, billId);
            int affectedRows = ps.executeUpdate();
            ps.close();

            listBill.removeIf(b -> b.getIdOrder() == billId);

            return affectedRows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAllBills() {
        try {
            // 1. Lấy tất cả đơn hàng chưa thanh toán
            String getOrdersSQL = "SELECT idOrder, statusOrder FROM Orders";
            setupDatabaseCommand(getOrdersSQL);
            ResultSet rs = ps.executeQuery();

            // Danh sách đơn hàng cần cộng lại tồn kho
            List<Integer> unpaidOrderIds = new ArrayList<>();
            while (rs.next()) {
                String status = rs.getString("statusOrder");
                if (status == null || status.equalsIgnoreCase("Chờ xác nhận") || status.equalsIgnoreCase("Chưa thanh toán")) {
                    unpaidOrderIds.add(rs.getInt("idOrder"));
                }
            }
            rs.close();
            ps.close();

            // 2. Với mỗi đơn hàng chưa thanh toán, cộng lại tồn kho
            Map<Integer, Integer> phoneUpdateMap = new HashMap<>();
            for (int idOrder : unpaidOrderIds) {
                String getDetailsSQL = "SELECT idPhone, quantity FROM OrderDetails WHERE idOrder = ?";
                setupDatabaseCommand(getDetailsSQL);
                ps.setInt(1, idOrder);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int idPhone = rs.getInt("idPhone");
                    int qty = rs.getInt("quantity");
                    phoneUpdateMap.put(idPhone, phoneUpdateMap.getOrDefault(idPhone, 0) + qty);
                }
                rs.close();
                ps.close();
            }

            // 3. Cập nhật tồn kho cho Phones
            for (Map.Entry<Integer, Integer> entry : phoneUpdateMap.entrySet()) {
                String updateQtySQL = "UPDATE Phones SET quantityPhone = quantityPhone + ? WHERE idPhone = ?";
                setupDatabaseCommand(updateQtySQL);
                ps.setInt(1, entry.getValue());
                ps.setInt(2, entry.getKey());
                ps.executeUpdate();
                ps.close();
            }

            // 4. Xóa toàn bộ OrderDetails
            String deleteDetailsSQL = "DELETE FROM OrderDetails";
            setupDatabaseCommand(deleteDetailsSQL);
            ps.executeUpdate();
            ps.close();

            // 5. Xóa toàn bộ Orders
            String deleteOrdersSQL = "DELETE FROM Orders";
            setupDatabaseCommand(deleteOrdersSQL);
            int rows = ps.executeUpdate();
            ps.close();

            // 6. Xóa trong listBill (nếu dùng)
            listBill.clear();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<BillDisplay> getDisplayBills() {
        ArrayList<BillDisplay> list = new ArrayList<>();

        try {
            String sql = """
            SELECT 
                o.idOrder,
                c.nameClient,
                p.namePhone,
                od.quantity,
                p.pricePhone,
                o.totalOrder,
                o.timeOfBookingOrder,
                o.statusOrder,
                s.nameStaff
            FROM Orders o
            JOIN Clients c ON o.idClient = c.idClient
            JOIN OrderDetails od ON o.idOrder = od.idOrder
            JOIN Phones p ON od.idPhone = p.idPhone
            JOIN Staffs s ON o.idStaff = s.idStaff
            ORDER BY o.timeOfBookingOrder DESC
        """;
            setupDatabaseCommand(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                BillDisplay b = new BillDisplay(
                        rs.getInt("idOrder"),
                        rs.getString("nameClient"),
                        rs.getString("namePhone"),
                        rs.getInt("quantity"),
                        rs.getDouble("pricePhone"),
                        rs.getDouble("totalOrder"),
                        rs.getTimestamp("timeOfBookingOrder"),
                        rs.getString("statusOrder"),
                        rs.getString("nameStaff")
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
            if (b.getPaymentStatus().equalsIgnoreCase("Confirmed")) {
                status = "Paid";
                model.addRow(new Object[]{
                    n++,
                    b.getBillId(),
                    b.getNameClient(),
                    b.getNamePhone(),
                    b.getQuantity(),
                    b.getPrice(),
                    b.getTotalAmount(),
                    b.getBillDate(),
                    b.getNameStaff(),
                    status
                });
            } else {
                status = "UnPaid";
                model.addRow(new Object[]{
                    n++,
                    b.getBillId(),
                    b.getNameClient(),
                    b.getNamePhone(),
                    b.getQuantity(),
                    b.getPrice(),
                    b.getTotalAmount(),
                    b.getBillDate(),
                    b.getNameStaff(),
                    status
                });
            }

        }
    }

    public void confirmBill(JTable tabel, String name, String phone, String address,
            String email, double total, int idStaff) {

        try {
            // Mở kết nối & bật transaction
            if (conn == null || conn.isClosed()) {
                SQLConnector.getForName();
                conn = SQLConnector.getConnection();
            }
            conn.setAutoCommit(false);

            int idClient = 0;

            // 1. Kiểm tra khách hàng đã tồn tại (theo số điện thoại)
            String selectClientSQL = "SELECT idClient FROM Clients WHERE telClient = ?";
            setupDatabaseCommand(selectClientSQL);
            ps.setString(1, phone);
            ResultSet rsClient = ps.executeQuery();

            if (rsClient.next()) {
                // Khách hàng đã tồn tại
                idClient = rsClient.getInt("idClient");
            } else {
                // Khách hàng chưa có → thêm mới
                rsClient.close();
                ps.close();

                String insertClientSQL = "INSERT INTO Clients(nameClient, telClient, addressClient, gmailClient) VALUES(?,?,?,?)";
                setupDatabaseCommand(insertClientSQL, true);
                ps.setString(1, name);
                ps.setString(2, phone);
                ps.setString(3, address);
                ps.setString(4, email);
                ps.executeUpdate();

                ResultSet rsNewClient = ps.getGeneratedKeys();
                if (rsNewClient.next()) {
                    idClient = rsNewClient.getInt(1);
                }
                rsNewClient.close();
            }
            ps.close();

            // 2. Thêm đơn hàng (Orders)
            String insertOrderSQL = "INSERT INTO Orders(timeOfBookingOrder, statusOrder, totalOrder, addressOrder, idClient, idStaff) VALUES (?, ?, ?, ?, ?, ?)";
            setupDatabaseCommand(insertOrderSQL, true);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis())); // thời gian hiện tại
            ps.setString(2, "Confirmed");
            ps.setDouble(3, total);
            ps.setString(4, address);
            ps.setInt(5, idClient);
            ps.setInt(6, idStaff);
            ps.executeUpdate();

            ResultSet rsOrder = ps.getGeneratedKeys();
            int idOrder = 0;
            if (rsOrder.next()) {
                idOrder = rsOrder.getInt(1);
            }
            rsOrder.close();
            ps.close();

            // 3. Thêm các chi tiết đơn hàng (OrderDetails)
            for (int i = 0; i < tabel.getRowCount(); i++) {
                String productName = tabel.getValueAt(i, 2).toString(); // cột tên sản phẩm
                int quantity = Integer.parseInt(tabel.getValueAt(i, 5).toString()); // cột số lượng

                // Lấy idPhone từ bảng Phones
                String queryPhone = "SELECT idPhone FROM Phones WHERE namePhone = ?";
                setupDatabaseCommand(queryPhone);
                ps.setString(1, productName);
                ResultSet rsPhone = ps.executeQuery();

                int idPhone = 0;
                if (rsPhone.next()) {
                    idPhone = rsPhone.getInt("idPhone");
                }
                rsPhone.close();
                ps.close();

                // Thêm vào bảng OrderDetails
                String insertDetail = "INSERT INTO OrderDetails(idOrder, idPhone, quantity) VALUES (?, ?, ?)";
                setupDatabaseCommand(insertDetail);
                ps.setInt(1, idOrder);
                ps.setInt(2, idPhone);
                ps.setInt(3, quantity);
                ps.executeUpdate();
                ps.close();

                // Trừ số lượng sản phẩm
                String updatePhone = "UPDATE Phones SET quantityPhone = quantityPhone - ? WHERE idPhone = ?";
                setupDatabaseCommand(updatePhone);
                ps.setInt(1, quantity);
                ps.setInt(2, idPhone);
                ps.executeUpdate();
                ps.close();
            }

            // Hoàn tất giao dịch
            conn.commit();
            JOptionPane.showMessageDialog(null, "Order has been confirmed successfully!");

        } catch (Exception e) {
            try {
                if (conn != null && !conn.getAutoCommit()) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while confirming the order!");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Order> getDataBills() {
        return listBill;
    }
}
