/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import Model.OrderForClient;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danh Thao
 */
public class DialogForClient extends JDialog{
     public DialogForClient(JFrame parent, List<OrderForClient> orders) {
        setTitle("Check Orders");
        String[] columnNames = {"NameClient", "TelClient", "NamePhone", "BrandPhone", "Price", "Quantity"};
         DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (OrderForClient o : orders) {
            Object[] row = {
                o.getNameClient(),
                o.getTelClient(),
                o.getNamePhone(),
                o.getBrandPhone(),
                o.getPricePhone(),
                o.getQuantity()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
         JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setSize(900, 600);
        setLocationRelativeTo(parent);
    }
}
