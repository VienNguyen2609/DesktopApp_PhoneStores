package Forms;

import Controllers.BillController;
import Controllers.PhoneController;
import Forms.Components.EffectComponents;
import Forms.Components.RoundedBorder;
import Model.Staff;
import Model.Phone;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIEN
 */
public class PanelHome extends javax.swing.JPanel {

    private int quantityAvailableBill;

    private Staff currentStaff;
    private PanelManagerBill panelManagerBill;
    private PanelManagerPhone panelManagerPhone;
    private PanelManagerClient panelManagerClient;
    private DefaultTableModel model;

    private double totalAmount = 0;

    public PanelHome(Staff staff, PanelManagerBill panelManagerBill,
            PanelManagerPhone panelManagerPhone, PanelManagerClient panelManagerClient) {
        initComponents();

        PhoneController.init();
        BillController.init();
        EffectComponents.init();

        this.currentStaff = staff;
        this.panelManagerBill = panelManagerBill;
        this.panelManagerPhone = panelManagerPhone;
        this.panelManagerClient = panelManagerClient;
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);

        addPanelPhone();
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
        btnDeleleBill.setForeground(new Color(0, 0, 0));
    }

    public void addPanelPhone() {

        this.PanelContainPhone.setLayout(new GridBagLayout());
        this.PanelContainPhone.removeAll();
        PhoneController.instance.loadDataPhones();

        GridBagConstraints gbc = new GridBagConstraints(); // để điều chỉnh vị trí cho các components muốn thêm 
        gbc.insets = new Insets(20, 40, 20, 40); // Khoảng cách giữa các item
        gbc.fill = GridBagConstraints.HORIZONTAL; // giãn ngang
        // gbc.weightx = 1; // Giãn ngang

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;

        gbc.gridwidth = 1;
        int cols = 2; // Số cột
        for (int i = 0; i < PhoneController.instance.getDataPhone().size(); i++) {
            Phone phone = PhoneController.instance.getDataPhone().get(i);
            var newJpanel = new PanelPhone(phone, this, currentStaff, panelManagerBill);
            gbc.gridx = i % cols;  // chia lấy dư 
            gbc.gridy = (i / cols) + 1; // +1 có thể để chừa dòng tiêu đề hoặc padding trên
            this.PanelContainPhone.add(newJpanel, gbc);
        }
        this.PanelContainPhone.revalidate();
        this.PanelContainPhone.repaint();
    }

    public void fetchPhonesByNameOrBrand(String name, String brand) {

        this.PanelContainPhone.setLayout(new GridBagLayout());
        this.PanelContainPhone.removeAll();
        PhoneController.instance.fetchPhonesByNameOrBrand(name, brand);

        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.insets = new Insets(20, 40, 20, 40);
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;

        gbc.gridwidth = 1;
        int cols = 2; 
        for (int i = 0; i < PhoneController.instance.getDataPhone().size(); i++) {
            Phone phone = PhoneController.instance.getDataPhone().get(i);
            var newJpanel = new PanelPhone(phone, this, currentStaff, panelManagerBill);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1; 
            this.PanelContainPhone.add(newJpanel, gbc);
        }
        this.PanelContainPhone.revalidate();
        this.PanelContainPhone.repaint();
    }

    public void setPanelManagerPhone(PanelManagerPhone panelManagerPhone) {
        this.panelManagerPhone = panelManagerPhone;
    }

    public void getTextPhone(JTextField txtID, JTextField txtName, JTextField txtBrand,
            JTextField txtOS, JTextField txtDescription,
            JTextField txtQuantity, JTextField txtPrice) {

        int id = Integer.parseInt(txtID.getText());
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

        for (int i = 0; i < tbPhone.getRowCount(); i++) {
            int existingId = Integer.parseInt(tbPhone.getValueAt(i, 1).toString()); // cột 1 là ID
            if (existingId == id) {
                JOptionPane.showMessageDialog(null, "The product already exists in the list. Please choose another product!");
                return;
            }
        }

        model.addRow(new Object[]{
            no, id, name, brand, os, quantity, price, description, total
        });
        txtTotal.setText("" + totalAmount);
        txtQuantity.setText("");
    }

    private void viewClient() {
        txtName.setText("");
        txtEmail.setText("");
        txtNumberPhone.setText("");
        txtAdress.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHomePage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainPhone = new javax.swing.JPanel();
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
        btnDeleleBill = new Forms.Components.HeaderButton();

        PanelHomePage.setPreferredSize(new java.awt.Dimension(1100, 720));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout PanelContainPhoneLayout = new javax.swing.GroupLayout(PanelContainPhone);
        PanelContainPhone.setLayout(PanelContainPhoneLayout);
        PanelContainPhoneLayout.setHorizontalGroup(
            PanelContainPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1669, Short.MAX_VALUE)
        );
        PanelContainPhoneLayout.setVerticalGroup(
            PanelContainPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1115, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(PanelContainPhone);

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

        tbPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbPhone.setForeground(new java.awt.Color(255, 255, 255));
        tbPhone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Id", "Name", "Brand", "OS", "Quantity", "Price", "Description", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPhone.getTableHeader().setResizingAllowed(false);
        tbPhone.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbPhone);
        if (tbPhone.getColumnModel().getColumnCount() > 0) {
            tbPhone.getColumnModel().getColumn(0).setMinWidth(40);
            tbPhone.getColumnModel().getColumn(0).setMaxWidth(40);
            tbPhone.getColumnModel().getColumn(1).setMinWidth(40);
            tbPhone.getColumnModel().getColumn(1).setMaxWidth(40);
            tbPhone.getColumnModel().getColumn(2).setResizable(false);
            tbPhone.getColumnModel().getColumn(3).setResizable(false);
            tbPhone.getColumnModel().getColumn(4).setResizable(false);
            tbPhone.getColumnModel().getColumn(5).setMinWidth(45);
            tbPhone.getColumnModel().getColumn(5).setMaxWidth(45);
            tbPhone.getColumnModel().getColumn(6).setResizable(false);
            tbPhone.getColumnModel().getColumn(7).setResizable(false);
            tbPhone.getColumnModel().getColumn(8).setResizable(false);
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
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ClientIcon.png"))); // NOI18N
        jLabel7.setText(" Enter Buyer Information");

        btnCofirmBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ConfirmBill.png"))); // NOI18N
        btnCofirmBill.setText("Confirm Bill");
        btnCofirmBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCofirmBillMouseClicked(evt);
            }
        });

        btnDeleleBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon.png"))); // NOI18N
        btnDeleleBill.setText("Delete Bill");
        btnDeleleBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleleBillMouseClicked(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHomePageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnCofirmBill, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(PanelHomePageLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeleleBill, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelHomePageLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addGap(10, 10, 10)
                        .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleleBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCofirmBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1364, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE))
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
            EffectComponents.instance.removePlaceHolderStyle(txtSearch);
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, new Color(204, 255, 255)));
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().length() == 0) {
            EffectComponents.instance.addPlaceHolderStyle(txtSearch);
            txtSearch.setText("Search");
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        String name = txtSearch.getText().trim();
        if (name.isEmpty()) {
            addPanelPhone();
        } else {
            fetchPhonesByNameOrBrand(name, name);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCofirmBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCofirmBillMouseClicked

        String name = txtName.getText().trim();
        String phone = txtNumberPhone.getText().trim();
        String address = txtAdress.getText().trim();
        String email = txtEmail.getText().trim();
        String totalText = txtTotal.getText().trim();
        if (totalText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "empty transaction!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double _totalAmount;
        try {
            _totalAmount = Double.parseDouble(totalText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "empty transaction!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (currentStaff.isStatus() == false) {
            JOptionPane.showMessageDialog(this, "This account is currently inactive!");
            return;
        }
        if (currentStaff.getPosition().equalsIgnoreCase("employee")
                || currentStaff.getPosition().equalsIgnoreCase("admin")) {
            int check = JOptionPane.showConfirmDialog(this, "CONFIRM THIS BILL !", "CONFIRM", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                BillController.instance.confirmBill(tbPhone, name, phone, address, email, _totalAmount, currentStaff.getId());
                panelManagerBill.loadBillInTbale();
                panelManagerPhone.loadTabelPhone();
                panelManagerClient.loadTbaleClient();
                addPanelPhone();
                viewClient();
                model.setNumRows(0);
                txtTotal.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "YOU HAVE NOT BEEN GRANTED EMPLOYEE POSITION");
        }

    }//GEN-LAST:event_btnCofirmBillMouseClicked

    private void btnDeleleBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleleBillMouseClicked

        int check = JOptionPane.showConfirmDialog(this, "Do you want delete all bill in tabel !", "Confirm", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            model.setNumRows(0);
            txtTotal.setText("");
            viewClient();
        }

    }//GEN-LAST:event_btnDeleleBillMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContainPhone;
    private javax.swing.JPanel PanelHomePage;
    private Forms.Components.HeaderButton btnCofirmBill;
    private Forms.Components.HeaderButton btnDeleleBill;
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
