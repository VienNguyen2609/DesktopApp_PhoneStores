package Forms;

import Controllers.BillController;
import Forms.Components.EffectComponents;
import Model.Account;
import Model.Phone;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author VIEN
 */
public class PanelPhone extends javax.swing.JPanel {

    private Account currentAccount;

    private PanelHome panelHome;
    private int quantityAvailable;
    private int productIdCurrent;
    private ImageIcon icon;
    private PanelManagerBill panelManagerBill;

    private int quantityAvailableBill;
    public int statusBill = 0;

    public PanelPhone(Account account) {
        initComponents();
        this.currentAccount = account;
    }

    public PanelPhone() {
        initComponents();
    }

    public PanelPhone(Phone phone, PanelHome panelHome, Account account, PanelManagerBill panelManagerBill) {
        initComponents();
        BillController.init();
        this.panelHome = panelHome;
        this.currentAccount = account;
        this.panelManagerBill = panelManagerBill;
        
        PanelBill.setSize(new Dimension(600, 700));
        PanelBill.setLocation(400, 100);
        PanelBill.setVisible(false);
        PanelBill.setTitle("CONFIRM BILL");
        PanelBill.setResizable(false);
        
        
        productIdCurrent = phone.getPhoneId();
        txtName.setText(phone.getNamePhone());
        txtBrand.setText(String.valueOf(phone.getBrandPhone()));
        txtPrice.setText(String.valueOf(phone.getPricePhone()));
        txtQuantity.setText(String.valueOf(phone.getQuantityPhone()));
        txtOS.setText(phone.getOperatingSystem());
        txtDescription.setText(phone.getDescription());
        this.quantityAvailable = phone.getQuantityPhone();
        byte[] imageBytes = phone.getImagePhone();
        int defaultWidth = 201;
        int defaultHeight = 240;
        
//        try {
//            EffectComponents.instance.bufferedImage("E:\\Image\\459226e0-3cab-4bb5-862f-1b2810a37d03.png", jLabel2, 0.9f);
//        } catch (IOException ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//        }
        
        if (imageBytes != null && imageBytes.length > 0) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                BufferedImage bufferedImage = ImageIO.read(bais);
                if (bufferedImage != null) {
                    Image scaledImage = bufferedImage.getScaledInstance(defaultWidth, defaultHeight, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                    LabelImage.setIcon(icon);
                    //  LabelImage.setBorder(new RoundedBorder(30));

                } else {
                    System.out.println("CAN NOT UPLOAD IMAGE PRODUCTS");

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            jLabel1.setText("NOT UPDATED IMAGE");
        }

        this.jLabel1.repaint();
        
        btnPurchase.setForeground(new Color(0, 0 , 0));
        
    }

    private void viewBill() {

        txtBillName.setText("");
        txtBillPrice.setText("");
        txtBillOS.setText("");
        txtBillBrand.setText("");
        txtBillDescription.setText("");
        txtBillDate.setText("");
        txtBillQuantity.setText("");
    }

    public void getTextBill(int productId, String name, String brand, String price, String OS, String description, int quantityAvailable, ImageIcon imageIcon) {

        ImageProductBill.setIcon(imageIcon);
        productIdCurrent = productId;
        txtBillName.setText(name);
        txtBillPrice.setText(price);
        txtBillOS.setText(OS);
        txtBillBrand.setText(brand);
        txtBillDescription.setText(description);
        txtBillDate.setText("" + new java.sql.Date(new Date().getTime()));
        this.quantityAvailableBill = quantityAvailable;
        PanelBill.setVisible(true);
//        txtBillQuantity.setFocusable(true);
//        txtBillQuantity.requestFocusInWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBill = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnCanelBuy = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        ImageProductBill = new javax.swing.JLabel();
        txtBillOS = new javax.swing.JTextField();
        txtBillDescription = new javax.swing.JTextField();
        txtBillName = new javax.swing.JTextField();
        txtBillBrand = new javax.swing.JTextField();
        txtBillQuantity = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtBillPrice = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtBillDate = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        btnPurchase = new Forms.Components.HeaderButton();
        txtName = new Forms.Components.TextFieldController();
        txtPrice = new Forms.Components.TextFieldController();
        jLabel1 = new javax.swing.JLabel();
        LabelImage = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txtQuantity = new Forms.Components.TextFieldController();
        jLabel72 = new javax.swing.JLabel();
        txtBrand = new Forms.Components.TextFieldController();
        jLabel73 = new javax.swing.JLabel();
        txtDescription = new Forms.Components.TextFieldController();
        txtOS = new Forms.Components.TextFieldController();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        PanelBill.setModal(true);

        jPanel2.setMaximumSize(new java.awt.Dimension(600, 700));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 700));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 700));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("----------------------------------CONFIRM BILL------------------------------");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 580, 34));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("OS:");
        jLabel18.setToolTipText("");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 40, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Date:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 50, 30));

        btnBuy.setBackground(new java.awt.Color(255, 0, 51));
        btnBuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("Buy it");
        btnBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuyMouseExited(evt);
            }
        });
        jPanel2.add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 110, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Brand");
        jLabel20.setToolTipText("");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Description:");
        jLabel21.setToolTipText("");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 100, 30));

        btnCanelBuy.setBackground(new java.awt.Color(204, 204, 204));
        btnCanelBuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCanelBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnCanelBuy.setText("Cancel");
        btnCanelBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCanelBuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCanelBuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCanelBuyMouseExited(evt);
            }
        });
        jPanel2.add(btnCanelBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, 110, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("Name");
        jLabel22.setToolTipText("");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        ImageProductBill.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 255)));
        jPanel2.add(ImageProductBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 63, 210, 240));

        txtBillOS.setEditable(false);
        txtBillOS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillOS.setForeground(new java.awt.Color(255, 255, 255));
        txtBillOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillOSActionPerformed(evt);
            }
        });
        jPanel2.add(txtBillOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 167, 33));

        txtBillDescription.setEditable(false);
        txtBillDescription.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillDescription.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtBillDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 280, 33));

        txtBillName.setEditable(false);
        txtBillName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtBillName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 167, 33));

        txtBillBrand.setEditable(false);
        txtBillBrand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillBrand.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtBillBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 167, 33));

        txtBillQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtBillQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillQuantityActionPerformed(evt);
            }
        });
        jPanel2.add(txtBillQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 167, 33));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("Price:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 50, 30));

        txtBillPrice.setEditable(false);
        txtBillPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillPrice.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtBillPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 167, 33));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("Quantity");
        jLabel24.setToolTipText("");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 30));

        txtBillDate.setEditable(false);
        txtBillDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBillDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtBillDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 167, 33));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelBillLayout = new javax.swing.GroupLayout(PanelBill.getContentPane());
        PanelBill.getContentPane().setLayout(PanelBillLayout);
        PanelBillLayout.setHorizontalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelBillLayout.setVerticalGroup(
            PanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel16.setMaximumSize(new java.awt.Dimension(330, 500));
        jPanel16.setMinimumSize(new java.awt.Dimension(250, 404));
        jPanel16.setPreferredSize(new java.awt.Dimension(270, 450));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Remaining:");
        jPanel16.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, 30));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Description");
        jPanel16.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 90, 30));

        btnPurchase.setBackground(new java.awt.Color(204, 255, 204));
        btnPurchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BuyIcon.png"))); // NOI18N
        btnPurchase.setText("Purchase");
        btnPurchase.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPurchase.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPurchaseMouseClicked(evt);
            }
        });
        jPanel16.add(btnPurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 250, 40));

        txtName.setEditable(false);
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setToolTipText("");
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel16.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 130, -1));

        txtPrice.setEditable(false);
        txtPrice.setForeground(new java.awt.Color(204, 255, 255));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel16.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 190, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel16.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, 20));
        jPanel16.add(LabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 201, 240));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Brand: ");
        jPanel16.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 40));

        txtQuantity.setEditable(false);
        txtQuantity.setForeground(new java.awt.Color(204, 255, 255));
        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel16.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 80, 30));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Price:");
        jPanel16.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 43, 30));

        txtBrand.setEditable(false);
        txtBrand.setForeground(new java.awt.Color(204, 255, 255));
        txtBrand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel16.add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 170, 40));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Operating System:");
        jPanel16.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 30));

        txtDescription.setEditable(false);
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescription.setToolTipText("");
        txtDescription.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel16.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 300, -1));

        txtOS.setEditable(false);
        txtOS.setForeground(new java.awt.Color(204, 255, 255));
        txtOS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOSActionPerformed(evt);
            }
        });
        jPanel16.add(txtOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 150, 30));
        jPanel16.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 600));

        jCheckBox1.setText("jCheckBox1");
        jPanel16.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked

    }//GEN-LAST:event_jPanel16MouseClicked

    private void btnBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseClicked

        try {

            int quantity = Integer.parseInt(txtBillQuantity.getText().trim());
            if (quantity > quantityAvailableBill || quantity < 0 || quantity == 0) {
                JOptionPane.showMessageDialog(this, "Purchase quantity exceeds available stock!");
                return;
            }

            double price = Double.parseDouble(txtBillPrice.getText().trim());

            int check = JOptionPane.showConfirmDialog(this, "ARE YOU SURE WANT BUY IT ", "CONFIRM", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                if (BillController.instance.addBill(currentAccount.getUserId(), productIdCurrent, new java.sql.Date(new Date().getTime()), quantity, price)) {

                    PanelBill.setVisible(false);
                    JOptionPane.showMessageDialog(this, "BUY SUCCESSFULLY");
                    //                     BillController.instance.loadBills(tbBill, currentAccount.getUserName());
                    statusBill = 1;
                    panelManagerBill.statusBill();
                    panelHome.addPanelProducts();
//                    addPanelProducts();
                    viewBill();
                    return;
                }
            } else {
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ENTER A NUMBER NOT STRING", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBuyMouseClicked

    private void btnBuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseEntered
        btnBuy.setBackground(Color.GREEN);
    }//GEN-LAST:event_btnBuyMouseEntered

    private void btnBuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyMouseExited
        btnBuy.setBackground(Color.RED);
    }//GEN-LAST:event_btnBuyMouseExited

    private void btnCanelBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseClicked
        viewBill();
    }//GEN-LAST:event_btnCanelBuyMouseClicked

    private void btnCanelBuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseEntered
        btnCanelBuy.setBackground(Color.MAGENTA);
    }//GEN-LAST:event_btnCanelBuyMouseEntered

    private void btnCanelBuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseExited
        btnCanelBuy.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCanelBuyMouseExited

    private void txtBillOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillOSActionPerformed

    }//GEN-LAST:event_txtBillOSActionPerformed

    private void txtBillQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillQuantityActionPerformed

    }//GEN-LAST:event_txtBillQuantityActionPerformed

    private void txtOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOSActionPerformed

    private void btnPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPurchaseMouseClicked

        getTextBill(productIdCurrent, txtName.getText().trim(), txtBrand.getText(),
            txtPrice.getText(), txtOS.getText(), txtDescription.getText(), quantityAvailable, icon);

    }//GEN-LAST:event_btnPurchaseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageProductBill;
    private javax.swing.JLabel LabelImage;
    private javax.swing.JDialog PanelBill;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCanelBuy;
    private Forms.Components.HeaderButton btnPurchase;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBillBrand;
    private javax.swing.JTextField txtBillDate;
    private javax.swing.JTextField txtBillDescription;
    private javax.swing.JTextField txtBillName;
    private javax.swing.JTextField txtBillOS;
    private javax.swing.JTextField txtBillPrice;
    private javax.swing.JTextField txtBillQuantity;
    private Forms.Components.TextFieldController txtBrand;
    private Forms.Components.TextFieldController txtDescription;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtOS;
    private Forms.Components.TextFieldController txtPrice;
    private Forms.Components.TextFieldController txtQuantity;
    // End of variables declaration//GEN-END:variables
}
