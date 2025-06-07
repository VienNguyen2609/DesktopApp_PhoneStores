package Controllers;

import DatabaseConnection.SQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author VIEN
 */
public class RevenueController {
    
    public List<Object[]> getRevenueByMonth(int month, int year) {
        List<Object[]> result = new ArrayList<>();
        
        try (Connection con = SQLConnector.getConnection()) {
            String sql = """
                         select namePhone, brandPhone, pricePhone, quantity, sum(pricePhone*quantity)
                         as [total]from Phones inner join OrderDetails on Phones.idPhone=OrderDetails.idPhone
                         \tinner join Orders on OrderDetails.idOrder=Orders.idOrder
                         WHERE month(timeOfBookingOrder)= ? AND year(timeOfBookingOrder)= ?
                         group by namePhone, brandPhone, pricePhone, quantity""";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, year);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString(1); // PhoneName
                row[1] = rs.getString(2); // Brand
                row[2] = rs.getInt(3);    // Quantity
                row[3] = rs.getDouble(4); // Price
                row[4] = rs.getDouble(5); // Total
                result.add(row);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        return result;
    }
    
}
