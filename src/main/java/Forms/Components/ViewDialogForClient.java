package Forms.Components;

import Model.OrderForClient;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewDialogForClient extends JDialog {

    public ViewDialogForClient(JFrame parent, List<OrderForClient> orders) {
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
        table.getTableHeader().setResizingAllowed(false);   // Cho phép thay đổi kích thước cột
        table.getTableHeader().setReorderingAllowed(false);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setSize(900, 600);
        setLocationRelativeTo(parent);
    }
}
