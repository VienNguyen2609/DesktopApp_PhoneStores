
package Forms;

import Controllers.PhoneController;
import Model.Account;
import Model.Phone;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import javax.swing.ImageIcon;


public class PanelHome extends javax.swing.JPanel {

   private int quantityAvailableBill;
   
   private Account currentAccount;
   private PanelManagerBill panelManagerBill ; 
 
    public PanelHome(Account account  , PanelManagerBill panelManagerBill) {
        initComponents();
        this.currentAccount = account;
        this.panelManagerBill = panelManagerBill ; 
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
        PhoneController.init();
        addPanelProducts();
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
            var newJpanel = new PanelPhone(phone, this ,currentAccount , panelManagerBill);
            gbc.gridx = i % cols;
            gbc.gridy = (i / cols) + 1;
            this.PanelContainProduct.add(newJpanel, gbc);
        }
        this.PanelContainProduct.revalidate();
        this.PanelContainProduct.repaint();
    }
   
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHomePage = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelContainProduct = new javax.swing.JPanel();
        txtSearch = new Forms.Components.TextFieldController();

        PanelHomePage.setPreferredSize(new java.awt.Dimension(1100, 720));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtSearch.setMinimumSize(new java.awt.Dimension(70, 40));
        txtSearch.setPreferredSize(new java.awt.Dimension(70, 40));

        javax.swing.GroupLayout PanelContainProductLayout = new javax.swing.GroupLayout(PanelContainProduct);
        PanelContainProduct.setLayout(PanelContainProductLayout);
        PanelContainProductLayout.setHorizontalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainProductLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1217, Short.MAX_VALUE))
        );
        PanelContainProductLayout.setVerticalGroup(
            PanelContainProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContainProductLayout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1080, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(PanelContainProduct);

        javax.swing.GroupLayout PanelHomePageLayout = new javax.swing.GroupLayout(PanelHomePage);
        PanelHomePage.setLayout(PanelHomePageLayout);
        PanelHomePageLayout.setHorizontalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        PanelHomePageLayout.setVerticalGroup(
            PanelHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContainProduct;
    private javax.swing.JPanel PanelHomePage;
    private javax.swing.JScrollPane jScrollPane2;
    private Forms.Components.TextFieldController txtSearch;
    // End of variables declaration//GEN-END:variables
}
