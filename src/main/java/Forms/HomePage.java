package Forms;

import Controllers.PhoneController;
import Forms.Components.EffectComponents;
import Main.Run;
import Model.Staff;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author VIEN
 */

public class HomePage extends javax.swing.JFrame {

    private PanelManagerStaff panelManagerAccount;
    private PanelPhone panelPhone;
    private PanelHome panelHome;
    private PanelManagerPhone panelManagerPhone;
    private PanelManagerBill panelManagerBill;
    private PanelProfile panelProfile;
    private PanelManagerClient panelManagerClient;
    private PanelRevenue panelRevenue;

    private Staff currentStaff;

    public HomePage() {
        initComponents();
    }

    public HomePage(Staff staff) {
        initComponents();
        PhoneController.init();
        EffectComponents.init();
        this.currentStaff = staff;

        panelManagerAccount = new PanelManagerStaff();
        panelPhone = new PanelPhone(currentStaff);

        // tạm thời gán null
        panelManagerBill = new PanelManagerBill(panelPhone, staff, null);
        panelManagerClient = new PanelManagerClient(panelManagerBill);
        panelHome = new PanelHome(currentStaff, panelManagerBill, null, panelManagerClient);

        // gán lại panelHome cho panelManagerBill
        panelManagerBill.setPanelHome(panelHome);
        panelManagerPhone = new PanelManagerPhone(panelHome);

        panelProfile = new PanelProfile(staff);

        panelHome.setPanelManagerPhone(panelManagerPhone);

        panelRevenue = new PanelRevenue();
        if ("admin".equalsIgnoreCase(staff.getPosition())) {
            this.jPanel2.add(panelRevenue);
            this.jPanel2.add(panelManagerAccount);
            this.jPanel2.add(panelProfile);
            this.jPanel2.add(panelManagerBill);
            this.jPanel2.add(panelManagerPhone);
            this.jPanel2.add(panelHome);
            this.jPanel2.add(panelManagerClient);
        } else if ("employee".equalsIgnoreCase(staff.getPosition())) {
            this.jPanel2.add(panelProfile);
            this.jPanel2.add(panelManagerBill);
            this.jPanel2.add(panelHome);
            this.jPanel2.add(panelManagerPhone);
            this.jPanel2.add(panelManagerClient);
            btnMenuStaff.setVisible(false);
            btnMenuRevenue.setVisible(false);
        } else {
            this.jPanel2.add(panelHome);
            btnMenuStaff.setVisible(false);
            btnMenuRevenue.setVisible(false);
            btnMenuBill.setVisible(false);
            btnMenuPhone.setVisible(false);
            btnMenuClient.setVisible(false);       
        }
        panelRevenue.setVisible(false);
        panelProfile.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerClient.setVisible(false);
        panelHome.setVisible(true);
        this.jPanel2.revalidate();
        this.jPanel2.repaint();
        styleButton();
        setupWindow();
        EffectComponents.instance.scaleImage(jLabel2, "/Image/LogoShopIcon.png");
    }

    private void styleButton() {
//        btnUploadAvatar.setBackgroundColor(Color.ORANGE);
        btnMenuProfle.setBackgroundColor(Color.GRAY);
        btnMenuHomePage.setForeground(new Color(0, 0, 0));
        btnMenuLogOut.setForeground(new Color(0, 0, 0));
        btnMenuHomePage.setBackgroundColor(new Color(204, 255, 255));
        btnMenuLogOut.setBackgroundColor(Color.red);
        btnMenuStaff.setBackgroundColor(Color.GRAY);
        btnMenuPhone.setBackgroundColor(Color.GRAY);
        btnMenuBill.setBackgroundColor(Color.GRAY);
        btnMenuClient.setBackgroundColor(Color.GRAY);
        btnMenuRevenue.setBackgroundColor(Color.GRAY);
    }

    private void setupWindow() {
        setLocationRelativeTo(null);
        setTitle("PRIMA MOBILES ,  SHOP FOR YOU ");
        Image iconApp = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/LogoShopIcon.png"));
        setIconImage(iconApp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnMenuProfle = new Forms.Components.HeaderButton();
        btnMenuHomePage = new Forms.Components.HeaderButton();
        btnMenuLogOut = new Forms.Components.HeaderButton();
        btnMenuBill = new Forms.Components.HeaderButton();
        btnMenuPhone = new Forms.Components.HeaderButton();
        btnMenuStaff = new Forms.Components.HeaderButton();
        btnMenuClient = new Forms.Components.HeaderButton();
        btnMenuRevenue = new Forms.Components.HeaderButton();
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

        btnMenuProfle.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuProfle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountIcon.png"))); // NOI18N
        btnMenuProfle.setText("Profile");
        btnMenuProfle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuProfleMouseClicked(evt);
            }
        });

        btnMenuHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HomeIcon.png"))); // NOI18N
        btnMenuHomePage.setText("Home");
        btnMenuHomePage.setVerifyInputWhenFocusTarget(false);
        btnMenuHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuHomePageMouseClicked(evt);
            }
        });

        btnMenuLogOut.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogOutIcon.png"))); // NOI18N
        btnMenuLogOut.setText("Sign Out");
        btnMenuLogOut.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMenuLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuLogOutMouseClicked(evt);
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
        btnMenuPhone.setText("Phones");
        btnMenuPhone.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMenuPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuPhoneMouseClicked(evt);
            }
        });

        btnMenuStaff.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountManagerIcon.png"))); // NOI18N
        btnMenuStaff.setText("Staffs");
        btnMenuStaff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuStaffMouseClicked(evt);
            }
        });

        btnMenuClient.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ClientIcon.png"))); // NOI18N
        btnMenuClient.setText("Clients");
        btnMenuClient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuClientMouseClicked(evt);
            }
        });

        btnMenuRevenue.setForeground(new java.awt.Color(204, 204, 204));
        btnMenuRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RevenueIcon.png"))); // NOI18N
        btnMenuRevenue.setText("Revenue");
        btnMenuRevenue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuRevenueMouseClicked(evt);
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
                    .addComponent(btnMenuProfle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenuLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenuHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnMenuBill, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnMenuPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnMenuClient, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnMenuStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnMenuRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnMenuProfle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnMenuProfleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuProfleMouseClicked
        panelHome.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerClient.setVisible(false);
        panelRevenue.setVisible(false);
        panelProfile.setVisible(true);

        btnMenuProfle.setForeground(new Color(0, 0, 0));
        btnMenuProfle.setBackgroundColor(new Color(204, 255, 255));

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuRevenue.setForeground(new Color(204, 204, 204));
        btnMenuRevenue.setBackgroundColor(Color.GRAY);

        btnMenuClient.setForeground(new Color(204, 204, 204));
        btnMenuClient.setBackgroundColor(Color.GRAY);

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuHomePage.setForeground(new Color(204, 204, 204));
        btnMenuHomePage.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuProfleMouseClicked

    private void btnMenuHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuHomePageMouseClicked

        panelHome.setVisible(true);
        panelManagerAccount.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerClient.setVisible(false);
        panelProfile.setVisible(false);
        panelRevenue.setVisible(false);

        btnMenuHomePage.setForeground(new Color(0, 0, 0));
        btnMenuHomePage.setBackgroundColor(new Color(204, 255, 255));

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuClient.setForeground(new Color(204, 204, 204));
        btnMenuClient.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);

        btnMenuRevenue.setForeground(new Color(204, 204, 204));
        btnMenuRevenue.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuProfle.setForeground(new Color(204, 204, 204));
        btnMenuProfle.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuHomePageMouseClicked

    private void btnMenuLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuLogOutMouseClicked

        int check = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO LOG OUT OF YOUR CURRENT ACCOUNT ?", "CONFIRM", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            Run.runApp();
            dispose();
        } else {
            return;
        }

    }//GEN-LAST:event_btnMenuLogOutMouseClicked

    private void btnMenuBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuBillMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelRevenue.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerClient.setVisible(false);
        panelManagerBill.setVisible(true);
        btnMenuBill.setForeground(new Color(0, 0, 0));
        btnMenuBill.setBackgroundColor(new Color(204, 255, 255));

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuHomePage.setForeground(new Color(204, 204, 204));
        btnMenuHomePage.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuRevenue.setForeground(new Color(204, 204, 204));
        btnMenuRevenue.setBackgroundColor(Color.GRAY);

        btnMenuClient.setForeground(new Color(204, 204, 204));
        btnMenuClient.setBackgroundColor(Color.GRAY);

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuProfle.setForeground(new Color(204, 204, 204));
        btnMenuProfle.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuBillMouseClicked

    private void btnMenuPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuPhoneMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerClient.setVisible(false);
        panelRevenue.setVisible(false);
        panelManagerPhone.setVisible(true);

        btnMenuPhone.setForeground(new Color(0, 0, 0));
        btnMenuPhone.setBackgroundColor(new Color(204, 255, 255));

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuClient.setForeground(new Color(204, 204, 204));
        btnMenuClient.setBackgroundColor(Color.GRAY);

        btnMenuRevenue.setForeground(new Color(204, 204, 204));
        btnMenuRevenue.setBackgroundColor(Color.GRAY);

        btnMenuHomePage.setForeground(new Color(204, 204, 204));
        btnMenuHomePage.setBackgroundColor(Color.GRAY);

        btnMenuProfle.setForeground(new Color(204, 204, 204));
        btnMenuProfle.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuPhoneMouseClicked

    private void btnMenuStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuStaffMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerClient.setVisible(false);
        panelRevenue.setVisible(false);
        panelManagerAccount.setVisible(true);
        btnMenuStaff.setForeground(new Color(0, 0, 0));
        btnMenuStaff.setBackgroundColor(new Color(204, 255, 255));

        btnMenuHomePage.setForeground(new Color(204, 204, 204));
        btnMenuHomePage.setBackgroundColor(Color.GRAY);

        btnMenuClient.setForeground(new Color(204, 204, 204));
        btnMenuClient.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuRevenue.setForeground(new Color(204, 204, 204));
        btnMenuRevenue.setBackgroundColor(Color.GRAY);

        btnMenuProfle.setForeground(new Color(204, 204, 204));
        btnMenuProfle.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuStaffMouseClicked

    private void btnMenuClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuClientMouseClicked
        // TODO add your handling code here:
        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelRevenue.setVisible(false);
        panelManagerClient.setVisible(true);
        panelManagerAccount.setVisible(false);

        btnMenuClient.setForeground(new Color(0, 0, 0));
        btnMenuClient.setBackgroundColor(new Color(204, 255, 255));

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuHomePage.setForeground(new Color(204, 204, 204));
        btnMenuHomePage.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuRevenue.setForeground(new Color(204, 204, 204));
        btnMenuRevenue.setBackgroundColor(Color.GRAY);

        btnMenuProfle.setForeground(new Color(204, 204, 204));
        btnMenuProfle.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuClientMouseClicked

    private void btnMenuRevenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuRevenueMouseClicked

        panelProfile.setVisible(false);
        panelHome.setVisible(false);
        panelManagerBill.setVisible(false);
        panelManagerPhone.setVisible(false);
        panelManagerClient.setVisible(false);
        panelManagerAccount.setVisible(false);
        panelRevenue.setVisible(true);

        btnMenuRevenue.setForeground(new Color(0, 0, 0));
        btnMenuRevenue.setBackgroundColor(new Color(204, 255, 255));

        btnMenuStaff.setForeground(new Color(204, 204, 204));
        btnMenuStaff.setBackgroundColor(Color.GRAY);

        btnMenuHomePage.setForeground(new Color(204, 204, 204));
        btnMenuHomePage.setBackgroundColor(Color.GRAY);

        btnMenuClient.setForeground(new Color(204, 204, 204));
        btnMenuClient.setBackgroundColor(Color.GRAY);

        btnMenuPhone.setForeground(new Color(204, 204, 204));
        btnMenuPhone.setBackgroundColor(Color.GRAY);

        btnMenuProfle.setForeground(new Color(204, 204, 204));
        btnMenuProfle.setBackgroundColor(Color.GRAY);

        btnMenuBill.setForeground(new Color(204, 204, 204));
        btnMenuBill.setBackgroundColor(Color.GRAY);


    }//GEN-LAST:event_btnMenuRevenueMouseClicked

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
    private Forms.Components.HeaderButton btnMenuBill;
    private Forms.Components.HeaderButton btnMenuClient;
    private Forms.Components.HeaderButton btnMenuHomePage;
    private Forms.Components.HeaderButton btnMenuLogOut;
    private Forms.Components.HeaderButton btnMenuPhone;
    private Forms.Components.HeaderButton btnMenuProfle;
    private Forms.Components.HeaderButton btnMenuRevenue;
    private Forms.Components.HeaderButton btnMenuStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
