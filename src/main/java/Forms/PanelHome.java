
package Forms;

import Controllers.PhoneController;
import Model.Phone;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import javax.swing.ImageIcon;


public class PanelHome extends javax.swing.JPanel {

   private int quantityAvailableBill;
   
   
    public PanelHome() {
        PhoneController.init();
        initComponents();
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
        PanelBill.setSize(new Dimension(600 , 700));
        PanelBill.setLocation(400, 100);
        PanelBill.setVisible(false);
        addPanelProducts();
    }

   private void addPanelProducts() {

        this.PanelContainProduct.setLayout(new GridBagLayout());
        this.PanelContainProduct.removeAll();
        PhoneController.instance.loadDataProducts();

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
            var newJpanel = new PanelProduct(phone, this);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
            this.PanelContainProduct.add(newJpanel, gbc);
        }
        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }
   
   
   private int productIdCurrent;
   public void getTextBill(int productId, String name, String size, String price, String color, int quantityAvailable, ImageIcon imageIcon) {
        PanelBill.setVisible(true);
        ImageProductBill.setIcon(imageIcon);
        productIdCurrent = productId;
        txtBillColor.setText(name);
        txtBillPrice.setText(price);
        txtBillColor.setText(color);
        txtBillSize.setText(size);
        txtBillDate.setText(""+new java.sql.Date(new Date().getTime()));
        this.quantityAvailableBill = quantityAvailable;
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
        btnBuy3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnCanelBuy = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        ImageProductBill = new javax.swing.JLabel();
        txtBillColor = new javax.swing.JTextField();
        txtBillDate = new javax.swing.JTextField();
        txtBillName2 = new javax.swing.JTextField();
        txtBillSize = new javax.swing.JTextField();
        txtBillQuantity = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtBillPrice = new javax.swing.JTextField();
        PanelHomePage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainProduct = new javax.swing.JPanel();
        txtSearch = new Forms.Components.TextFieldController();

        jPanel2.setMaximumSize(new java.awt.Dimension(600, 700));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 700));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 700));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("CONFIRM BILL");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, 34));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Color");
        jLabel18.setToolTipText("");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Date");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 50, 30));

        btnBuy3.setBackground(new java.awt.Color(255, 0, 51));
        btnBuy3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuy3.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy3.setText("Buy it");
        btnBuy3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuy3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuy3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuy3MouseExited(evt);
            }
        });
        jPanel2.add(btnBuy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 110, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Size");
        jLabel20.setToolTipText("");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Quantity");
        jLabel21.setToolTipText("");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 30));

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
        jPanel2.add(btnCanelBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 110, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("Name");
        jLabel22.setToolTipText("");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        ImageProductBill.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        jPanel2.add(ImageProductBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 73, 210, 130));

        txtBillColor.setText("jTextField1");
        txtBillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillColorActionPerformed(evt);
            }
        });
        jPanel2.add(txtBillColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 167, 33));

        txtBillDate.setText("jTextField1");
        jPanel2.add(txtBillDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 167, 33));

        txtBillName2.setText("jTextField1");
        jPanel2.add(txtBillName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 167, 33));

        txtBillSize.setText("jTextField1");
        jPanel2.add(txtBillSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 167, 33));

        txtBillQuantity.setText("jTextField1");
        txtBillQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillQuantityActionPerformed(evt);
            }
        });
        jPanel2.add(txtBillQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 167, 33));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("Price ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 50, 30));

        txtBillPrice.setText("jTextField1");
        jPanel2.add(txtBillPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 167, 33));

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

        PanelHomePage.setPreferredSize(new java.awt.Dimension(1100, 720));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtSearch.setMinimumSize(new java.awt.Dimension(70, 40));
        txtSearch.setPreferredSize(new java.awt.Dimension(70, 40));

        javax.swing.GroupLayout PanelContainProductLayout = new javax.swing.GroupLayout(PanelContainProduct);
        PanelContainProduct.setLayout(PanelContainProductLayout);
        PanelContainProductLayout.setHorizontalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainProductLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1217, Short.MAX_VALUE))
        );
        PanelContainProductLayout.setVerticalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainProductLayout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1080, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(PanelContainProduct);

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuy3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuy3MouseClicked
//
//        try {
//
//            int quantity = Integer.parseInt(txtBillQuantity.getText().trim());
//            if (quantity > quantityAvailableBill || quantity < 0 || quantity == 0) {
//                JOptionPane.showMessageDialog(this, "Purchase quantity exceeds available stock!");
//                return;
//            }
//
//            float price = Float.parseFloat(txtBillPrice.getText().trim());
//            int size = Integer.parseInt(txtBillSize.getText().trim());
//            int check = JOptionPane.showConfirmDialog(this, "ARE YOU SURE WANT BUY IT ", "CONFIRM", JOptionPane.YES_NO_OPTION);
//            if (check == JOptionPane.YES_OPTION) {
//                if (BillController.instance.addBill(currentAccount.getUserId(), productIdCurrent, size, new java.sql.Date(new Date().getTime()), quantity, price)) {
//                    JOptionPane.showMessageDialog(this, "BUY SUCCESSFULLY");
//                    BillController.instance.loadBills(tbBill, currentAccount.getUserName());
//                    addPanelProducts();
//                    viewBill();
//                    return;
//                }
//            } else {
//                return;
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "ENTER A NUMBER NOT STRING", "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnBuy3MouseClicked

    private void btnBuy3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuy3MouseEntered
      //  btnBuy.setBackground(Color.GREEN);
    }//GEN-LAST:event_btnBuy3MouseEntered

    private void btnBuy3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuy3MouseExited
     //   btnBuy.setBackground(Color.RED);
    }//GEN-LAST:event_btnBuy3MouseExited

    private void btnCanelBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseClicked
      //  viewBill();
    }//GEN-LAST:event_btnCanelBuyMouseClicked

    private void btnCanelBuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseEntered
      //  btnCanelBuy.setBackground(Color.MAGENTA);
    }//GEN-LAST:event_btnCanelBuyMouseEntered

    private void btnCanelBuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCanelBuyMouseExited
      //  btnCanelBuy.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCanelBuyMouseExited

    private void txtBillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillColorActionPerformed

    private void txtBillQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageProductBill;
    private javax.swing.JDialog PanelBill;
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JButton btnBuy3;
    private javax.swing.JButton btnCanelBuy;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBillColor;
    private javax.swing.JTextField txtBillDate;
    private javax.swing.JTextField txtBillName2;
    private javax.swing.JTextField txtBillPrice;
    private javax.swing.JTextField txtBillQuantity;
    private javax.swing.JTextField txtBillSize;
    private Forms.Components.TextFieldController txtSearch;
    // End of variables declaration//GEN-END:variables
}
