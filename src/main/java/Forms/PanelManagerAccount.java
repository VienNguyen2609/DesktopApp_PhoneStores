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

    private void viewTabelAccount() {
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

    private void styleButton() {
        btnUpdateUser.setBackgroundColor(Color.ORANGE);
        btnAddUser.setBackgroundColor(Color.RED);
        btnDeleteUser.setBackgroundColor(Color.GREEN);
        btnCancelUser.setBackgroundColor(Color.BLUE);
        btnUploadAvatarUser.setBackgroundColor(Color.ORANGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAccount = new javax.swing.JTable();
        txtGmailUser = new Forms.Components.TextFieldController();
        txtNameUser = new Forms.Components.TextFieldController();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        LabelImageUser = new Forms.Components.ProfilePhoto();
        txtPasswordUser = new Forms.Components.TextFieldController();
        btnDeleteUser = new Forms.Components.HeaderButton();
        jLabel23 = new javax.swing.JLabel();
        btnCancelUser = new Forms.Components.HeaderButton();
        LabelPasswordUser = new javax.swing.JLabel();
        btnUploadAvatarUser = new Forms.Components.HeaderButton();
        btnAddUser = new Forms.Components.HeaderButton();
        btnUpdateUser = new Forms.Components.HeaderButton();
        LabelPasswordUser1 = new javax.swing.JLabel();
        LabelPasswordUser2 = new javax.swing.JLabel();

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

        txtGmailUser.setForeground(new java.awt.Color(255, 255, 255));
        txtGmailUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGmailUser.setMaximumSize(new java.awt.Dimension(90, 28));
        txtGmailUser.setMinimumSize(new java.awt.Dimension(40, 28));
        txtGmailUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N

        txtNameUser.setForeground(new java.awt.Color(255, 255, 255));
        txtNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameUser.setMaximumSize(new java.awt.Dimension(100, 28));
        txtNameUser.setMinimumSize(new java.awt.Dimension(40, 28));
        txtNameUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("____________________________________");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("____________________________________");

        LabelImageUser.setMaximumSize(new java.awt.Dimension(200, 150));
        LabelImageUser.setMinimumSize(new java.awt.Dimension(100, 90));
        LabelImageUser.setPreferredSize(new java.awt.Dimension(160, 130));

        txtPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        txtPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPasswordUser.setMaximumSize(new java.awt.Dimension(100, 28));
        txtPasswordUser.setMinimumSize(new java.awt.Dimension(40, 28));
        txtPasswordUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N

        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon1.png"))); // NOI18N
        btnDeleteUser.setText("Delete");
        btnDeleteUser.setMaximumSize(new java.awt.Dimension(90, 40));
        btnDeleteUser.setMinimumSize(new java.awt.Dimension(30, 40));
        btnDeleteUser.setPreferredSize(new java.awt.Dimension(50, 40));
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

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("____________________________________");

        btnCancelUser.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelIcon.png"))); // NOI18N
        btnCancelUser.setText("Cancel");
        btnCancelUser.setMaximumSize(new java.awt.Dimension(90, 40));
        btnCancelUser.setMinimumSize(new java.awt.Dimension(30, 40));
        btnCancelUser.setPreferredSize(new java.awt.Dimension(50, 40));
        btnCancelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelUserMouseClicked(evt);
            }
        });

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("Password");

        btnUploadAvatarUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UploadImageIcon.png"))); // NOI18N
        btnUploadAvatarUser.setText("UploadImage");
        btnUploadAvatarUser.setMaximumSize(new java.awt.Dimension(120, 38));
        btnUploadAvatarUser.setMinimumSize(new java.awt.Dimension(60, 38));
        btnUploadAvatarUser.setPreferredSize(new java.awt.Dimension(180, 30));
        btnUploadAvatarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatarUserMouseClicked(evt);
            }
        });
        btnUploadAvatarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadAvatarUserActionPerformed(evt);
            }
        });

        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AddIcon.png"))); // NOI18N
        btnAddUser.setText("Add");
        btnAddUser.setMaximumSize(new java.awt.Dimension(10, 40));
        btnAddUser.setMinimumSize(new java.awt.Dimension(5, 40));
        btnAddUser.setPreferredSize(new java.awt.Dimension(7, 40));
        btnAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddUserMouseClicked(evt);
            }
        });

        btnUpdateUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateIcon.png"))); // NOI18N
        btnUpdateUser.setText("Update");
        btnUpdateUser.setMaximumSize(new java.awt.Dimension(90, 40));
        btnUpdateUser.setMinimumSize(new java.awt.Dimension(30, 40));
        btnUpdateUser.setPreferredSize(new java.awt.Dimension(50, 40));
        btnUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateUserMouseClicked(evt);
            }
        });

        LabelPasswordUser1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser1.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser1.setText("Name");

        LabelPasswordUser2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser2.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser2.setText("Gmail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelPasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPasswordUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPasswordUser2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPasswordUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGmailUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(59, 59, 59)))
                        .addGap(141, 141, 141))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnUploadAvatarUser, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(LabelImageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(77, 77, 77)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LabelImageUser, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUploadAvatarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelPasswordUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(LabelPasswordUser)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(LabelPasswordUser2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGmailUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccountMouseClicked
        clickMouseTableAccount();
    }//GEN-LAST:event_tbAccountMouseClicked

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

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteUserActionPerformed

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

    private void btnUploadAvatarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadAvatarUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUploadAvatarUserActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.Components.ProfilePhoto LabelImageUser;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LabelPasswordUser1;
    private javax.swing.JLabel LabelPasswordUser2;
    private Forms.Components.HeaderButton btnAddUser;
    private Forms.Components.HeaderButton btnCancelUser;
    private Forms.Components.HeaderButton btnDeleteUser;
    private Forms.Components.HeaderButton btnUpdateUser;
    private Forms.Components.HeaderButton btnUploadAvatarUser;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAccount;
    private Forms.Components.TextFieldController txtGmailUser;
    private Forms.Components.TextFieldController txtNameUser;
    private Forms.Components.TextFieldController txtPasswordUser;
    // End of variables declaration//GEN-END:variables
}
