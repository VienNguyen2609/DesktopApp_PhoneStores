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
    private byte[] imagePhone = null;

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
        if(txtPricePhone.getText().trim().isEmpty()){
            return;
        }
        pricePhoneText = Double.parseDouble(txtPricePhone.getText().trim());
        quantityPhoneText = Integer.parseInt(txtQuantityPhone.getValue().toString().trim());
        idProductText = Integer.parseInt(tbProduct.getValueAt(selectedRow, 1).toString().trim());

        if (namePhoneText.isEmpty() || brandPhoneText.isEmpty() || pricePhoneText 
                <= 0 || quantityPhoneText <= 0 || OSPhoneText.isEmpty() || 
                DescriptionPhoneText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "INFORMATION NOT EMPTY");
            return;
        }
        try {

            if (selectedFile != null) {
                imagePhone = Files.readAllBytes(selectedFile.toPath()); // Chọn ảnh mới
            } else if (icon != null) {
                // Lấy byte[] từ icon (ImageIcon)
                imagePhone = util.ImageUtils.iconToBytes((ImageIcon) icon); // 👈 thêm hàm này ở dưới
            } else {
                imagePhone = null; // Không có ảnh
            }
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clickTableProduct() {

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
                icon = new ImageIcon(image);

                LabelImagePhone.setIcon(icon);

            } else {
                LabelImagePhone.setIcon(null);
            }
            txtDescriptionPhone.setText(description);
        }

    }

    public void loadTabelPhone() {
        PhoneController.instance.loadTableProduct(tbProduct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProducts = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        btnDeletePhone = new Forms.Components.HeaderButton();
        btnCancelPhone = new Forms.Components.HeaderButton();
        btnUploadImagePhone = new Forms.Components.HeaderButton();
        btnAddPhone = new Forms.Components.HeaderButton();
        btnUpdatePhone = new Forms.Components.HeaderButton();
        LabelImagePhone = new Forms.Components.ProfilePhoto();
        LabelPriceProduct = new javax.swing.JLabel();
        txtDescriptionPhone = new Forms.Components.TextFieldController();
        LabelColorProduct = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtQuantityPhone = new javax.swing.JSpinner();
        LabelSizeProduct = new javax.swing.JLabel();
        txtPricePhone = new Forms.Components.TextFieldController();
        txtBrandPhone = new Forms.Components.TextFieldController();
        txtOSPhone = new Forms.Components.TextFieldController();
        jLabel19 = new javax.swing.JLabel();
        txtNamePhone = new Forms.Components.TextFieldController();
        cbStatusPhone = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        LabelSizeProduct1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnPushPhoneToHome = new Forms.Components.HeaderButton();
        LabelPriceProduct1 = new javax.swing.JLabel();
        LabelPriceProduct2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1355, 650));

        PanelProducts.setPreferredSize(new java.awt.Dimension(1355, 655));

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
        tbProduct.setMaximumSize(new java.awt.Dimension(900, 80));
        tbProduct.setMinimumSize(new java.awt.Dimension(90, 80));
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
            tbProduct.getColumnModel().getColumn(1).setMinWidth(80);
            tbProduct.getColumnModel().getColumn(1).setMaxWidth(80);
            tbProduct.getColumnModel().getColumn(2).setResizable(false);
            tbProduct.getColumnModel().getColumn(3).setResizable(false);
            tbProduct.getColumnModel().getColumn(4).setResizable(false);
            tbProduct.getColumnModel().getColumn(5).setMinWidth(60);
            tbProduct.getColumnModel().getColumn(5).setMaxWidth(60);
            tbProduct.getColumnModel().getColumn(6).setResizable(false);
            tbProduct.getColumnModel().getColumn(7).setResizable(false);
            tbProduct.getColumnModel().getColumn(8).setMinWidth(230);
            tbProduct.getColumnModel().getColumn(8).setMaxWidth(230);
            tbProduct.getColumnModel().getColumn(9).setResizable(false);
        }

        btnDeletePhone.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon1.png"))); // NOI18N
        btnDeletePhone.setText("Delete");
        btnDeletePhone.setMaximumSize(new java.awt.Dimension(220, 38));
        btnDeletePhone.setMinimumSize(new java.awt.Dimension(60, 38));
        btnDeletePhone.setPreferredSize(new java.awt.Dimension(130, 30));
        btnDeletePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletePhoneMouseClicked(evt);
            }
        });

        btnCancelPhone.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelIcon.png"))); // NOI18N
        btnCancelPhone.setText("Cancel");
        btnCancelPhone.setMaximumSize(new java.awt.Dimension(220, 38));
        btnCancelPhone.setMinimumSize(new java.awt.Dimension(60, 38));
        btnCancelPhone.setPreferredSize(new java.awt.Dimension(130, 30));
        btnCancelPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelPhoneMouseClicked(evt);
            }
        });

        btnUploadImagePhone.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadImagePhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UploadImageIcon.png"))); // NOI18N
        btnUploadImagePhone.setText("UploadImage");
        btnUploadImagePhone.setMaximumSize(new java.awt.Dimension(110, 50));
        btnUploadImagePhone.setMinimumSize(new java.awt.Dimension(30, 20));
        btnUploadImagePhone.setPreferredSize(new java.awt.Dimension(90, 38));
        btnUploadImagePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadImagePhoneMouseClicked(evt);
            }
        });

        btnAddPhone.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AddIcon.png"))); // NOI18N
        btnAddPhone.setText("Add");
        btnAddPhone.setMaximumSize(new java.awt.Dimension(210, 40));
        btnAddPhone.setMinimumSize(new java.awt.Dimension(90, 40));
        btnAddPhone.setPreferredSize(new java.awt.Dimension(130, 30));
        btnAddPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPhoneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddPhoneMouseEntered(evt);
            }
        });

        btnUpdatePhone.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateIcon.png"))); // NOI18N
        btnUpdatePhone.setText("Update");
        btnUpdatePhone.setMaximumSize(new java.awt.Dimension(230, 42));
        btnUpdatePhone.setMinimumSize(new java.awt.Dimension(50, 42));
        btnUpdatePhone.setPreferredSize(new java.awt.Dimension(130, 30));
        btnUpdatePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdatePhoneMouseClicked(evt);
            }
        });

        LabelImagePhone.setMaximumSize(new java.awt.Dimension(250, 200));
        LabelImagePhone.setMinimumSize(new java.awt.Dimension(100, 90));
        LabelImagePhone.setPreferredSize(new java.awt.Dimension(160, 130));

        LabelPriceProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPriceProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelPriceProduct.setText("Price");

        txtDescriptionPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtDescriptionPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescriptionPhone.setMaximumSize(new java.awt.Dimension(270, 28));
        txtDescriptionPhone.setMinimumSize(new java.awt.Dimension(70, 28));
        txtDescriptionPhone.setPreferredSize(new java.awt.Dimension(270, 28));
        txtDescriptionPhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DescriptionIcon.png"))); // NOI18N

        LabelColorProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelColorProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelColorProduct.setText("Operating System");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("____________________________________");

        txtQuantityPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQuantityPhone.setMaximumSize(new java.awt.Dimension(70, 70));
        txtQuantityPhone.setMinimumSize(new java.awt.Dimension(50, 20));

        LabelSizeProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSizeProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelSizeProduct.setText("Status Phone ");

        txtPricePhone.setForeground(new java.awt.Color(255, 255, 255));
        txtPricePhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPricePhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PriceIcon.png"))); // NOI18N

        txtBrandPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtBrandPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBrandPhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BrandIcon.png"))); // NOI18N

        txtOSPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtOSPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOSPhone.setPreferredSize(new java.awt.Dimension(150, 28));
        txtOSPhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OSIcon.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("____________________________________");

        txtNamePhone.setForeground(new java.awt.Color(255, 255, 255));
        txtNamePhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNamePhone.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NameIcon.png"))); // NOI18N

        cbStatusPhone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Discontinued" }));
        cbStatusPhone.setMaximumSize(new java.awt.Dimension(230, 30));
        cbStatusPhone.setMinimumSize(new java.awt.Dimension(50, 22));
        cbStatusPhone.setPreferredSize(new java.awt.Dimension(110, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("____________________________________");

        LabelSizeProduct1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSizeProduct1.setForeground(new java.awt.Color(255, 255, 255));
        LabelSizeProduct1.setText("Description Phone");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("____________________________________");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("_________________________________________________");

        btnPushPhoneToHome.setForeground(new java.awt.Color(255, 255, 255));
        btnPushPhoneToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RefreshIcon.png"))); // NOI18N
        btnPushPhoneToHome.setText("Refresh ");
        btnPushPhoneToHome.setMaximumSize(new java.awt.Dimension(210, 38));
        btnPushPhoneToHome.setMinimumSize(new java.awt.Dimension(60, 38));
        btnPushPhoneToHome.setPreferredSize(new java.awt.Dimension(130, 30));
        btnPushPhoneToHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPushPhoneToHomeMouseClicked(evt);
            }
        });

        LabelPriceProduct1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPriceProduct1.setForeground(new java.awt.Color(255, 255, 255));
        LabelPriceProduct1.setText("Name ");

        LabelPriceProduct2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPriceProduct2.setForeground(new java.awt.Color(255, 255, 255));
        LabelPriceProduct2.setText("Brand");

        javax.swing.GroupLayout PanelProductsLayout = new javax.swing.GroupLayout(PanelProducts);
        PanelProducts.setLayout(PanelProductsLayout);
        PanelProductsLayout.setHorizontalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(PanelProductsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProductsLayout.createSequentialGroup()
                        .addComponent(LabelImagePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProductsLayout.createSequentialGroup()
                                .addComponent(btnUploadImagePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPriceProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelProductsLayout.createSequentialGroup()
                                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBrandPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addComponent(txtQuantityPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LabelPriceProduct2))
                                .addGap(60, 60, 60))
                            .addGroup(PanelProductsLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelProductsLayout.createSequentialGroup()
                                        .addComponent(LabelPriceProduct)
                                        .addGap(256, 256, 256)
                                        .addComponent(LabelColorProduct)
                                        .addGap(128, 128, 128)
                                        .addComponent(LabelSizeProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelProductsLayout.createSequentialGroup()
                                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPricePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtOSPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDescriptionPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(10, 10, 10)
                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProductsLayout.createSequentialGroup()
                                .addComponent(LabelSizeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbStatusPhone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(PanelProductsLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnAddPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(120, 120, 120)
                        .addComponent(btnUpdatePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(120, 120, 120)
                        .addComponent(btnDeletePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(btnCancelPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(140, 140, 140)
                        .addComponent(btnPushPhoneToHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(125, 125, 125))
        );
        PanelProductsLayout.setVerticalGroup(
            PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelImagePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelProductsLayout.createSequentialGroup()
                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProductsLayout.createSequentialGroup()
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelProductsLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(LabelPriceProduct2))
                                    .addComponent(LabelPriceProduct1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUploadImagePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBrandPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelProductsLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQuantityPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(50, 50, 50)
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelPriceProduct)
                                    .addComponent(LabelColorProduct)
                                    .addComponent(LabelSizeProduct1))
                                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPricePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOSPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescriptionPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelProductsLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(PanelProductsLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(LabelSizeProduct)
                                .addGap(10, 10, 10)
                                .addComponent(cbStatusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addGap(10, 10, 10)
                .addGroup(PanelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPushPhoneToHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
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

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        clickTableProduct();
    }//GEN-LAST:event_tbProductMouseClicked

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
                    pricePhoneText, quantityPhoneText, OSPhoneText, imagePhone, DescriptionPhoneText, statusPhone)) {
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

    private void btnAddPhoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPhoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPhoneMouseEntered

    private void btnUpdatePhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePhoneMouseClicked

        getPhoneInputData();

        if (PhoneController.instance.updateProduct(namePhoneText, brandPhoneText, pricePhoneText,
                quantityPhoneText, OSPhoneText, imagePhone, DescriptionPhoneText, statusPhone, idProductText)) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelColorProduct;
    private Forms.Components.ProfilePhoto LabelImagePhone;
    private javax.swing.JLabel LabelPriceProduct;
    private javax.swing.JLabel LabelPriceProduct1;
    private javax.swing.JLabel LabelPriceProduct2;
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
