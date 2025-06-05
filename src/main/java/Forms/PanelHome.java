package Forms;

import Controllers.PhoneController;
import DatabaseConnection.SQLConnector;
import Forms.Components.RoundedBorder;
import Model.Staff;
import Model.Phone;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelHome extends javax.swing.JPanel {

    private int quantityAvailableBill;

    private Staff currentAccount;
    private PanelManagerBill panelManagerBill;
    private DefaultTableModel model;

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private double totalAmount = 0;

    public PanelHome(Staff account, PanelManagerBill panelManagerBill) {
        initComponents();
        this.currentAccount = account;
        this.panelManagerBill = panelManagerBill;
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
        PhoneController.init();
        addPanelProducts();
        model = (DefaultTableModel) tbPhone.getModel();
        model.setNumRows(0);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tbPhone.getColumnCount(); i++) {
            tbPhone.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
        txtSearch.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/SearchIcon.png")));

        txtName.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
        txtAdress.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
        txtNumberPhone.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
        txtEmail.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
        btnCofirmBill.setForeground(new Color(0, 0, 0));
    }

    public void addPanelProducts() {

        this.PanelContainProduct.setLayout(new GridBagLayout());
        this.PanelContainProduct.removeAll();
        PhoneController.instance.loadDataProducts();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 40, 20, 40); // Khoảng cách giữa các item
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 1; // Giãn ngang

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        // this.PanelContainProduct.add(txtSearch, gbc);
//        this.PanelContainProduct.add(btnSearch, gbc);

        gbc.gridwidth = 1;
        int cols = 2; // Số cột
        for (int i = 0; i < PhoneController.instance.getDataProduct().size(); i++) {
            Phone phone = PhoneController.instance.getDataProduct().get(i);
            var newJpanel = new PanelPhone(phone, this, currentAccount, panelManagerBill);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
            this.PanelContainProduct.add(newJpanel, gbc);
        }
        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }

    public void searchByName(String name) {

        this.PanelContainProduct.setLayout(new GridBagLayout());
        this.PanelContainProduct.removeAll();
        PhoneController.instance.searchByName(name);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 50, 30, 50); // Khoảng cách giữa các item
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 1; // Giãn ngang

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        // this.PanelContainProduct.add(txtSearch, gbc);
//        this.PanelContainProduct.add(btnSearch, gbc);

        gbc.gridwidth = 1;
        int cols = 3; // Số cột
        for (int i = 0; i < PhoneController.instance.getDataProduct().size(); i++) {
            Phone phone = PhoneController.instance.getDataProduct().get(i);
            var newJpanel = new PanelPhone(phone, this, currentAccount, panelManagerBill);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
            this.PanelContainProduct.add(newJpanel, gbc);
        }
        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }

    private void removePlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
    }

    private void addPlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
    }

    public void getTextPhone(JTextField txtName, JTextField txtBrand, JTextField txtOS, JTextField txtDescription,
            JTextField txtQuantity, JTextField txtPrice) {
        String name = txtName.getText();
        String brand = txtBrand.getText();
        String os = txtOS.getText();
        String description = txtDescription.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        double price = Double.parseDouble(txtPrice.getText());
        double total = quantity * price;

        totalAmount += total;
        // STT = số dòng hiện tại + 1
        int no = tbPhone.getRowCount() + 1;

        // Thêm dòng mới
        model.addRow(new Object[]{
            no, name, brand, os, quantity, price, description, total
        });
        txtTotal.setText("" + totalAmount);
    }

    private void viewClient() {
        txtName.setText("");
        txtEmail.setText("");
        txtNumberPhone.setText("");
        txtAdress.setText("");
    }

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

    private void confirmBill() {
        String name = txtName.getText();
        String phone = txtNumberPhone.getText();
        String address = txtAdress.getText();
        String email = txtEmail.getText();
        double _totalAmount = Double.parseDouble(txtTotal.getText());

        try {
            // Mở kết nối & bật transaction
            if (conn == null || conn.isClosed()) {
                SQLConnector.getForName();
                conn = SQLConnector.getConnection();
            }
            conn.setAutoCommit(false);

            // 1. Thêm khách hàng mới
            String insertClientSQL = "INSERT INTO Clients(nameClient, telClient, addressClient, gmailClient) VALUES(?,?,?,?)";
            setupDatabaseCommand(insertClientSQL, true);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.executeUpdate();

            ResultSet rsClient = ps.getGeneratedKeys();
            int idClient = 0;
            if (rsClient.next()) {
                idClient = rsClient.getInt(1);
            }
            rsClient.close();
            ps.close();

            // 2. Thêm đơn hàng (Orders)
            String insertOrderSQL = "INSERT INTO Orders(timeOfBookingOrder, statusOrder, totalOrder, addressOrder, idClient, idStaff) VALUES (?, ?, ?, ?, ?, ?)";
            setupDatabaseCommand(insertOrderSQL, true);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis())); // thời gian hiện tại
            ps.setString(2, "Đã xác nhận"); // bạn có thể thay bằng trạng thái động
            ps.setDouble(3, _totalAmount);
            ps.setString(4, address);
            ps.setInt(5, idClient);
            ps.setInt(6, currentAccount.getId()); // idStaff từ tài khoản đăng nhập
            ps.executeUpdate();

            ResultSet rsOrder = ps.getGeneratedKeys();
            int idOrder = 0;
            if (rsOrder.next()) {
                idOrder = rsOrder.getInt(1);
            }
            rsOrder.close();
            ps.close();

            // 3. Thêm các chi tiết đơn hàng (OrderDetails)
            for (int i = 0; i < tbPhone.getRowCount(); i++) {
                String productName = tbPhone.getValueAt(i, 1).toString();
                int quantity = Integer.parseInt(tbPhone.getValueAt(i, 4).toString());

                // Lấy idPhone theo tên
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

                // Thêm vào OrderDetails
                String insertDetail = "INSERT INTO OrderDetails(idOrder, idPhone, quantity) VALUES (?, ?, ?)";
                setupDatabaseCommand(insertDetail);
                ps.setInt(1, idOrder);
                ps.setInt(2, idPhone);
                ps.setInt(3, quantity);
                ps.executeUpdate();
                ps.close();

                // Trừ số lượng sản phẩm trong bảng Phones
                String updatePhone = "UPDATE Phones SET quantityPhone = quantityPhone - ? WHERE idPhone = ?";
                setupDatabaseCommand(updatePhone);
                ps.setInt(1, quantity);
                ps.setInt(2, idPhone);
                ps.executeUpdate();
                ps.close();
            }

            // Hoàn tất giao dịch
            conn.commit();
            JOptionPane.showMessageDialog(null, "Đơn hàng đã được xác nhận thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi xác nhận đơn hàng!");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHomePage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainProduct = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new Forms.Components.TextFieldController();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhone = new javax.swing.JTable();
        txtName = new Forms.Components.TextFieldController();
        txtAdress = new Forms.Components.TextFieldController();
        txtNumberPhone = new Forms.Components.TextFieldController();
        txtEmail = new Forms.Components.TextFieldController();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCofirmBill = new Forms.Components.HeaderButton();

        PanelHomePage.setPreferredSize(new java.awt.Dimension(1100, 720));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout PanelContainProductLayout = new javax.swing.GroupLayout(PanelContainProduct);
        PanelContainProduct.setLayout(PanelContainProductLayout);
        PanelContainProductLayout.setHorizontalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1669, Short.MAX_VALUE)
        );
        PanelContainProductLayout.setVerticalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1115, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(PanelContainProduct);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setText("Search");
        txtSearch.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtSearch.setMaximumSize(new java.awt.Dimension(400, 60));
        txtSearch.setMinimumSize(new java.awt.Dimension(100, 35));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 350, 45));

        tbPhone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Name", "Brand", "OS", "Quantity", "Price", "Description", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbPhone);
        if (tbPhone.getColumnModel().getColumnCount() > 0) {
            tbPhone.getColumnModel().getColumn(0).setResizable(false);
            tbPhone.getColumnModel().getColumn(1).setResizable(false);
            tbPhone.getColumnModel().getColumn(2).setResizable(false);
            tbPhone.getColumnModel().getColumn(3).setResizable(false);
            tbPhone.getColumnModel().getColumn(4).setResizable(false);
            tbPhone.getColumnModel().getColumn(5).setResizable(false);
            tbPhone.getColumnModel().getColumn(6).setResizable(false);
            tbPhone.getColumnModel().getColumn(7).setResizable(false);
        }

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtAdress.setForeground(new java.awt.Color(255, 255, 255));
        txtAdress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtNumberPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtNumberPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numer Phone");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Amount:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Enter Buyer Information");

        btnCofirmBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ConfirmBill.png"))); // NOI18N
        btnCofirmBill.setText("Confirm Bill");
        btnCofirmBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCofirmBillMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelHomePageLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelHomePageLayout.createSequentialGroup()
                                .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelHomePageLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHomePageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHomePageLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHomePageLayout.createSequentialGroup()
                                .addComponent(btnCofirmBill, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162))))))
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHomePageLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(24, 24, 24)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelHomePageLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6))
                            .addGroup(PanelHomePageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCofirmBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Search")) {
            txtSearch.setText(null);
            txtSearch.requestFocus();
            removePlaceHolderStyle(txtSearch);
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, new Color(204, 255, 255)));
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().length() == 0) {
            addPlaceHolderStyle(txtSearch);
            txtSearch.setText("Search");
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        String name = txtSearch.getText().trim();

        searchByName(name);

    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCofirmBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCofirmBillMouseClicked
        confirmBill();
        addPanelProducts();
        viewClient();
        model.setNumRows(0);
    }//GEN-LAST:event_btnCofirmBillMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelHomePage;
    private Forms.Components.HeaderButton btnCofirmBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbPhone;
    private Forms.Components.TextFieldController txtAdress;
    private Forms.Components.TextFieldController txtEmail;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtNumberPhone;
    private Forms.Components.TextFieldController txtSearch;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
