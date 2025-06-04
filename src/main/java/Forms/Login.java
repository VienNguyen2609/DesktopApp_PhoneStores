
package Forms;

import Controllers.AccountController;
import Forms.Components.EffectComponents;
import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import Model.Account;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;

/**
 *
 * @author VIEN
 */
public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
        AccountController.init();
        EffectComponents.init();
        
        setTitle("PRIMA MOBILES , LOGIN");
        String iconPath = "E:\\Image\\LogoShopIcon.png";
        setIconImage(Toolkit.getDefaultToolkit().getImage(new File(iconPath).getAbsolutePath()));
        setLocationRelativeTo(null);
        setResizable(false);
        
        txtName.setOpaque(false);
        txtName.setBackground(null);
        txtPassword.setOpaque(false);
        txtPassword.setBackground(null);
        
        
         StraightLine.setVisible(false);
        StraightLine3.setVisible(false);
        EffectComponents.instance.focusPointer(txtName, LabelNameUser, jLabel7, Color.GREEN, Color.WHITE);
        EffectComponents.instance.focusPointer(txtPassword, LabelPasswordUser, jLabel6, Color.GREEN, Color.WHITE);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new Forms.Components.TextFieldController();
        LabelNameUser = new javax.swing.JLabel();
        txtPassword = new Forms.Components.PasswordField();
        jLabel6 = new javax.swing.JLabel();
        LabelPasswordUser = new javax.swing.JLabel();
        CheckPass = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        StraightLine = new javax.swing.JLabel();
        LabelMessage = new javax.swing.JLabel();
        headerButton1 = new Forms.Components.HeaderButton();
        StraightLine3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BackgroupFormCreate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sign In To Your Account");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 290, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("______________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 230, 30));

        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setToolTipText("");
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setOpaque(true);
        txtName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 230, -1));

        LabelNameUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameUser.setText("EnterName");
        jPanel1.add(LabelNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 80, -1));

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setToolTipText("");
        txtPassword.setEchoChar('\u002A');
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPassword.setOpaque(true);
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 220, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("______________________________________________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 260, 30));

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("EnterPassword");
        jPanel1.add(LabelPasswordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 100, -1));

        CheckPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckPass.setForeground(new java.awt.Color(255, 255, 255));
        CheckPass.setText("Show Password");
        CheckPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CheckPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CheckPassMouseExited(evt);
            }
        });
        jPanel1.add(CheckPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Don't have an account ?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 204));
        jLabel4.setText("Sign Up");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, 30));

        StraightLine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        StraightLine.setForeground(new java.awt.Color(255, 255, 255));
        StraightLine.setText("____________");
        jPanel1.add(StraightLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 110, 20));

        LabelMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelMessage.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(LabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 310, 20));

        headerButton1.setBackground(new java.awt.Color(255, 204, 51));
        headerButton1.setText("Sign In");
        headerButton1.setToolTipText("");
        headerButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        headerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerButton1MouseClicked(evt);
            }
        });
        jPanel1.add(headerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, -1));

        StraightLine3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        StraightLine3.setForeground(new java.awt.Color(255, 255, 255));
        StraightLine3.setText("___________________");
        jPanel1.add(StraightLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 110, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 390, 430));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LogoShopIcon.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 160));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRIMA MOBILES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("© PRIMA MOBILES 2025. Redistribution or reproduction is strictly prohibited. ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 540, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("WELCOME TO PRIMA MOBILES , SIGN IN NOW TO SHOPPING");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        BackgroupFormCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundLoginAdmin.png"))); // NOI18N
        getContentPane().add(BackgroupFormCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseClicked

        if (CheckPass.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckPassMouseClicked

    private void CheckPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseEntered
        StraightLine3.setVisible(true);
    }//GEN-LAST:event_CheckPassMouseEntered

    private void CheckPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckPassMouseExited
        StraightLine3.setVisible(false);
    }//GEN-LAST:event_CheckPassMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new CreateAccount().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        StraightLine.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        StraightLine.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseExited

    private void headerButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerButton1MouseClicked
        AccountController.instance.loadDataAccounts();
        String username = txtName.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();

        SetThemFlatLaf.setThem(ThemeFlatLaf.Dark);
        if (AccountController.instance.checkLogin(username, password)) {
            Account user = AccountController.instance.getAccountByUsername(username);
            new HomePage(user).setVisible(true);
            dispose();
        }

        else if (username.isEmpty() || password.isEmpty()){
            LabelMessage.setText("error: INFORMATION NOT EMPTY!");
        }

        else{
            LabelMessage.setText("error: NAME OR PASSWORD WRONG!");
        }
    }//GEN-LAST:event_headerButton1MouseClicked

    
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroupFormCreate;
    private javax.swing.JCheckBox CheckPass;
    private javax.swing.JLabel LabelMessage;
    private javax.swing.JLabel LabelNameUser;
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel StraightLine;
    private javax.swing.JLabel StraightLine3;
    private Forms.Components.HeaderButton headerButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private Forms.Components.TextFieldController txtName;
    private Forms.Components.PasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
