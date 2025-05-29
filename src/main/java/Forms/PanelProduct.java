
package Forms;

import Model.Phone;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PanelProduct extends javax.swing.JPanel {

     private PanelHome panelHome;
    private int quantityAvailable;
    private int productIdCurrent;
    private ImageIcon icon;
    public PanelProduct(Phone phone, PanelHome panelHome) {
        initComponents();
        this.panelHome = panelHome;

        initComponents();
        productIdCurrent = phone.getPhoneId();
        txtName.setText(phone.getNamePhone());
        txtSize.setText(String.valueOf(phone.getBrandPhone()));
        txtPrice.setText(String.valueOf(phone.getPricePhone()));
        txtQuantity.setText(String.valueOf(phone.getQuantityPhone()));
        txtColor.setText(phone.getOperatingSystem());
        this.quantityAvailable = phone.getQuantityPhone();
        byte[] imageBytes = phone.getImagePhone();
        int defaultWidth = 201;
        int defaultHeight = 129;

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

        chkPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkPurchase.isSelected()) {
                    panelHome.getTextBill(productIdCurrent, txtName.getText(), txtSize.getText(), txtPrice.getText(), txtColor.getText(), quantityAvailable, icon);
                }
            }
        });
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtName = new Forms.Components.TextFieldController();
        chkPurchase = new javax.swing.JCheckBox();
        txtPrice = new Forms.Components.TextFieldController();
        txtColor = new Forms.Components.TextFieldController();
        jLabel1 = new javax.swing.JLabel();
        LabelImage = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txtQuantity = new Forms.Components.TextFieldController();
        jLabel72 = new javax.swing.JLabel();
        txtSize = new Forms.Components.TextFieldController();

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setText("Remaining:");
        jPanel16.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 80, 20));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setText("Color:");
        jPanel16.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 43, -1));

        txtName.setEditable(false);
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setToolTipText("");
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel16.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 7, 130, -1));

        chkPurchase.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkPurchase.setText("Purchase");
        chkPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkPurchaseMouseClicked(evt);
            }
        });
        jPanel16.add(chkPurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));

        txtPrice.setEditable(false);
        txtPrice.setForeground(new java.awt.Color(204, 255, 255));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel16.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 190, 30));

        txtColor.setEditable(false);
        txtColor.setForeground(new java.awt.Color(204, 255, 255));
        txtColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel16.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 200, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel16.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, 20));

        LabelImage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        jPanel16.add(LabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 45, 201, 129));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel71.setText("Size");
        jPanel16.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 43, 20));

        txtQuantity.setEditable(false);
        txtQuantity.setForeground(new java.awt.Color(204, 255, 255));
        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel16.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 80, 40));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setText("Price:");
        jPanel16.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 43, 20));

        txtSize.setEditable(false);
        txtSize.setForeground(new java.awt.Color(204, 255, 255));
        txtSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel16.add(txtSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkPurchaseMouseClicked

    }//GEN-LAST:event_chkPurchaseMouseClicked

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked

    }//GEN-LAST:event_jPanel16MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelImage;
    private javax.swing.JCheckBox chkPurchase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel16;
    private Forms.Components.TextFieldController txtColor;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtPrice;
    private Forms.Components.TextFieldController txtQuantity;
    private Forms.Components.TextFieldController txtSize;
    // End of variables declaration//GEN-END:variables
}
