package Forms;

import Controllers.BillController;
import Model.Staff;
import Model.BillDisplay;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VIEN
 */
public class PanelManagerBill extends javax.swing.JPanel {

    private ArrayList<BillDisplay> list;

    private int selectedRow;
    private PanelPhone panelPhone;
    private Staff staff;
    private PanelHome panelHome;

    public PanelManagerBill(PanelPhone panelPhone, Staff account, PanelHome panelHome) {
        initComponents();
        BillController.init();
        this.panelPhone = panelPhone;
        this.staff = account;
        this.panelHome = panelHome;

        list = BillController.instance.getDisplayBills();
        BillController.instance.showBillDisplayToTable(tbBill, list);

        btnRemoveAll.setForeground(new Color(0, 0, 0));
        btnRemoveAll.setBackgroundColor(new Color(204, 255, 255));
        btnRemove.setForeground(new Color(0, 0, 0));

        btnRefresh.setForeground(new Color(0, 0, 0));
        btnRefresh.setBackgroundColor(Color.LIGHT_GRAY);
    }

    public void statusBill() {
        // Luôn refresh dữ liệu khi được gọi
        list = BillController.instance.getDisplayBills();
        BillController.instance.showBillDisplayToTable(tbBill, list);

        // Refresh UI
        tbBill.revalidate();
        tbBill.repaint();

        // Reset status
        if (panelPhone != null) {
            panelPhone.statusBill = 0;
        }
    }

    public void clickTabelBill() {
        selectedRow = tbBill.getSelectedRow();
        if (selectedRow != -1) {
            String nameUser = tbBill.getValueAt(selectedRow, 2).toString();
            String phoneName = tbBill.getValueAt(selectedRow, 3).toString();
            int quantity = Integer.parseInt(tbBill.getValueAt(selectedRow, 4).toString());
            double price = Double.parseDouble(tbBill.getValueAt(selectedRow, 5).toString());
            double total = Double.parseDouble(tbBill.getValueAt(selectedRow, 6).toString());
            String date = tbBill.getValueAt(selectedRow, 7).toString();
            String status = tbBill.getValueAt(selectedRow, 8).toString();

            txtBillNameUser.setText(nameUser);
            txtBillPhoneName.setText(phoneName);
            txtBillQuantity.setText("" + quantity);
            txtBillPrice.setText("" + price);
            txtBillTotal.setText("" + total);
            txtBillDate.setText("" + date);
            txtBillStatus.setText("" + status);
        }
    }

    public void setPanelHome(PanelHome panelHome) {
        this.panelHome = panelHome;
    }

    private void viewBill() {
        txtBillNameUser.setText("");
        txtBillPhoneName.setText("");
        txtBillQuantity.setText("");
        txtBillPrice.setText("");
        txtBillTotal.setText("");
        txtBillDate.setText("");
        txtBillStatus.setText("");
    }

    public void loadBillInTbale() {
        list = BillController.instance.getDisplayBills();
        BillController.instance.showBillDisplayToTable(tbBill, list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbBill = new javax.swing.JTable();
        btnRemoveAll = new Forms.Components.HeaderButton();
        LabelNameProduct = new javax.swing.JLabel();
        txtBillNameUser = new Forms.Components.TextFieldController();
        jLabel18 = new javax.swing.JLabel();
        LabelNameProduct1 = new javax.swing.JLabel();
        txtBillPhoneName = new Forms.Components.TextFieldController();
        jLabel19 = new javax.swing.JLabel();
        LabelNameProduct2 = new javax.swing.JLabel();
        txtBillQuantity = new Forms.Components.TextFieldController();
        jLabel20 = new javax.swing.JLabel();
        LabelNameProduct3 = new javax.swing.JLabel();
        txtBillPrice = new Forms.Components.TextFieldController();
        jLabel21 = new javax.swing.JLabel();
        LabelNameProduct4 = new javax.swing.JLabel();
        txtBillTotal = new Forms.Components.TextFieldController();
        jLabel22 = new javax.swing.JLabel();
        LabelNameProduct5 = new javax.swing.JLabel();
        txtBillDate = new Forms.Components.TextFieldController();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        LabelNameProduct6 = new javax.swing.JLabel();
        txtBillStatus = new Forms.Components.TextFieldController();
        btnRemove = new Forms.Components.HeaderButton();
        btnRefresh = new Forms.Components.HeaderButton();

        tbBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbBill.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tbBill.setForeground(new java.awt.Color(255, 255, 255));
        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "BillId", "Client Name", "Phone", "Quantity", "Price", "Total", "DateBooking", "Name Staff", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBill.setShowHorizontalLines(true);
        tbBill.setShowVerticalLines(true);
        tbBill.getTableHeader().setResizingAllowed(false);
        tbBill.getTableHeader().setReorderingAllowed(false);
        tbBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBill);
        if (tbBill.getColumnModel().getColumnCount() > 0) {
            tbBill.getColumnModel().getColumn(0).setMinWidth(50);
            tbBill.getColumnModel().getColumn(0).setMaxWidth(50);
            tbBill.getColumnModel().getColumn(1).setMinWidth(50);
            tbBill.getColumnModel().getColumn(1).setMaxWidth(50);
            tbBill.getColumnModel().getColumn(2).setResizable(false);
            tbBill.getColumnModel().getColumn(3).setResizable(false);
            tbBill.getColumnModel().getColumn(4).setMinWidth(50);
            tbBill.getColumnModel().getColumn(4).setMaxWidth(50);
            tbBill.getColumnModel().getColumn(5).setResizable(false);
            tbBill.getColumnModel().getColumn(6).setResizable(false);
            tbBill.getColumnModel().getColumn(7).setResizable(false);
            tbBill.getColumnModel().getColumn(8).setResizable(false);
            tbBill.getColumnModel().getColumn(9).setResizable(false);
        }

        btnRemoveAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon.png"))); // NOI18N
        btnRemoveAll.setText("Remove All");
        btnRemoveAll.setVerifyInputWhenFocusTarget(false);
        btnRemoveAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveAllMouseClicked(evt);
            }
        });

        LabelNameProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct.setText("User Name");

        txtBillNameUser.setEditable(false);
        txtBillNameUser.setForeground(new java.awt.Color(255, 255, 255));
        txtBillNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillNameUser.setMaximumSize(null);
        txtBillNameUser.setMinimumSize(new java.awt.Dimension(50, 50));
        txtBillNameUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("____________________________________");
        jLabel18.setMaximumSize(null);
        jLabel18.setMinimumSize(new java.awt.Dimension(50, 50));

        LabelNameProduct1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct1.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct1.setText("Name Phone");

        txtBillPhoneName.setEditable(false);
        txtBillPhoneName.setForeground(new java.awt.Color(255, 255, 255));
        txtBillPhoneName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillPhoneName.setMaximumSize(null);
        txtBillPhoneName.setMinimumSize(new java.awt.Dimension(50, 50));
        txtBillPhoneName.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NameIcon.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("____________________________________");
        jLabel19.setMaximumSize(null);
        jLabel19.setMinimumSize(new java.awt.Dimension(50, 50));

        LabelNameProduct2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct2.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct2.setText("Quantity");

        txtBillQuantity.setEditable(false);
        txtBillQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtBillQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillQuantity.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/QuantityIcon.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("_______________________________");

        LabelNameProduct3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct3.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct3.setText("Price");

        txtBillPrice.setEditable(false);
        txtBillPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtBillPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillPrice.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PriceIcon.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("_________________________________________");

        LabelNameProduct4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct4.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct4.setText("Total");

        txtBillTotal.setEditable(false);
        txtBillTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtBillTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillTotal.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/TotalIcon.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("____________________________________");

        LabelNameProduct5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct5.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct5.setText("Date");

        txtBillDate.setEditable(false);
        txtBillDate.setForeground(new java.awt.Color(255, 255, 255));
        txtBillDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillDate.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DateIcon.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("____________________________________");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("____________________________________");

        LabelNameProduct6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNameProduct6.setForeground(new java.awt.Color(255, 255, 255));
        LabelNameProduct6.setText("Status(0: Unpaid , 1: Paid)");

        txtBillStatus.setEditable(false);
        txtBillStatus.setForeground(new java.awt.Color(255, 255, 255));
        txtBillStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBillStatus.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/StatusIcon.png"))); // NOI18N

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon1 (2).png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setVerifyInputWhenFocusTarget(false);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RefreshIcon.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setVerifyInputWhenFocusTarget(false);
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNameProduct4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBillTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNameProduct)
                            .addComponent(txtBillNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNameProduct1)
                                    .addComponent(txtBillPhoneName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBillQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                .addGap(378, 378, 378))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelNameProduct2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(512, 512, 512))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNameProduct5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBillDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelNameProduct6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBillStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelNameProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                .addComponent(txtBillPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnRemoveAll, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNameProduct)
                            .addComponent(LabelNameProduct1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBillNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBillPhoneName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelNameProduct5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBillDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelNameProduct4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBillTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelNameProduct6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBillStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelNameProduct3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBillPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelNameProduct2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemoveAll, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBillQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveAllMouseClicked

        int check = JOptionPane.showConfirmDialog(this, "Do you want delete all bill!", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            BillController.instance.deleteAllBills();

            list = BillController.instance.getDisplayBills();
            BillController.instance.showBillDisplayToTable(tbBill, list);

            viewBill();
            panelHome.addPanelProducts();
        }


    }//GEN-LAST:event_btnRemoveAllMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked

        int check = JOptionPane.showConfirmDialog(this, "Do you want delete this bill!", "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            selectedRow = tbBill.getSelectedRow();
            if (selectedRow != -1) {

                int idBill = Integer.parseInt(tbBill.getValueAt(selectedRow, 1).toString());
                String phoneName = tbBill.getValueAt(selectedRow, 3).toString();
                int quantity = Integer.parseInt(tbBill.getValueAt(selectedRow, 4).toString());

                BillController.instance.deleteBill(idBill);

                viewBill();
                list = BillController.instance.getDisplayBills();
                BillController.instance.showBillDisplayToTable(tbBill, list);

            }

            panelHome.addPanelProducts();
        }

    }//GEN-LAST:event_btnRemoveMouseClicked

    private void tbBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBillMouseClicked
        clickTabelBill();
    }//GEN-LAST:event_tbBillMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "REFRESH BILL!", "CONFIRM", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            loadBillInTbale();
        }

    }//GEN-LAST:event_btnRefreshMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNameProduct;
    private javax.swing.JLabel LabelNameProduct1;
    private javax.swing.JLabel LabelNameProduct2;
    private javax.swing.JLabel LabelNameProduct3;
    private javax.swing.JLabel LabelNameProduct4;
    private javax.swing.JLabel LabelNameProduct5;
    private javax.swing.JLabel LabelNameProduct6;
    private Forms.Components.HeaderButton btnRefresh;
    private Forms.Components.HeaderButton btnRemove;
    private Forms.Components.HeaderButton btnRemoveAll;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBill;
    private Forms.Components.TextFieldController txtBillDate;
    private Forms.Components.TextFieldController txtBillNameUser;
    private Forms.Components.TextFieldController txtBillPhoneName;
    private Forms.Components.TextFieldController txtBillPrice;
    private Forms.Components.TextFieldController txtBillQuantity;
    private Forms.Components.TextFieldController txtBillStatus;
    private Forms.Components.TextFieldController txtBillTotal;
    // End of variables declaration//GEN-END:variables
}
