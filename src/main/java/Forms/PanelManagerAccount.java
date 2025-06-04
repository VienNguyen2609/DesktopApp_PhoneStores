package Forms;

import Controllers.AccountController;
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

public class PanelManagerAccount extends javax.swing.JPanel {

    private int selectedRow;
    private int idUserText;
    private File selectedFile;
    private Icon icon;
    private byte[] imageUser = null;
    
    
    
    public PanelManagerAccount() {
        initComponents();
        AccountController.init();
        AccountController.instance.loadTableAccount(tbAccount);
        styleButton();
    }

    
    private void viewTabelAccount(){
        txtNameUser.setText("");
        txtPasswordUser.setText("");
        txtGmailUser.setText("");
        LabelImageUser.setIcon(null);
    }
    
    public void clickMouseTableAccount() {
        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow != -1) {
            String name = tbAccount.getValueAt(selectedRow, 2).toString();
            String Password = tbAccount.getValueAt(selectedRow, 3).toString();
            String gmail = tbAccount.getValueAt(selectedRow, 4).toString();
            byte[] image = (byte[]) tbAccount.getValueAt(selectedRow, 5);
//            LabelNameProduct.setForeground(Color.GREEN);
//            LabelSizeProduct.setForeground(Color.GREEN);
//            LabelPriceProduct.setForeground(Color.GREEN);
//            LabelQuantityProduct.setForeground(Color.GREEN);
//            LabelColorProduct.setForeground(Color.GREEN);
            txtNameUser.setText(name);
            txtPasswordUser.setText(Password);
            txtGmailUser.setText(gmail);
            if (image != null) {
                ImageIcon icon = new ImageIcon(image);
                LabelImageUser.setIcon(icon);
            } else {
                LabelImageUser.setIcon(null);
            }
        }
    }
    
    
    private void styleButton(){
        btnUpdateUser.setBackgroundColor(Color.ORANGE);
        btnAddUser.setBackgroundColor(Color.RED);
        btnDeleteUser.setBackgroundColor(Color.GREEN);
        btnCancelUser.setBackgroundColor(Color.BLUE);
        btnUploadAvatarUser.setBackgroundColor(Color.ORANGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnDeleteUser = new Forms.Components.HeaderButton();
        btnCancelUser = new Forms.Components.HeaderButton();
        btnUploadAvatarUser = new Forms.Components.HeaderButton();
        btnAddUser = new Forms.Components.HeaderButton();
        btnUpdateUser = new Forms.Components.HeaderButton();
        LabelGmailUser = new javax.swing.JLabel();
        LabelNameUser = new javax.swing.JLabel();
        txtGmailUser = new Forms.Components.TextFieldController();
        txtNameUser = new Forms.Components.TextFieldController();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        LabelImageUser = new Forms.Components.ProfilePhoto();
        txtPasswordUser = new Forms.Components.TextFieldController();
        jLabel23 = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAccount = new javax.swing.JTable();

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon1.png"))); // NOI18N
        btnDeleteUser.setText("Delete");
        btnDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteUserMouseClicked(evt);
            }
        });
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        jPanel4.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 130, 30));

        btnCancelUser.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelIcon.png"))); // NOI18N
        btnCancelUser.setText("Cancel");
        btnCancelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnCancelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 130, 30));

        btnUploadAvatarUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UploadImageIcon.png"))); // NOI18N
        btnUploadAvatarUser.setText("UploadImage");
        btnUploadAvatarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatarUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnUploadAvatarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, 30));

        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AddIcon.png"))); // NOI18N
        btnAddUser.setText("Add");
        btnAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 130, 30));

        btnUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateIcon.png"))); // NOI18N
        btnUpdateUser.setText("Update");
        btnUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateUserMouseClicked(evt);
            }
        });
        jPanel4.add(btnUpdateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 130, 30));

        LabelGmailUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelGmailUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelGmailUser.setText("Gmail");
        jPanel4.add(LabelGmailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 40, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("Name");
        jPanel4.add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        txtGmailUser.setForeground(new java.awt.Color(255, 255, 255));
        txtGmailUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGmailUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        jPanel4.add(txtGmailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 210, -1));

        txtNameUser.setForeground(new java.awt.Color(255, 255, 255));
        txtNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N
        jPanel4.add(txtNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 200, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("____________________________________");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 210, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("____________________________________");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 210, 30));

        LabelImageUser.setPreferredSize(new java.awt.Dimension(160, 130));
        jPanel4.add(LabelImageUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 170, 130));

        txtPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        txtPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPasswordUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N
        jPanel4.add(txtPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 200, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("____________________________________");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 210, 30));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("Password");
        jPanel4.add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 70, -1));

        tbAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbAccount.setForeground(new java.awt.Color(255, 255, 255));
        tbAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Id", "Name", "Password", "Email", "Avatar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAccount.setShowHorizontalLines(true);
        tbAccount.setShowVerticalLines(true);
        tbAccount.getTableHeader().setResizingAllowed(false);
        tbAccount.getTableHeader().setReorderingAllowed(false);
        tbAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAccountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAccount);
        if (tbAccount.getColumnModel().getColumnCount() > 0) {
            tbAccount.getColumnModel().getColumn(0).setResizable(false);
            tbAccount.getColumnModel().getColumn(1).setResizable(false);
            tbAccount.getColumnModel().getColumn(2).setResizable(false);
            tbAccount.getColumnModel().getColumn(3).setResizable(false);
            tbAccount.getColumnModel().getColumn(4).setResizable(false);
            tbAccount.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteUserMouseClicked

        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        idUserText = Integer.parseInt(tbAccount.getValueAt(selectedRow, 1).toString().trim());
        if (AccountController.instance.deleteAccount(idUserText)) {
            JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY ID:" + idUserText);
            viewTabelAccount();
            AccountController.instance.loadTableAccount(tbAccount);
        }
    }//GEN-LAST:event_btnDeleteUserMouseClicked

    private void btnCancelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelUserMouseClicked
        viewTabelAccount();
    }//GEN-LAST:event_btnCancelUserMouseClicked

    private void btnUploadAvatarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadAvatarUserMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                .getImage().getScaledInstance(LabelImageUser.getWidth(), LabelImageUser.getHeight(), Image.SCALE_SMOOTH));
            LabelImageUser.setIcon(icon);
            LabelImageUser.setBorder(null);
        }
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
            return;
        }
    }//GEN-LAST:event_btnUploadAvatarUserMouseClicked

    private void btnAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUserMouseClicked

        String name = txtNameUser.getText().trim();
        String pass = txtPasswordUser.getText().trim();
        String gamil = txtGmailUser.getText().trim();

        if (!AccountController.instance.checkAccount(name, pass, gamil)) {
            return;
        }
        if (selectedFile == null) {
            return;
        } else {
            try {
                imageUser = Files.readAllBytes(selectedFile.toPath());
            } catch (IOException ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (AccountController.instance.addAccount(name, pass, gamil, imageUser)) {
            JOptionPane.showMessageDialog(this, "ADDED ACCOUNT SUCCESSFULLY!");
            viewTabelAccount();
            AccountController.instance.loadTableAccount(tbAccount);
        }
    }//GEN-LAST:event_btnAddUserMouseClicked

    private void btnUpdateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateUserMouseClicked

        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        idUserText = Integer.parseInt(tbAccount.getValueAt(selectedRow, 1).toString().trim());
        String name = txtNameUser.getText().trim();
        String pass = txtPasswordUser.getText().trim();
        String gamil = txtGmailUser.getText().trim();
        if (!AccountController.instance.checkAccount(name, pass, gamil)) {
            return;
        }
        if (AccountController.instance.updateAccountManager(name, pass, gamil, idUserText)) {
            JOptionPane.showMessageDialog(this, "UPDATE SUCCESSFULLY ID USER:" + idUserText);
            viewTabelAccount();
            AccountController.instance.loadTableAccount(tbAccount);

        }
    }//GEN-LAST:event_btnUpdateUserMouseClicked

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void tbAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccountMouseClicked
        clickMouseTableAccount();
    }//GEN-LAST:event_tbAccountMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelGmailUser;
    private Forms.Components.ProfilePhoto LabelImageUser;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordUser;
    private Forms.Components.HeaderButton btnAddUser;
    private Forms.Components.HeaderButton btnCancelUser;
    private Forms.Components.HeaderButton btnDeleteUser;
    private Forms.Components.HeaderButton btnUpdateUser;
    private Forms.Components.HeaderButton btnUploadAvatarUser;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAccount;
    private Forms.Components.TextFieldController txtGmailUser;
    private Forms.Components.TextFieldController txtNameUser;
    private Forms.Components.TextFieldController txtPasswordUser;
    // End of variables declaration//GEN-END:variables
}
