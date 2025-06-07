package Forms;

import Controllers.StafftController;
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

public class PanelManagerStaff extends javax.swing.JPanel {

    private int selectedRow;
    private int idUserText;
    private File selectedFile;
    private Icon icon;
    private byte[] imageUser = null;
    private boolean statusStaff;
    private String statusStaffText;

    public PanelManagerStaff() {
        initComponents();
        StafftController.init();
        StafftController.instance.loadTableAccount(tbAccount);
        styleButton();
    }

    private void viewTabelAccount() {
        txtName.setText("");
        txtPassword.setText("");
        txtGmail.setText("");
        txtPosition.setText("");
        LabelImageUser.setIcon(null);
    }

    public void clickMouseTableAccount() {
        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow != -1) {
            String name = tbAccount.getValueAt(selectedRow, 2).toString();
            String Password = tbAccount.getValueAt(selectedRow, 3).toString();
            String gmail = tbAccount.getValueAt(selectedRow, 4).toString();
            String position = "";

            if (tbAccount.getValueAt(selectedRow, 5).toString().isEmpty()) {
                position = "No Positon";
            } else {
                position = tbAccount.getValueAt(selectedRow, 5).toString();
            }
            String _status = tbAccount.getValueAt(selectedRow, 6).toString();
            byte[] image = (byte[]) tbAccount.getValueAt(selectedRow, 7);
//            LabelNameProduct.setForeground(Color.GREEN);
//            LabelSizeProduct.setForeground(Color.GREEN);
//            LabelPriceProduct.setForeground(Color.GREEN);
//            LabelQuantityProduct.setForeground(Color.GREEN);
//            LabelColorProduct.setForeground(Color.GREEN);
            txtName.setText(name);
            txtPassword.setText(Password);
            txtGmail.setText(gmail);
            txtPosition.setText(position);
            if (image != null) {
                ImageIcon icon = new ImageIcon(image);
                LabelImageUser.setIcon(icon);
            } else {
                LabelImageUser.setIcon(null);
            }

            if (_status.equalsIgnoreCase("Active")) {
                cbStatusStaff.setSelectedIndex(0);
            } else {
                cbStatusStaff.setSelectedIndex(1);
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
        txtGmail = new Forms.Components.TextFieldController();
        txtName = new Forms.Components.TextFieldController();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        LabelImageUser = new Forms.Components.ProfilePhoto();
        txtPassword = new Forms.Components.TextFieldController();
        btnDeleteUser = new Forms.Components.HeaderButton();
        jLabel23 = new javax.swing.JLabel();
        btnCancelUser = new Forms.Components.HeaderButton();
        LabelPasswordUser = new javax.swing.JLabel();
        btnUploadAvatarUser = new Forms.Components.HeaderButton();
        btnAddUser = new Forms.Components.HeaderButton();
        btnUpdateUser = new Forms.Components.HeaderButton();
        LabelName = new javax.swing.JLabel();
        LabelPasswordUser2 = new javax.swing.JLabel();
        txtPosition = new Forms.Components.TextFieldController();
        jLabel21 = new javax.swing.JLabel();
        LabelPasswordUser3 = new javax.swing.JLabel();
        LabelSizeProduct = new javax.swing.JLabel();
        cbStatusStaff = new javax.swing.JComboBox<>();

        tbAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbAccount.setForeground(new java.awt.Color(255, 255, 255));
        tbAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Id", "Name", "Password", "Email", "Position", "Status", "Avatar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class
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
            tbAccount.getColumnModel().getColumn(0).setMinWidth(40);
            tbAccount.getColumnModel().getColumn(0).setMaxWidth(40);
            tbAccount.getColumnModel().getColumn(1).setMinWidth(40);
            tbAccount.getColumnModel().getColumn(1).setMaxWidth(40);
            tbAccount.getColumnModel().getColumn(2).setResizable(false);
            tbAccount.getColumnModel().getColumn(3).setResizable(false);
            tbAccount.getColumnModel().getColumn(4).setResizable(false);
            tbAccount.getColumnModel().getColumn(5).setResizable(false);
            tbAccount.getColumnModel().getColumn(6).setResizable(false);
            tbAccount.getColumnModel().getColumn(7).setResizable(false);
        }

        txtGmail.setForeground(new java.awt.Color(255, 255, 255));
        txtGmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGmail.setMaximumSize(new java.awt.Dimension(90, 28));
        txtGmail.setMinimumSize(new java.awt.Dimension(40, 28));
        txtGmail.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setMaximumSize(new java.awt.Dimension(100, 28));
        txtName.setMinimumSize(new java.awt.Dimension(40, 28));
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("____________________________________");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("____________________________________");

        LabelImageUser.setMaximumSize(new java.awt.Dimension(200, 150));
        LabelImageUser.setMinimumSize(new java.awt.Dimension(100, 90));
        LabelImageUser.setPreferredSize(new java.awt.Dimension(160, 130));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPassword.setMaximumSize(new java.awt.Dimension(100, 28));
        txtPassword.setMinimumSize(new java.awt.Dimension(40, 28));
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N

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

        LabelName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelName.setForeground(new java.awt.Color(255, 255, 255));
        LabelName.setText("Name");

        LabelPasswordUser2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser2.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser2.setText("Gmail");

        txtPosition.setForeground(new java.awt.Color(255, 255, 255));
        txtPosition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPosition.setMaximumSize(new java.awt.Dimension(90, 28));
        txtPosition.setMinimumSize(new java.awt.Dimension(40, 28));
        txtPosition.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/positionIcon.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("____________________________________");

        LabelPasswordUser3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser3.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser3.setText("Position");

        LabelSizeProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSizeProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelSizeProduct.setText("Status Staff");

        cbStatusStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Discontinued" }));
        cbStatusStaff.setMaximumSize(new java.awt.Dimension(230, 30));
        cbStatusStaff.setMinimumSize(new java.awt.Dimension(50, 22));
        cbStatusStaff.setPreferredSize(new java.awt.Dimension(110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(65, 65, 65))
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LabelPasswordUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelPasswordUser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(btnUploadAvatarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelPasswordUser3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelSizeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbStatusStaff, 0, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(154, 154, 154))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(LabelImageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(LabelImageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUploadAvatarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(LabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(LabelPasswordUser)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(LabelPasswordUser2)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addComponent(LabelPasswordUser3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelSizeProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatusStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
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
        if (StafftController.instance.deleteAccount(idUserText)) {
            JOptionPane.showMessageDialog(this, "DELETED SUCCESSFULLY ID:" + idUserText);
            viewTabelAccount();
            StafftController.instance.loadTableAccount(tbAccount);
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

        String name = txtName.getText().trim();
        String pass = txtPassword.getText().trim();
        String gamil = txtGmail.getText().trim();
        String position = txtPosition.getText().trim();
        if (!StafftController.instance.checkAccount(name, pass, gamil)) {
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
        if (position.length() != 0) {
            if (StafftController.instance.addAccount(name, pass, gamil, position, imageUser)) {
                JOptionPane.showMessageDialog(this, "ADDED ACCOUNT SUCCESSFULLY!");
                viewTabelAccount();
                StafftController.instance.loadTableAccount(tbAccount);
            }
        } else {
            if (StafftController.instance.addAccount(name, pass, gamil, "No position", imageUser)) {
                JOptionPane.showMessageDialog(this, "ADDED ACCOUNT SUCCESSFULLY!");
                viewTabelAccount();
                StafftController.instance.loadTableAccount(tbAccount);
            }
        }
    }//GEN-LAST:event_btnAddUserMouseClicked

    private void btnUpdateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateUserMouseClicked

        statusStaffText = cbStatusStaff.getSelectedItem().toString();
        statusStaff = statusStaffText.equalsIgnoreCase("Active");

        selectedRow = tbAccount.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table first!");
            return;
        }
        idUserText = Integer.parseInt(tbAccount.getValueAt(selectedRow, 1).toString().trim());
        String name = txtName.getText().trim();
        String pass = txtPassword.getText().trim();
        String gamil = txtGmail.getText().trim();
        String position = txtPosition.getText().trim();
        if (!StafftController.instance.checkAccount(name, pass, gamil)) {
            return;
        }
        if (StafftController.instance.updateAccountManager(name, pass, gamil, position, statusStaff, idUserText)) {
            JOptionPane.showMessageDialog(this, "UPDATE SUCCESSFULLY ID USER:" + idUserText);
            viewTabelAccount();
            StafftController.instance.loadTableAccount(tbAccount);

        }
        else{
             JOptionPane.showMessageDialog(this, "CAN NOT UPDATE");
        }
    }//GEN-LAST:event_btnUpdateUserMouseClicked

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        if (!txtName.getText().trim().isEmpty()) {
            LabelName.setForeground(Color.GREEN);
        } else {
            LabelName.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtNameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.Components.ProfilePhoto LabelImageUser;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LabelPasswordUser2;
    private javax.swing.JLabel LabelPasswordUser3;
    private javax.swing.JLabel LabelSizeProduct;
    private Forms.Components.HeaderButton btnAddUser;
    private Forms.Components.HeaderButton btnCancelUser;
    private Forms.Components.HeaderButton btnDeleteUser;
    private Forms.Components.HeaderButton btnUpdateUser;
    private Forms.Components.HeaderButton btnUploadAvatarUser;
    private javax.swing.JComboBox<String> cbStatusStaff;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAccount;
    private Forms.Components.TextFieldController txtGmail;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtPassword;
    private Forms.Components.TextFieldController txtPosition;
    // End of variables declaration//GEN-END:variables
}
