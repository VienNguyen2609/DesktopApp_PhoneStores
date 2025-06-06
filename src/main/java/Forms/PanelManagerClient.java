package Forms;

import Controllers.ClientController;
import Model.Client;
import Model.OrderForClient;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danh Thao
 */
public class PanelManagerClient extends javax.swing.JPanel {

    private int selectedRow;
    private List<Client> listClient = new ArrayList<>();
    private Client client;
    ClientController clientController;
    DefaultTableModel model;

    public PanelManagerClient() {
        initComponents();

        client = new Client();
        clientController = new ClientController();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        };

        tbClient.setModel(model);
        model.addColumn("STT");
        model.addColumn("IDClient");
        model.addColumn("NameClient");
        model.addColumn("TelClient");
        model.addColumn("AddressClient");
        model.addColumn("GmailClient");

        listClient = clientController.loadDataAccounts();
        viewTabelClient();
        styleButton();
        
        //ktra chuột phải
//        JScrollPane jScrollPane=new JScrollPane(tbClient);
        //tạo popup menu
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem1 = new JMenuItem("Xem đơn hàng");
        JMenuItem jMenuItem2 = new JMenuItem("Xóa");
        JMenuItem jMenuItem3 = new JMenuItem("Hủy");

        jPopupMenu.add(jMenuItem1);
        jPopupMenu.add(jMenuItem2);
        jPopupMenu.add(jMenuItem3);

        //thêm listener
        tbClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = tbClient.rowAtPoint(e.getPoint());
                    if (row >= 0 && row < tbClient.getRowCount()) {
                        tbClient.setRowSelectionInterval(row, row); // Chọn dòng được click
                        jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

        // Ví dụ xử lý khi chọn "Xóa"
        jMenuItem2.addActionListener(e -> {
            selectedRow = tbClient.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "You have not selected anyone yet!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (selectedRow >= listClient.size()) {
                JOptionPane.showMessageDialog(this, "Selected row is invalid!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            client = listClient.get(selectedRow);
            if (client.getNameClient().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name cannot be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                int chon = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?");
                if (chon == JOptionPane.YES_OPTION) {
                    try {
                        int id = client.getIdClient();
                        String phone = txtTelClient.getText().trim();
                        int idOrder = clientController.findIdOrder();
                        int idOrderOfOrder=clientController.findIdOrderOfOrder();
                        if (idOrder == -1 || idOrderOfOrder == -1) {
                            clientController.delClient(phone);
                        }else if(idOrder == -1 && idOrderOfOrder != -1){
                            clientController.delClientOnOrder(id, phone);
                        }
                        else {
                            clientController.delClientOnBill(idOrder, id, phone);
                        }
                        listClient = clientController.loadDataAccounts();
                        viewTabelClient();
                        txtNameUser.setText("");
                        txtTelClient.setText("");
                        txtGmail.setText("");
                        txtAddress.setText("");
                    } catch (SQLException ex) {
                        Logger.getLogger(PanelManagerClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        jMenuItem1.addActionListener(e -> {
            selectedRow = tbClient.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "You have not selected any customers yet!", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Client selectedClient = listClient.get(selectedRow);
            int clientId = selectedClient.getIdClient();

            List<OrderForClient> orderList = clientController.viewOrderOfClient(clientId);

            if (orderList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "This customer has no orders yet!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            DialogForClient dialog = new DialogForClient((JFrame) SwingUtilities.getWindowAncestor(this), orderList);
            dialog.setVisible(true);  
        });
    }

    public void loadTabelClient(){
         listClient = clientController.loadDataAccounts();
    }
    
    private void viewTabelClient() {
        model.setNumRows(0);
        int n = 1;
        for (Client client1 : listClient) {
            model.addRow(new Object[]{n++, client1.getIdClient(), client1.getNameClient(), client1.getTelClient(), client1.getAddressClient(), client1.getGmailClient()});
        }
    }

    private void styleButton() {
        btnAddClient.setBackgroundColor(Color.GREEN);
        btnUpdateClient.setBackgroundColor(Color.BLUE);
        btnCancelClient.setBackgroundColor(Color.RED);
        btnDeleteClient.setBackgroundColor(Color.ORANGE);
    }

    public void loadTbaleClient() {

        listClient = clientController.loadDataAccounts();
        viewTabelClient();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelClient = new Forms.Components.HeaderButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClient = new javax.swing.JTable();
        txtNameUser = new Forms.Components.TextFieldController();
        btnUpdateClient = new Forms.Components.HeaderButton();
        LabelPasswordUser = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtGmail = new Forms.Components.TextFieldController();
        LabelPasswordUser1 = new javax.swing.JLabel();
        btnAddClient = new Forms.Components.HeaderButton();
        jLabel22 = new javax.swing.JLabel();
        LabelPasswordUser2 = new javax.swing.JLabel();
        txtTelClient = new Forms.Components.TextFieldController();
        btnDeleteClient = new Forms.Components.HeaderButton();
        jLabel23 = new javax.swing.JLabel();
        LabelPasswordUser3 = new javax.swing.JLabel();
        txtAddress = new Forms.Components.TextFieldController();
        jLabel21 = new javax.swing.JLabel();

        btnCancelClient.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CancelIcon.png"))); // NOI18N
        btnCancelClient.setText("Cancel");
        btnCancelClient.setMaximumSize(new java.awt.Dimension(90, 40));
        btnCancelClient.setMinimumSize(new java.awt.Dimension(30, 40));
        btnCancelClient.setPreferredSize(new java.awt.Dimension(50, 40));
        btnCancelClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelClientMouseClicked(evt);
            }
        });

        tbClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbClient.setForeground(new java.awt.Color(255, 255, 255));
        tbClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Id", "Name", "Password", "Address", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClient.setShowHorizontalLines(true);
        tbClient.setShowVerticalLines(true);
        tbClient.getTableHeader().setResizingAllowed(false);
        tbClient.getTableHeader().setReorderingAllowed(false);
        tbClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClient);
        if (tbClient.getColumnModel().getColumnCount() > 0) {
            tbClient.getColumnModel().getColumn(0).setResizable(false);
            tbClient.getColumnModel().getColumn(1).setResizable(false);
            tbClient.getColumnModel().getColumn(2).setResizable(false);
            tbClient.getColumnModel().getColumn(3).setResizable(false);
            tbClient.getColumnModel().getColumn(5).setResizable(false);
        }

        txtNameUser.setForeground(new java.awt.Color(255, 255, 255));
        txtNameUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameUser.setMaximumSize(new java.awt.Dimension(100, 28));
        txtNameUser.setMinimumSize(new java.awt.Dimension(40, 28));
        txtNameUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AccountNameIcon.png"))); // NOI18N

        btnUpdateClient.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UpdateIcon.png"))); // NOI18N
        btnUpdateClient.setText("Update");
        btnUpdateClient.setMaximumSize(new java.awt.Dimension(90, 40));
        btnUpdateClient.setMinimumSize(new java.awt.Dimension(30, 40));
        btnUpdateClient.setPreferredSize(new java.awt.Dimension(50, 40));
        btnUpdateClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateClientMouseClicked(evt);
            }
        });

        LabelPasswordUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser.setText("Telephone");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("____________________________________");

        txtGmail.setForeground(new java.awt.Color(255, 255, 255));
        txtGmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGmail.setMaximumSize(new java.awt.Dimension(90, 28));
        txtGmail.setMinimumSize(new java.awt.Dimension(40, 28));
        txtGmail.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/GmailIcon.png"))); // NOI18N

        LabelPasswordUser1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser1.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser1.setText("Name");

        btnAddClient.setForeground(new java.awt.Color(255, 255, 255));
        btnAddClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AddIcon.png"))); // NOI18N
        btnAddClient.setText("Add");
        btnAddClient.setMaximumSize(new java.awt.Dimension(10, 40));
        btnAddClient.setMinimumSize(new java.awt.Dimension(5, 40));
        btnAddClient.setPreferredSize(new java.awt.Dimension(7, 40));
        btnAddClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddClientMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("____________________________________");

        LabelPasswordUser2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser2.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser2.setText("Gmail");

        txtTelClient.setForeground(new java.awt.Color(255, 255, 255));
        txtTelClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTelClient.setMaximumSize(new java.awt.Dimension(100, 28));
        txtTelClient.setMinimumSize(new java.awt.Dimension(40, 28));
        txtTelClient.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PassIcon.png"))); // NOI18N

        btnDeleteClient.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeleteIcon1.png"))); // NOI18N
        btnDeleteClient.setText("Delete");
        btnDeleteClient.setMaximumSize(new java.awt.Dimension(90, 40));
        btnDeleteClient.setMinimumSize(new java.awt.Dimension(30, 40));
        btnDeleteClient.setPreferredSize(new java.awt.Dimension(50, 40));
        btnDeleteClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteClientMouseClicked(evt);
            }
        });
        btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClientActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("____________________________________");

        LabelPasswordUser3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPasswordUser3.setForeground(new java.awt.Color(255, 255, 255));
        LabelPasswordUser3.setText("Address");

        txtAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddress.setMaximumSize(new java.awt.Dimension(90, 28));
        txtAddress.setMinimumSize(new java.awt.Dimension(40, 28));
        txtAddress.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AddressIcon.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("____________________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(42, 42, 42))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPasswordUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPasswordUser2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelPasswordUser3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelClient, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelClient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(LabelPasswordUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(LabelPasswordUser)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTelClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(LabelPasswordUser2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelPasswordUser3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelClientMouseClicked
        txtNameUser.setText("");
        txtTelClient.setText("");
        txtGmail.setText("");
        txtAddress.setText("");
    }//GEN-LAST:event_btnCancelClientMouseClicked

    private void tbClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientMouseClicked

        selectedRow = tbClient.getSelectedRow();
        client = listClient.get(selectedRow);

        txtNameUser.setText(client.getNameClient());
        txtTelClient.setText(client.getTelClient());
        txtGmail.setText(client.getGmailClient());
        txtAddress.setText(client.getAddressClient());
    }//GEN-LAST:event_tbClientMouseClicked

    private void btnUpdateClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateClientMouseClicked
        selectedRow = tbClient.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "You have not selected anyone yet!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        client = listClient.get(selectedRow);
        if (client.getNameClient().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Are you sure you want to update?");
            if (chon == JOptionPane.YES_OPTION) {
                String name = txtNameUser.getText().trim();
                String phone = txtTelClient.getText().trim();
                String gmail = txtGmail.getText().trim();
                String address = txtAddress.getText().trim();

                Client _cl = new Client(client.getIdClient(), name, phone, address, gmail);
                clientController.updateClient(_cl);
                listClient = clientController.loadDataAccounts();
                viewTabelClient();
                txtNameUser.setText("");
                txtTelClient.setText("");
                txtGmail.setText("");
                txtAddress.setText("");
            }
        }


    }//GEN-LAST:event_btnUpdateClientMouseClicked

    private void btnAddClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddClientMouseClicked

        String name = txtNameUser.getText().trim();
        String phone = txtTelClient.getText().trim();
        String gmail = txtGmail.getText().trim();
        String address = txtAddress.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || gmail.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in the information completely!");
            return;
        }
        Client cl = new Client(name, phone, address, gmail);
        try {
            clientController.addClient(cl);

            listClient = clientController.loadDataAccounts();
            JOptionPane.showMessageDialog(this, "added Successfulll Client have phone is:" + cl.getTelClient());
            viewTabelClient();
            txtNameUser.setText("");
            txtTelClient.setText("");
            txtGmail.setText("");
            txtAddress.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(PanelManagerClient.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAddClientMouseClicked

    private void btnDeleteClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteClientMouseClicked

        selectedRow = tbClient.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "You have not selected anyone yet!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedRow >= listClient.size()) {
            JOptionPane.showMessageDialog(this, "Selected row is invalid!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        client = listClient.get(selectedRow);
        if (client.getNameClient().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?");
            if (chon == JOptionPane.YES_OPTION) {
                try {
                    int id=client.getIdClient();
                    String phone = txtTelClient.getText().trim();
                    int idOrder=clientController.findIdOrder();
                    
                    if(idOrder == -1){
                        clientController.delClient(phone);
                    }else{
                        clientController.delClientOnBill(idOrder, id, phone);
                    }
                    listClient = clientController.loadDataAccounts();
                    viewTabelClient();
                    txtNameUser.setText("");
                    txtTelClient.setText("");
                    txtGmail.setText("");
                    txtAddress.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(PanelManagerClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }

    }//GEN-LAST:event_btnDeleteClientMouseClicked

    private void btnDeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClientActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnDeleteClientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelPasswordUser;
    private javax.swing.JLabel LabelPasswordUser1;
    private javax.swing.JLabel LabelPasswordUser2;
    private javax.swing.JLabel LabelPasswordUser3;
    private Forms.Components.HeaderButton btnAddClient;
    private Forms.Components.HeaderButton btnCancelClient;
    private Forms.Components.HeaderButton btnDeleteClient;
    private Forms.Components.HeaderButton btnUpdateClient;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbClient;
    private Forms.Components.TextFieldController txtAddress;
    private Forms.Components.TextFieldController txtGmail;
    private Forms.Components.TextFieldController txtNameUser;
    private Forms.Components.TextFieldController txtTelClient;
    // End of variables declaration//GEN-END:variables
}
