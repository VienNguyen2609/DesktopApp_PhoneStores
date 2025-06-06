package Forms;

import Controllers.PhoneController;
import Forms.Components.EffectComponents;
import Main.Run;
import Model.Staff;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {

    private PanelManagerAccount panelManagerAccount;
    private PanelPhone panelPhone;
    private PanelHome panelHome;
    private PanelManagerPhone panelManagerPhone;
    private PanelManagerBill panelManagerBill;
    private PanelProfile panelProfile;
    
    private Staff currentAccount;

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
    }

    public HomePage(Staff staff ){
        initComponents();
        PhoneController.init();
        EffectComponents.init();
        this.currentAccount = staff;

        panelManagerAccount = new PanelManagerAccount();
        panelPhone = new PanelPhone(currentAccount);

        // TẠM thời gán null
        panelManagerBill = new PanelManagerBill(panelPhone, staff, null );
        panelHome = new PanelHome(currentAccount, panelManagerBill , null);

        // GÁN lại panelHome cho panelManagerBill
        panelManagerBill.setPanelHome(panelHome);
        panelManagerPhone = new PanelManagerPhone(panelHome);
        panelProfile = new PanelProfile(staff);
       
        panelHome.setPanelManagerPhone(panelManagerPhone);
        
        if ("admin".equalsIgnoreCase(staff.getPosition())) {

            this.jPanel2.add(panelManagerAccount);
            this.jPanel2.add(panelProfile);
            this.jPanel2.add(panelManagerBill);
            this.jPanel2.add(panelManagerPhone);
            this.jPanel2.add(panelHome);
        } else {
            this.jPanel2.add(panelProfile);
            this.jPanel2.add(panelManagerBill);
            this.jPanel2.add(panelHome);
            this.jPanel2.add(panelManagerPhone);
            btnMenuPhone.setVisible(true);
            btnMenuAccount.setVisible(false);
        }
        panelProfile.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelHome.setVisible(true);

        this.jPanel2.revalidate();
        this.jPanel2.repaint();

        styleButton();
        setupWindow();
        EffectComponents.instance.scaleImage(jLabel2, "/Image/LogoShopIcon.png");

    }

    private void styleButton() {
//        btnUploadAvatar.setBackgroundColor(Color.ORANGE);
        btnProfle.setBackgroundColor(Color.GRAY);
        btnHomePage.setForeground(new Color(0, 0, 0));
        btnHomePage.setBackgroundColor(new Color(204, 255, 255));
        btnLogOut.setBackgroundColor(Color.GRAY);
        btnMenuAccount.setBackgroundColor(Color.GRAY);
        btnMenuPhone.setBackgroundColor(Color.GRAY);
        btnMenuBill.setBackgroundColor(Color.GRAY);
    }

    private void setupWindow() {
        setLocationRelativeTo(null);
        setTitle("PRIMA MOBILES ,  SHOP FOR YOU ");
        String iconPath = "E:\\Image\\LogoShopIcon.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnProfle = new Forms.Components.HeaderButton();
        btnHomePage = new Forms.Components.HeaderButton();
        btnLogOut = new Forms.Components.HeaderButton();
        btnMenuBill = new Forms.Components.HeaderButton();
        btnMenuPhone = new Forms.Components.HeaderButton();
        btnMenuAccount = new Forms.Components.HeaderButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        PanelHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        PanelHeader.setMinimumSize(new java.awt.Dimension(562, 80));
        PanelHeader.setPreferredSize(new java.awt.Dimension(1293, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Header.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(1700, 140));
        jLabel3.setMinimumSize(new java.awt.Dimension(1550, 130));

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1363, Short.MAX_VALUE))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(PanelHeader, java.awt.BorderLayout.PAGE_START);

        PanelMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        PanelMenu.setOpaque(false);
        PanelMenu.setPreferredSize(new java.awt.Dimension(137, 720));
        PanelMenu.setRequestFocusEnabled(false);

        btnProfle.setForeground(new java.awt.Color(204, 204, 204));
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

        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeIcon.png"))); // NOI18N
        btnHomePage.setText("Home");
        btnHomePage.setVerifyInputWhenFocusTarget(false);
        btnHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomePageMouseClicked(evt);
            }
        });

        btnLogOut.setForeground(new java.awt.Color(204, 204, 204));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogOutIcon.png"))); // NOI18N
        btnLogOut.setText("Sign Out");
        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        btnMenuBill.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BillIcon.png"))); // NOI18N
        btnMenuBill.setText("  Bill");
        btnMenuBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuBill.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMenuBill.setIconTextGap(5);
        btnMenuBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuBillMouseClicked(evt);
            }
        });

        btnMenuPhone.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductManagerIcon.png"))); // NOI18N
        btnMenuPhone.setText("Products");
        btnMenuPhone.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMenuPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuPhoneMouseClicked(evt);
            }
        });

        btnMenuAccount.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountManagerIcon.png"))); // NOI18N
        btnMenuAccount.setText("Accounts");
        btnMenuAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuAccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenuBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnMenuBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnMenuPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnMenuAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btnProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("© PRIMAMOBILES 2025. Redistribution or reproduction is strictly prohibited. ");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 255)));
        jLabel1.setMaximumSize(new java.awt.Dimension(550, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 15));
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
        panelHome.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerBill.setVisible(false);
        panelProfile.setVisible(true);

        btnProfle.setForeground(new Color(0, 0, 0));
        btnProfle.setBackgroundColor(new Color(204, 255, 255));

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnHomePage.setForeground(new Color(204, 204, 204));
        btnHomePage.setBackgroundColor(Color.GRAY);

        btnLogOut.setForeground(new Color(204, 204, 204));
        btnLogOut.setBackgroundColor(Color.GRAY);
    }//GEN-LAST:event_btnProfleMouseClicked

    private void btnProfleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfleActionPerformed

//        if (!PanelProfile.isVisible()) {
//            txtPasswordProfile.setEchoChar('*');
//            CheckPassword.setSelected(false);
//        }
    }//GEN-LAST:event_btnProfleActionPerformed

    private void btnHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomePageMouseClicked

        panelHome.setVisible(true);
        panelManagerAccount.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerBill.setVisible(false);
        panelProfile.setVisible(false);

        btnHomePage.setForeground(new Color(0, 0, 0));
        btnHomePage.setBackgroundColor(new Color(204, 255, 255));

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnProfle.setForeground(new Color(204, 204, 204));
        btnProfle.setBackgroundColor(Color.GRAY);

        btnLogOut.setForeground(new Color(204, 204, 204));
        btnLogOut.setBackgroundColor(Color.GRAY);
    }//GEN-LAST:event_btnHomePageMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked

//        if (status == 1) {
//            Run.runApp();
//            dispose();
//        } else {
//            RunAdmin.runApp();
//            dispose();
//        }
        int check = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO LOG OUT OF YOUR CURRENT ACCOUNT ?", "CONFIRM", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            Run.runApp();
            dispose();
        } else {
            return;
        }

    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnMenuBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuBillMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerBill.setVisible(true);
        btnMenuBill.setForeground(new Color(0, 0, 0));
        btnMenuBill.setBackgroundColor(new Color(204, 255, 255));

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnHomePage.setForeground(new Color(204, 204, 204));
        btnHomePage.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnProfle.setForeground(new Color(204, 204, 204));
        btnProfle.setBackgroundColor(Color.GRAY);

        btnLogOut.setForeground(new Color(204, 204, 204));
        btnLogOut.setBackgroundColor(Color.GRAY);
    }//GEN-LAST:event_btnMenuBillMouseClicked

    private void btnMenuPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuPhoneMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(true);

        btnMenuPhone.setForeground(new Color(0, 0, 0));
        btnMenuPhone.setBackgroundColor(new Color(204, 255, 255));

        btnMenuAccount.setForeground(new Color(204, 204, 204));
        btnMenuAccount.setBackgroundColor(Color.GRAY);

        btnHomePage.setForeground(new Color(204, 204, 204));
        btnHomePage.setBackgroundColor(Color.GRAY);

        btnProfle.setForeground(new Color(204, 204, 204));
        btnProfle.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);

        btnLogOut.setForeground(new Color(204, 204, 204));
        btnLogOut.setBackgroundColor(Color.GRAY);
    }//GEN-LAST:event_btnMenuPhoneMouseClicked

    private void btnMenuAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAccountMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerAccount.setVisible(true);
        btnMenuAccount.setForeground(new Color(0, 0, 0));
        btnMenuAccount.setBackgroundColor(new Color(204, 255, 255));

        btnHomePage.setForeground(new Color(204, 204, 204));
        btnHomePage.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnProfle.setForeground(new Color(204, 204, 204));
        btnProfle.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);

        btnLogOut.setForeground(new Color(204, 204, 204));
        btnLogOut.setBackgroundColor(Color.GRAY);

    }//GEN-LAST:event_btnMenuAccountMouseClicked

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
    private Forms.Components.HeaderButton btnMenuAccount;
    private Forms.Components.HeaderButton btnMenuBill;
    private Forms.Components.HeaderButton btnMenuPhone;
    private Forms.Components.HeaderButton btnProfle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
