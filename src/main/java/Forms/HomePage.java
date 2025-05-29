package Forms;

import Controllers.PhoneController;
import Forms.Components.EffectComponents;
import Model.Account;
import Model.Phone;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import javax.swing.Icon;

public class HomePage extends javax.swing.JFrame {

    private PanelAccount panelAccount;
    private PanelProduct panelProduct;
    private PanelHome panelHome;
    private Account currentAccount;

    private int quantityAvailableBill;
    private File selectedFile;
    private Icon icon;

    private String nameText;
    private String colorText;
    private String passwordText;
    private String gmailText;
    private float priceText;
    private int idProductText;
    private int sizeProductText;
    private int quantityText;
    private int selectedRow;
    private byte[] imageProduct = null;

    private byte[] imageUser = null;
    private int idUserText;

    private int status = 0;

    public HomePage() {
        initComponents();
        PhoneController.init();
        EffectComponents.init();
        panelAccount = new PanelAccount();
        panelHome = new PanelHome();
        this.jPanel2.add(panelAccount);
        this.jPanel2.add(panelHome);
        panelAccount.setVisible(false);
        panelHome.setVisible(true);
        this.jPanel2.revalidate();
        this.jPanel2.repaint();
        styleButton();
        setLocationRelativeTo(null);
//        EffectComponents.instance.scaleImage(jLabel3, "/Image/Header.png");
    }
    

    private void styleButton() {
//        btnUploadAvatar.setBackgroundColor(Color.ORANGE);
        btnProfle.setBackgroundColor(Color.GRAY);
        btnHomePage.setBackgroundColor(Color.GRAY);
        btnLogOut.setBackgroundColor(Color.GRAY);
        btnManagerAccounts.setBackgroundColor(Color.GRAY);
        btnManagerProducts.setBackgroundColor(Color.GRAY);
        btnUserBill.setBackgroundColor(Color.GRAY);
//        btnEditProfile.setBackgroundColor(Color.GREEN);
//        btnCancelProfile.setBackgroundColor(Color.lightGray);
//        btnSaveEditProfile.setBackgroundColor(Color.GREEN);
//        btnUploadImageProduct.setBackgroundColor(Color.ORANGE);
//        btnAddProduct.setBackgroundColor(Color.lightGray);
//        btnUpdateProduct.setBackgroundColor(Color.GREEN);
//        btnDeleteProduct.setBackgroundColor(Color.RED);
//        btnCancelProduct.setBackgroundColor(Color.BLUE);
//        btnUploadAvatarUser.setBackgroundColor(Color.ORANGE);
//        btnPushProductToHome.setBackgroundColor(Color.RED);
//        btnUpdateUser.setBackgroundColor(Color.ORANGE);
//        btnAddUser.setBackgroundColor(Color.RED);
//        btnDeleteUser.setBackgroundColor(Color.GREEN);
//        btnCancelUser.setBackgroundColor(Color.BLUE);
//        btnRefreshBill.setBackgroundColor(Color.RED);
//    btnSearch.setBackgroundColor(Color.LIGHT_GRAY);
//       btnSaveEditProfile.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnProfle = new Forms.Components.HeaderButton();
        btnHomePage = new Forms.Components.HeaderButton();
        btnLogOut = new Forms.Components.HeaderButton();
        btnUserBill = new Forms.Components.HeaderButton();
        btnManagerProducts = new Forms.Components.HeaderButton();
        btnManagerAccounts = new Forms.Components.HeaderButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        PanelHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        PanelHeader.setMinimumSize(new java.awt.Dimension(562, 80));
        PanelHeader.setPreferredSize(new java.awt.Dimension(1293, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Header.png"))); // NOI18N

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1492, Short.MAX_VALUE)
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, Short.MAX_VALUE)
        );

        jPanel1.add(PanelHeader, java.awt.BorderLayout.PAGE_START);

        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        PanelMenu.setOpaque(false);
        PanelMenu.setPreferredSize(new java.awt.Dimension(137, 720));
        PanelMenu.setRequestFocusEnabled(false);

        btnProfle.setForeground(new java.awt.Color(204, 255, 255));
        btnProfle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountIcon.png"))); // NOI18N
        btnProfle.setText("Profile");
        btnProfle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfleMouseClicked(evt);
            }
        });
        btnProfle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfleActionPerformed(evt);
            }
        });

        btnHomePage.setForeground(new java.awt.Color(204, 255, 255));
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeIcon.png"))); // NOI18N
        btnHomePage.setText("Home");
        btnHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomePageMouseClicked(evt);
            }
        });

        btnLogOut.setForeground(new java.awt.Color(204, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogOutIcon.png"))); // NOI18N
        btnLogOut.setText("Sign Out");
        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        btnUserBill.setForeground(new java.awt.Color(204, 255, 255));
        btnUserBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BillIcon.png"))); // NOI18N
        btnUserBill.setText("Bill");
        btnUserBill.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUserBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUserBill.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUserBill.setIconTextGap(5);
        btnUserBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserBillMouseClicked(evt);
            }
        });

        btnManagerProducts.setForeground(new java.awt.Color(204, 255, 255));
        btnManagerProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductManagerIcon.png"))); // NOI18N
        btnManagerProducts.setText("Products");
        btnManagerProducts.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnManagerProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagerProductsMouseClicked(evt);
            }
        });
        btnManagerProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerProductsActionPerformed(evt);
            }
        });

        btnManagerAccounts.setForeground(new java.awt.Color(204, 255, 255));
        btnManagerAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountManagerIcon.png"))); // NOI18N
        btnManagerAccounts.setText("Accounts");
        btnManagerAccounts.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnManagerAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagerAccountsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUserBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManagerProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManagerAccounts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnUserBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnManagerProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnManagerAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(btnProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("© PRIMAMOBILES 2025. Redistribution or reproduction is strictly prohibited. ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.CardLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfleMouseClicked
//        PanelProfile.setVisible(true);
//        PanelHomePage.setVisible(false);
//        PanelBill.setVisible(false);
//        PanelProducts.setVisible(false);
//        PanelAccount.setVisible(false);
    }//GEN-LAST:event_btnProfleMouseClicked

    private void btnProfleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfleActionPerformed

//        if (!PanelProfile.isVisible()) {
//            txtPasswordProfile.setEchoChar('*');
//            CheckPassword.setSelected(false);
//        }
    }//GEN-LAST:event_btnProfleActionPerformed

    private void btnHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseClicked
//        PanelProfile.setVisible(false);
//        PanelHomePage.setVisible(true);
//        PanelBill.setVisible(false);
//        PanelProducts.setVisible(false);
//        PanelAccount.setVisible(false);
        panelHome.setVisible(true);
        panelAccount.setVisible(false);
    }//GEN-LAST:event_btnHomePageMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked

//        if (status == 1) {
//            Run.runApp();
//            dispose();
//        } else {
//            RunAdmin.runApp();
//            dispose();
//        }
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnUserBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserBillMouseClicked
//        PanelBill.setVisible(true);
//        PanelHomePage.setVisible(false);
//        PanelProfile.setVisible(false);
//          panelHome.setVisible(false);
//          panelAccount.setVisible(true);
    }//GEN-LAST:event_btnUserBillMouseClicked

    private void btnManagerProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerProductsMouseClicked
//        PanelBill.setVisible(false);
//        PanelHomePage.setVisible(false);
//        PanelProfile.setVisible(false);
//        PanelProducts.setVisible(true);
//        PanelAccount.setVisible(false);
    }//GEN-LAST:event_btnManagerProductsMouseClicked

    private void btnManagerProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagerProductsActionPerformed

    private void btnManagerAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerAccountsMouseClicked
//        PanelBill.setVisible(false);
//        PanelHomePage.setVisible(false);
//        PanelProfile.setVisible(false);
//        PanelProducts.setVisible(false);
//        PanelAccount.setVisible(true);
        panelHome.setVisible(false);
        panelAccount.setVisible(true);
    }//GEN-LAST:event_btnManagerAccountsMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelMenu;
    private Forms.Components.HeaderButton btnHomePage;
    private Forms.Components.HeaderButton btnLogOut;
    private Forms.Components.HeaderButton btnManagerAccounts;
    private Forms.Components.HeaderButton btnManagerProducts;
    private Forms.Components.HeaderButton btnProfle;
    private Forms.Components.HeaderButton btnUserBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
