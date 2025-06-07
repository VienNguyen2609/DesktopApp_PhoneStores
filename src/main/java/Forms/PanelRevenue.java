package Forms;

import Controllers.RevenueController;
import Forms.Components.RoundedBorder;
import Forms.Components.ViewTabel;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelRevenue extends javax.swing.JPanel {

    private double totalPrice = 0;
    private int totalQuantity = 0;
    private RevenueController controller;
    private DefaultTableModel model;

    private ViewTabel viewTabel;

    public PanelRevenue() {
        initComponents();

        txtPrice.setCustomBorder(new RoundedBorder(20, Color.WHITE));
        txtQuantity.setCustomBorder(new RoundedBorder(20, Color.WHITE));
        btnCofirm.setForeground(new Color(0, 0, 0));
        controller = new RevenueController();

        viewTabel = new ViewTabel();
        viewTabel.view(tbRevenue);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRevenue = new javax.swing.JTable();
        cbMonth = new javax.swing.JComboBox<>();
        cbYear = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnCofirm = new Forms.Components.HeaderButton();
        txtQuantity = new Forms.Components.TextFieldController();
        txtPrice = new Forms.Components.TextFieldController();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        tbRevenue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbRevenue.setForeground(new java.awt.Color(255, 255, 255));
        tbRevenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Phone Name", "Brand Phone", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRevenue.setShowGrid(false);
        tbRevenue.setShowHorizontalLines(true);
        tbRevenue.setShowVerticalLines(true);
        tbRevenue.getTableHeader().setResizingAllowed(false);
        tbRevenue.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbRevenue);
        if (tbRevenue.getColumnModel().getColumnCount() > 0) {
            tbRevenue.getColumnModel().getColumn(0).setResizable(false);
            tbRevenue.getColumnModel().getColumn(1).setResizable(false);
            tbRevenue.getColumnModel().getColumn(2).setResizable(false);
            tbRevenue.getColumnModel().getColumn(3).setResizable(false);
            tbRevenue.getColumnModel().getColumn(4).setResizable(false);
        }

        cbMonth.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cbMonth.setForeground(new java.awt.Color(255, 255, 255));
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbYear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cbYear.setForeground(new java.awt.Color(255, 255, 255));
        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2026", "2027", "2028", "2029", "2030" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Year");

        btnCofirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ConfirmBill.png"))); // NOI18N
        btnCofirm.setText("Cofirm ");
        btnCofirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCofirmMouseClicked(evt);
            }
        });

        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Quantity");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Price");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select Month");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnCofirm, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCofirm, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCofirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCofirmMouseClicked

        int selectedMonth = Integer.parseInt((String) cbMonth.getSelectedItem());
        int selectedYear = Integer.parseInt((String) cbYear.getSelectedItem());

        List<Object[]> list = controller.getRevenueByMonth(selectedMonth, selectedYear);

        model = (DefaultTableModel) tbRevenue.getModel();
        model.setRowCount(0);

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Revenue " + selectedMonth + "/" + selectedYear);
        }

        for (Object[] row : list) {
            model.addRow(row);
            totalQuantity += (int) row[2];
            totalPrice += (double) row[4];
        }

        txtPrice.setText("" + totalPrice);
        txtQuantity.setText("" + totalQuantity);
    }//GEN-LAST:event_btnCofirmMouseClicked

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Forms.Components.HeaderButton btnCofirm;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRevenue;
    private Forms.Components.TextFieldController txtPrice;
    private Forms.Components.TextFieldController txtQuantity;
    // End of variables declaration//GEN-END:variables
}
