import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class createVisitorTable {
    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.0.1:3306/nordicdb";
        String username = "root";
        String password = "nordicmv9400";

        try (Connection connection = DriverManager.getConnection(url,username, password)) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                String createTableSQL = "CREATE TABLE visitors (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "company_name VARCHAR(255)," +
                        "visitor_name VARCHAR(255)," +
                        "is_visiting BOOLEAN," +
                        "timestamp_changed TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                        "log VARCHAR(255)" +
                        ")";

                statement.executeUpdate(createTableSQL);

                System.out.println("Table 'visitors' created successfully");
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
