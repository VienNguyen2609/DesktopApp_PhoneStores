
package DatabaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {

    private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String url = "jdbc:sqlserver://LAPTOP-O2P6UBC6:"
            + "1433;databaseName=PhoneStores;user=sa;password=YourNewStrongPassword;encrypt=true;trustServerCertificate=true";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }

    public static void getForName() throws ClassNotFoundException {
        Class.forName(driver);
    }

   
}
