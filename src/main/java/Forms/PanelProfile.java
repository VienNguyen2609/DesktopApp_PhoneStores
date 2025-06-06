package Forms;

import Controllers.StafftController;
import Forms.Components.RoundedBorder;
import Forms.Components.RoundedPanel;
import Model.Staff;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author VIEN
 */
public class PanelProfile extends javax.swing.JPanel {

    private JLabel label;
    private Staff account;
    private File selectedFile;
    private Icon icon;
    private Staff currentAccount;
    private int statusStaff  = 0 ; 
    
    public PanelProfile(Staff account) {
        initComponents();
        this.account = account;
        currentAccount = account;
        RoundedPanel panel = new RoundedPanel(200, Color.BLUE);
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        panel.setBounds(20, 20, 300, 200);
        panel.setLocation(0, 15);

        label = new JLabel("PROFILE");
        label.setFont(new Font("Arial", Font.BOLD, 23));
        label.setBounds(100, 60, 100, 70);
        label.setForeground(Color.BLACK);
        panel.add(label);
        add(panel);
        txtName.setCustomBorder(new RoundedBorder(20, Color.BLACK));
        txtPass.setCustomBorder(new RoundedBorder(20, Color.BLACK));
        txtGmail.setCustomBorder(new RoundedBorder(20, Color.BLACK));
        txtPass.setBackground(null);
        txtName.setText(account.getName());
        txtPass.setText(account.getPassword());
        txtGmail.setText(account.getEmail());

        txtName1.setCustomBorder(new RoundedBorder(20, Color.WHITE));
        txtPass1.setCustomBorder(new RoundedBorder(20, Color.WHITE));
        txtGmail1.setCustomBorder(new RoundedBorder(20, Color.WHITE));
        txtPass1.setBackground(null);
        txtName1.setText(account.getName());
        txtPass1.setText(account.getPassword());
        txtGmail1.setText(account.getEmail());

        setAvatar(account.getAvatar());
        btnUploadAvatar2.setForeground(new Color(0, 0, 0));
        btnEditProfile.setForeground(new Color(0, 0, 0));

        btnSave.setForeground(new Color(0, 0, 0));
        btnCancel.setForeground(new Color(0, 0, 0));
        dEdit.setSize(new Dimension(700, 508));
        dEdit.setLocation(400, 100);
        dEdit.setTitle("EDIT YOUR PROFILE");
        dEdit.setVisible(false);
        dEdit.setResizable(false);
        
        if(currentAccount.getName().equalsIgnoreCase("admin")){
            statusStaff = 1 ;
        }
    }

    private void setAvatar(byte[] avatarBytes) {

        if (avatarBytes != null) {
            ImageIcon icon = new ImageIcon(avatarBytes);
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            LabelAvatar5.setIcon(new ImageIcon(img));
        }
        if (avatarBytes == null) {
            LabelAvatar5.setIcon(new ImageIcon(getClass().getResource("/Image/cat.png")));
        }
        LabelAvatar5.setBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dEdit = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtName1 = new Forms.Components.TextFieldController();
        jLabel6 = new javax.swing.JLabel();
        txtGmail1 = new Forms.Components.TextFieldController();
        jLabel7 = new javax.swing.JLabel();
        btnSave = new Forms.Components.HeaderButton();
        btnCancel = new Forms.Components.HeaderButton();
        txtPass1 = new Forms.Components.TextFieldController();
        LabelAvatar5 = new Forms.Components.ProfilePhoto();
        txtName = new Forms.Components.TextFieldController();
        jLabel1 = new javax.swing.JLabel();
        txtGmail = new Forms.Components.TextFieldController();
        txtPass = new Forms.Components.PasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUploadAvatar2 = new Forms.Components.HeaderButton();
        cbPassword = new javax.swing.JCheckBox();
        btnEditProfile = new Forms.Components.HeaderButton();
        txtPosition = new Forms.Components.TextFieldController();
        jLabel4 = new javax.swing.JLabel();

        dEdit.setBackground(new java.awt.Color(204, 204, 204));
        dEdit.setModal(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gmail");

        txtName1.setForeground(new java.awt.Color(255, 255, 255));
        txtName1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtName1.setMaximumSize(new java.awt.Dimension(90, 33));
        txtName1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name ");

        txtGmail1.setForeground(new java.awt.Color(255, 255, 255));
        txtGmail1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtGmail1.setMaximumSize(new java.awt.Dimension(90, 33));
        txtGmail1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        txtGmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGmail1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");

        btnSave.setBackground(new java.awt.Color(153, 153, 255));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/saveIcon.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMaximumSize(new java.awt.Dimension(70, 38));
        btnSave.setMinimumSize(new java.awt.Dimension(40, 38));
        btnSave.setPreferredSize(new java.awt.Dimension(60, 38));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(153, 153, 255));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelIcon.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setMaximumSize(new java.awt.Dimension(70, 38));
        btnCancel.setMinimumSize(new java.awt.Dimension(40, 38));
        btnCancel.setPreferredSize(new java.awt.Dimension(60, 38));
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        txtPass1.setForeground(new java.awt.Color(255, 255, 255));
        txtPass1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtPass1.setMaximumSize(new java.awt.Dimension(90, 33));
        txtPass1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 214, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout dEditLayout = new javax.swing.GroupLayout(dEdit.getContentPane());
        dEdit.getContentPane().setLayout(dEditLayout);
        dEditLayout.setHorizontalGroup(
            dEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dEditLayout.setVerticalGroup(
            dEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 204));

        LabelAvatar5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LabelAvatar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cat.png"))); // NOI18N
        LabelAvatar5.setMaximumSize(new java.awt.Dimension(230, 230));
        LabelAvatar5.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout LabelAvatar5Layout = new javax.swing.GroupLayout(LabelAvatar5);
        LabelAvatar5.setLayout(LabelAvatar5Layout);
        LabelAvatar5Layout.setHorizontalGroup(
            LabelAvatar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 239, Short.MAX_VALUE)
        );
        LabelAvatar5Layout.setVerticalGroup(
            LabelAvatar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtName.setEditable(false);
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtName.setMaximumSize(new java.awt.Dimension(90, 33));
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name ");

        txtGmail.setEditable(false);
        txtGmail.setForeground(new java.awt.Color(255, 255, 255));
        txtGmail.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtGmail.setMaximumSize(new java.awt.Dimension(90, 33));
        txtGmail.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N
        txtGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGmailActionPerformed(evt);
            }
        });

        txtPass.setEditable(false);
        txtPass.setBackground(new java.awt.Color(0, 0, 0));
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setText("passwordField1");
        txtPass.setEchoChar('\u002A');
        txtPass.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtPass.setMaximumSize(new java.awt.Dimension(90, 33));
        txtPass.setMinimumSize(new java.awt.Dimension(64, 35));
        txtPass.setOpaque(true);
        txtPass.setPreferredSize(new java.awt.Dimension(64, 35));
        txtPass.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gmail");

        btnUploadAvatar2.setBackground(new java.awt.Color(153, 153, 255));
        btnUploadAvatar2.setForeground(new java.awt.Color(255, 255, 255));
        btnUploadAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UploadImageIcon.png"))); // NOI18N
        btnUploadAvatar2.setText("Upload Avatar");
        btnUploadAvatar2.setMaximumSize(new java.awt.Dimension(70, 38));
        btnUploadAvatar2.setMinimumSize(new java.awt.Dimension(40, 38));
        btnUploadAvatar2.setPreferredSize(new java.awt.Dimension(60, 38));
        btnUploadAvatar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadAvatar2MouseClicked(evt);
            }
        });

        cbPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbPassword.setForeground(new java.awt.Color(255, 255, 255));
        cbPassword.setText("Show Password");
        cbPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPasswordMouseClicked(evt);
            }
        });

        btnEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/EditProfileIcon.png"))); // NOI18N
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditProfileMouseClicked(evt);
            }
        });

        txtPosition.setEditable(false);
        txtPosition.setForeground(new java.awt.Color(255, 255, 255));
        txtPosition.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtPosition.setMaximumSize(new java.awt.Dimension(90, 33));
        txtPosition.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/positionIcon.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Positon");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(LabelAvatar5, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnUploadAvatar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(162, 162, 162)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                        .addGap(440, 440, 440))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addGap(477, 477, 477))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(txtGmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPassword)
                        .addGap(306, 306, 306))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(LabelAvatar5, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPassword))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUploadAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailActionPerformed

    private void btnUploadAvatar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadAvatar2MouseClicked

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath())
                    .getImage().getScaledInstance(LabelAvatar5.getWidth(), LabelAvatar5.getHeight(), Image.SCALE_SMOOTH));
            LabelAvatar5.setIcon(icon);
        }

        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "PHOTO NOT UPDATE YET!");
            return;
        }
        StafftController.instance.saveAvatarToDatabase(selectedFile, currentAccount.getName());

    }//GEN-LAST:event_btnUploadAvatar2MouseClicked

    private void cbPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPasswordMouseClicked
        if (cbPassword.isSelected()) {
            txtPass.setEchoChar((char) 0);
        } else {
            txtPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbPasswordMouseClicked

    private void btnEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditProfileMouseClicked
        dEdit.setVisible(true);
    }//GEN-LAST:event_btnEditProfileMouseClicked

    private void txtGmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmail1ActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked

        String name = txtName1.getText().trim();
        String password = txtPass1.getText().trim();
        String gmail = txtGmail1.getText().trim();
        
        StafftController.instance.loadDataAccounts();
        try {

            if (!StafftController.instance.checkAccountIsAdmin(name, password, gmail , statusStaff)) {
                return;
            }

            Staff UpdateAccount = StafftController.instance.updateAccount(name, password, gmail, currentAccount.getName());
            if (UpdateAccount != null) {
                currentAccount = UpdateAccount;
                JOptionPane.showMessageDialog(this, "Profile Updated Successfully");
                return;

            } else {
                JOptionPane.showMessageDialog(this, "Update name false");
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.Components.ProfilePhoto LabelAvatar5;
    private Forms.Components.HeaderButton btnCancel;
    private Forms.Components.HeaderButton btnEditProfile;
    private Forms.Components.HeaderButton btnSave;
    private Forms.Components.HeaderButton btnUploadAvatar2;
    private javax.swing.JCheckBox cbPassword;
    private javax.swing.JDialog dEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private Forms.Components.TextFieldController txtGmail;
    private Forms.Components.TextFieldController txtGmail1;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.TextFieldController txtName1;
    private Forms.Components.PasswordField txtPass;
    private Forms.Components.TextFieldController txtPass1;
    private Forms.Components.TextFieldController txtPosition;
    // End of variables declaration//GEN-END:variables
}
