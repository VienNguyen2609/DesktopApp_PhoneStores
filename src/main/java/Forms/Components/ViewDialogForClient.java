package Forms.Components;

import Model.OrderForClient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewDialogForClient extends JDialog {
    
    private ViewTabel viewTabel = new ViewTabel();
    
    public ViewDialogForClient(JFrame parent, List<OrderForClient> orders) {
        setTitle("Check Orders");
        String[] columnNames = {"NameClient", "TelClient", "NamePhone", "BrandPhone", "Price", "Quantity","Total"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        for (OrderForClient o : orders) {
            Object[] row = {
                o.getNameClient(),
                o.getTelClient(),
                o.getNamePhone(),
                o.getBrandPhone(),
                o.getPricePhone(),
                o.getQuantity(),
                o.getQuantity() * o.getPricePhone()
            };
            model.addRow(row);
        }
        
        JTable table = new JTable(model);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Bold", Font.BOLD, 13));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        viewTabel.displayCenter(table);
        JScrollPane scrollPane = new JScrollPane(table);
        table.getTableHeader().setResizingAllowed(false);   // Cho phép thay đổi kích thước cột
        table.getTableHeader().setReorderingAllowed(false);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        
        setSize(900, 600);
        setLocationRelativeTo(parent);
        setModal(true);
    }
}
