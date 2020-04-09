import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Orders {
    static void orders() {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umuzi",
                "postgres", "password");
             Statement sqlStatement = connection.createStatement()) {

            // SQL Commands Select all unique statuses from the Orders table and get a count of the number of orders for each unique status.

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println("ERROR: Not connected to a database,Please connect to the umuzi database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
