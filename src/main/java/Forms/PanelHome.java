package Forms;

import Controllers.PhoneController;
import Forms.Components.RoundedBorder;
import Model.Account;
import Model.Phone;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PanelHome extends javax.swing.JPanel {

    private int quantityAvailableBill;

    private Account currentAccount;
    private PanelManagerBill panelManagerBill;

    public PanelHome(Account account, PanelManagerBill panelManagerBill) {
        initComponents();
        this.currentAccount = account;
        this.panelManagerBill = panelManagerBill;
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
        PhoneController.init();
        addPanelProducts();
        txtSearch.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
        txtSearch.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/SearchIcon.png")));

    }

    public void addPanelProducts() {

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
            var newJpanel = new PanelPhone(phone, this, currentAccount, panelManagerBill);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
            this.PanelContainProduct.add(newJpanel, gbc);
        }
        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }
    public void addPanelProducts1(String name) {

        this.PanelContainProduct.setLayout(new GridBagLayout());
        this.PanelContainProduct.removeAll();
        PhoneController.instance.searchByName(name);

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
            var newJpanel = new PanelPhone(phone, this, currentAccount, panelManagerBill);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
            this.PanelContainProduct.add(newJpanel, gbc);
        }
        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }

    private void removePlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
    }

    private void addPlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHomePage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainProduct = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new Forms.Components.TextFieldController();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        PanelHomePage.setPreferredSize(new java.awt.Dimension(1100, 720));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout PanelContainProductLayout = new javax.swing.GroupLayout(PanelContainProduct);
        PanelContainProduct.setLayout(PanelContainProductLayout);
        PanelContainProductLayout.setHorizontalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1669, Short.MAX_VALUE)
        );
        PanelContainProductLayout.setVerticalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1115, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(PanelContainProduct);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setText("Search");
        txtSearch.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtSearch.setMaximumSize(new java.awt.Dimension(400, 60));
        txtSearch.setMinimumSize(new java.awt.Dimension(100, 35));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 350, 45));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1526, Short.MAX_VALUE)
            .addGroup(PanelHomePageLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHomePageLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelHomePageLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1526, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, 1526, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Search")) {
            txtSearch.setText(null);
            txtSearch.requestFocus();
            removePlaceHolderStyle(txtSearch);
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, new Color(204, 255, 255)));
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().length() == 0) {
            addPlaceHolderStyle(txtSearch);
            txtSearch.setText("Search");
        }
        txtSearch.setCustomBorder(new RoundedBorder(20, Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        String name = txtSearch.getText().trim();

        
        addPanelProducts1(name);

    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private Forms.Components.TextFieldController txtSearch;
    // End of variables declaration//GEN-END:variables
}
