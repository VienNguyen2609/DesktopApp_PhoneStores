package Forms;

import Controllers.PhoneController;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PanelManagerPhone extends javax.swing.JPanel {

    private File selectedFile;
    private Icon icon;

    private int idProductText;
    private String namePhoneText;
    private String brandPhoneText;
    private double pricePhoneText;
    private int quantityPhoneText;
    private String OSPhoneText;
    private String DescriptionPhoneText;
    private boolean statusPhone;
    private String statusPhoneText;
    private int selectedRow;
    private byte[] imageProduct = null;

    private PanelHome panelHome;

    public PanelManagerPhone(PanelHome panelHome) {
        initComponents();
        PhoneController.init();
        PhoneController.instance.loadTableProduct(tbProduct);
        this.panelHome = panelHome;
        styleButton();
    }

    private void styleButton() {
        btnUploadImagePhone.setBackgroundColor(Color.GREEN);
        btnAddPhone.setBackgroundColor(Color.BLUE);
        btnDeletePhone.setBackgroundColor(Color.GREEN);
        btnCancelPhone.setBackgroundColor(Color.ORANGE);
        btnPushPhoneToHome.setBackgroundColor(Color.lightGray);
        btnUpdatePhone.setBackgroundColor(Color.RED);
    }

    private void viewTextProduct() {
        txtNamePhone.setText("");
        txtBrandPhone.setText("");
        txtPricePhone.setText("");
        txtQuantityPhone.setValue(0);
        txtOSPhone.setText("");
        LabelImagePhone.setIcon(null);
        txtDescriptionPhone.setText("");
    }

    private void getPhoneInputData() {

        namePhoneText = txtNamePhone.getText().trim();
        brandPhoneText = txtBrandPhone.getText().trim();
        OSPhoneText = txtOSPhone.getText().trim();
        DescriptionPhoneText = txtDescriptionPhone.getText().trim();
        selectedRow = tbProduct.getSelectedRow();
        statusPhoneText = cbStatusPhone.getSelectedItem().toString();
        statusPhone = statusPhoneText.equalsIgnoreCase("Active"); // true nếu đang kinh doanh

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        pricePhoneText = Double.parseDouble(txtPricePhone.getText().trim());
        quantityPhoneText = Integer.parseInt(txtQuantityPhone.getValue().toString().trim());
        idProductText = Integer.parseInt(tbProduct.getValueAt(selectedRow, 1).toString().trim());

        if (namePhoneText.isEmpty() || brandPhoneText.isEmpty() || pricePhoneText <= 0 || quantityPhoneText <= 0) {
            JOptionPane.showMessageDialog(this, "INFORMATION NOT EMPTY");
            return;
        }
        try {
            if (selectedFile == null) {
                return;
            } else {
                imageProduct = Files.readAllBytes(selectedFile.toPath());
            }
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clickTableProduct() {

        selectedRow = tbProduct.getSelectedRow();

        if (selectedRow != -1) {
            String name = tbProduct.getValueAt(selectedRow, 2).toString();
            String brand = tbProduct.getValueAt(selectedRow, 3).toString();
            double price = Double.parseDouble(tbProduct.getValueAt(selectedRow, 4).toString());
            int quantity = Integer.parseInt(tbProduct.getValueAt(selectedRow, 5).toString());
            String OS = tbProduct.getValueAt(selectedRow, 6).toString();
            byte[] image = (byte[]) tbProduct.getValueAt(selectedRow, 7);
            String description = tbProduct.getValueAt(selectedRow, 8).toString();
            String _status = tbProduct.getValueAt(selectedRow, 9).toString();
//            LabelNameProduct.setForeground(Color.GREEN);
//            LabelSizeProduct.setForeground(Color.GREEN);
//            LabelPriceProduct.setForeground(Color.GREEN);
//            LabelQuantityProduct.setForeground(Color.GREEN);
//            LabelColorProduct.setForeground(Color.GREEN);
            txtNamePhone.setText(name);
            txtBrandPhone.setText("" + brand);
            txtPricePhone.setText("" + price); // hoặc setValue nếu là JSpinner
            txtQuantityPhone.setValue(quantity); // JSpinner
            txtOSPhone.setText(OS);
            if (_status.equalsIgnoreCase("Availabel")) {
                cbStatusPhone.setSelectedIndex(0);
            } else {
                cbStatusPhone.setSelectedIndex(1);
            }
            if (image != null) {
                ImageIcon icon = new ImageIcon(image);
                LabelImagePhone.setIcon(icon);
            } else {
                LabelImagePhone.setIcon(null);
            }
            txtDescriptionPhone.setText(description);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProducts = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnDeletePhone = new Forms.Components.HeaderButton();
        btnCancelPhone = new Forms.Components.HeaderButton();
        btnUploadImagePhone = new Forms.Components.HeaderButton();
        btnAddPhone = new Forms.Components.HeaderButton();
        btnUpdatePhone = new Forms.Components.HeaderButton();
        LabelPriceProduct = new javax.swing.JLabel();
        LabelNameProduct = new javax.swing.JLabel();
        LabelQuantityProduct = new javax.swing.JLabel();
        LabelColorProduct = new javax.swing.JLabel();
        txtQuantityPhone = new javax.swing.JSpinner();
        txtPricePhone = new Forms.Components.TextFieldController();
        txtOSPhone = new Forms.Components.TextFieldController();
        txtNamePhone = new Forms.Components.TextFieldController();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnPushPhoneToHome = new Forms.Components.HeaderButton();
        LabelImagePhone = new Forms.Components.ProfilePhoto();
        txtDescriptionPhone = new Forms.Components.TextFieldController();
        jLabel18 = new javax.swing.JLabel();
        LabelSizeProduct = new javax.swing.JLabel();
        LabelNameProduct1 = new javax.swing.JLabel();
        txtBrandPhone = new Forms.Components.TextFieldController();
        jLabel19 = new javax.swing.JLabel();
        cbStatusPhone = new javax.swing.JComboBox<>();
        LabelSizeProduct1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1355, 650));

        PanelProducts.setPreferredSize(new java.awt.Dimension(1355, 655));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeletePhone.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon1.png"))); // NOI18N
        btnDeletePhone.setText("Delete");
        btnDeletePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletePhoneMouseClicked(evt);
            }
        });
        jPanel2.add(btnDeletePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 130, 30));

        btnCancelPhone.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelIcon.png"))); // NOI18N
        btnCancelPhone.setText("Cancel");
        btnCancelPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelPhoneMouseClicked(evt);
            }
        });
        jPanel2.add(btnCancelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 130, 30));

        btnUploadImagePhone.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadImagePhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UploadImageIcon.png"))); // NOI18N
        btnUploadImagePhone.setText("UploadImage");
        btnUploadImagePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadImagePhoneMouseClicked(evt);
            }
        });
        jPanel2.add(btnUploadImagePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 170, 30));

        btnAddPhone.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AddIcon.png"))); // NOI18N
        btnAddPhone.setText("Add");
        btnAddPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPhoneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddPhoneMouseEntered(evt);
            }
        });
        jPanel2.add(btnAddPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 130, 30));

        btnUpdatePhone.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateIcon.png"))); // NOI18N
        btnUpdatePhone.setText("Update");
        btnUpdatePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdatePhoneMouseClicked(evt);
            }
        });
        jPanel2.add(btnUpdatePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 130, 30));

        LabelPriceProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPriceProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelPriceProduct.setText("Price");
        jPanel2.add(LabelPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, 20));

        LabelNameProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct.setText("NamePhone");
        jPanel2.add(LabelNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        LabelQuantityProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelQuantityProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelQuantityProduct.setText("Quantity");
        jPanel2.add(LabelQuantityProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        LabelColorProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelColorProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelColorProduct.setText("Operating System");
        jPanel2.add(LabelColorProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        txtQuantityPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQuantityPhone.setMaximumSize(new java.awt.Dimension(70, 70));
        txtQuantityPhone.setMinimumSize(new java.awt.Dimension(50, 20));
        jPanel2.add(txtQuantityPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 90, -1));

        txtPricePhone.setForeground(new java.awt.Color(255, 255, 255));
        txtPricePhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPricePhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PriceIcon.png"))); // NOI18N
        jPanel2.add(txtPricePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 150, 30));

        txtOSPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtOSPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOSPhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OSIcon.png"))); // NOI18N
        jPanel2.add(txtOSPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 150, -1));

        txtNamePhone.setForeground(new java.awt.Color(255, 255, 255));
        txtNamePhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNamePhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NameIcon.png"))); // NOI18N
        jPanel2.add(txtNamePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 170, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("____________________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 210, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("____________________________________");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 210, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("_________________________________________________");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 290, 30));

        btnPushPhoneToHome.setForeground(new java.awt.Color(255, 255, 255));
        btnPushPhoneToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RefreshIcon.png"))); // NOI18N
        btnPushPhoneToHome.setText("Refresh ");
        btnPushPhoneToHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPushPhoneToHomeMouseClicked(evt);
            }
        });
        jPanel2.add(btnPushPhoneToHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 240, 130, 30));

        LabelImagePhone.setPreferredSize(new java.awt.Dimension(160, 130));
        jPanel2.add(LabelImagePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 220));

        txtDescriptionPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtDescriptionPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescriptionPhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DescriptionIcon.png"))); // NOI18N
        jPanel2.add(txtDescriptionPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 270, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("____________________________________");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 210, 30));

        LabelSizeProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSizeProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelSizeProduct.setText("Status Phone ");
        jPanel2.add(LabelSizeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 160, 110, -1));

        LabelNameProduct1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct1.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct1.setText("Brand");
        jPanel2.add(LabelNameProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, -1, -1));

        txtBrandPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtBrandPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBrandPhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BrandIcon.png"))); // NOI18N
        jPanel2.add(txtBrandPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 170, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("____________________________________");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 210, 30));

        cbStatusPhone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Discontinued" }));
        jPanel2.add(cbStatusPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, 110, 30));

        LabelSizeProduct1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSizeProduct1.setForeground(new java.awt.Color(255, 255, 255));
        LabelSizeProduct1.setText("Description Phone");
        jPanel2.add(LabelSizeProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 130, -1));

        tbProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbProduct.setForeground(new java.awt.Color(255, 255, 255));
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID", "Name", "Brand", "Price", "Quantity", "Operating System", "Image", "DescriptionPhone", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProduct.setShowHorizontalLines(true);
        tbProduct.setShowVerticalLines(true);
        tbProduct.getTableHeader().setResizingAllowed(false);
        tbProduct.getTableHeader().setReorderingAllowed(false);
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProduct);
        if (tbProduct.getColumnModel().getColumnCount() > 0) {
            tbProduct.getColumnModel().getColumn(0).setMinWidth(80);
            tbProduct.getColumnModel().getColumn(0).setMaxWidth(80);
            tbProduct.getColumnModel().getColumn(2).setResizable(false);
            tbProduct.getColumnModel().getColumn(3).setResizable(false);
            tbProduct.getColumnModel().getColumn(4).setResizable(false);
            tbProduct.getColumnModel().getColumn(6).setResizable(false);
            tbProduct.getColumnModel().getColumn(7).setResizable(false);
            tbProduct.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout PanelProductsLayout = new javax.swing.GroupLayout(PanelProducts);
        PanelProducts.setLayout(PanelProductsLayout);
        PanelProductsLayout.setHorizontalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1355, Short.MAX_VALUE)
            .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1287, Short.MAX_VALUE))
        );
        PanelProductsLayout.setVerticalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductsLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 380, Short.MAX_VALUE))
            .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductsLayout.createSequentialGroup()
                    .addGap(0, 284, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1355, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletePhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePhoneMouseClicked

        getPhoneInputData();
        PhoneController.instance.loadDataProducts();
        try {
            int check = JOptionPane.showConfirmDialog(this, "DO YOU WANT DELETE THIS PRODUCT!", "CONFIRM", JOptionPane.YES_NO_OPTION);

            if (check == JOptionPane.YES_OPTION) {
                if (PhoneController.instance.deleteProduct(idProductText)) {
                    PhoneController.instance.loadTableProduct(tbProduct);
                    viewTextProduct();
                    JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY");
                } else {
                    JOptionPane.showMessageDialog(this, "DELETE FAILURE");

                }
            } else {
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletePhoneMouseClicked

    private void btnCancelPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelPhoneMouseClicked
        viewTextProduct();
    }//GEN-LAST:event_btnCancelPhoneMouseClicked

    private void btnUploadImagePhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadImagePhoneMouseClicked

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(LabelImagePhone.getWidth(), LabelImagePhone.getHeight(), Image.SCALE_SMOOTH));
            LabelImagePhone.setIcon(icon);
            LabelImagePhone.setBorder(null);
        }
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
            return;
        }

    }//GEN-LAST:event_btnUploadImagePhoneMouseClicked

    private void btnAddPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPhoneMouseClicked

        getPhoneInputData();

        try {
            if (PhoneController.instance.addProduct(namePhoneText, brandPhoneText,
                    pricePhoneText, quantityPhoneText, OSPhoneText, imageProduct, DescriptionPhoneText, statusPhone)) {
                PhoneController.instance.loadDataProducts();
                PhoneController.instance.loadTableProduct(tbProduct);
                viewTextProduct();
                LabelImagePhone.setIcon(null);
                // LabelImageProduct.setBorder(new MatteBorder(1, 1, 1, 1, Color.YELLOW));
                JOptionPane.showMessageDialog(this, "PRODUCT ADDED SUCCESSFULLY");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddPhoneMouseClicked

    private void btnUpdatePhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePhoneMouseClicked

        getPhoneInputData();
        if (PhoneController.instance.updateProduct(namePhoneText, brandPhoneText, pricePhoneText,
                quantityPhoneText, OSPhoneText, imageProduct, DescriptionPhoneText, statusPhone, idProductText)) {
            JOptionPane.showMessageDialog(this, "UPDATED THIS PRODUCT ID: " + idProductText + " SUCCESSFULLY");
            PhoneController.instance.loadTableProduct(tbProduct);
            viewTextProduct();
            LabelImagePhone.setIcon(null);
            //   LabelImageProduct.setBorder(new MatteBorder(1, 1, 1, 1, Color.YELLOW));
            return;
        } else {
            JOptionPane.showMessageDialog(this, "UPDATED FAILURE THIS PRODUCT ID: " + idProductText);
            return;
        }
    }//GEN-LAST:event_btnUpdatePhoneMouseClicked

    private void btnPushPhoneToHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPushPhoneToHomeMouseClicked

        int check = JOptionPane.showConfirmDialog(this, "UPLOAD ALL PRODUCT TO HOMEPAGE!", "CONFIRM", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            panelHome.addPanelProducts();
            JOptionPane.showMessageDialog(this, "UPLOAD TO HOMEPAGE SUCCESSFULLY!");
        } else {
            return;
        }

    }//GEN-LAST:event_btnPushPhoneToHomeMouseClicked

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        clickTableProduct();
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnAddPhoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPhoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPhoneMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelColorProduct;
    private Forms.Components.ProfilePhoto LabelImagePhone;
    private javax.swing.JLabel LabelNameProduct;
    private javax.swing.JLabel LabelNameProduct1;
    private javax.swing.JLabel LabelPriceProduct;
    private javax.swing.JLabel LabelQuantityProduct;
    private javax.swing.JLabel LabelSizeProduct;
    private javax.swing.JLabel LabelSizeProduct1;
    private javax.swing.JPanel PanelProducts;
    private Forms.Components.HeaderButton btnAddPhone;
    private Forms.Components.HeaderButton btnCancelPhone;
    private Forms.Components.HeaderButton btnDeletePhone;
    private Forms.Components.HeaderButton btnPushPhoneToHome;
    private Forms.Components.HeaderButton btnUpdatePhone;
    private Forms.Components.HeaderButton btnUploadImagePhone;
    private javax.swing.JComboBox<String> cbStatusPhone;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbProduct;
    private Forms.Components.TextFieldController txtBrandPhone;
    private Forms.Components.TextFieldController txtDescriptionPhone;
    private Forms.Components.TextFieldController txtNamePhone;
    private Forms.Components.TextFieldController txtOSPhone;
    private Forms.Components.TextFieldController txtPricePhone;
    private javax.swing.JSpinner txtQuantityPhone;
    // End of variables declaration//GEN-END:variables
}
