import java.sql.*;

public class Payments {
    static void payments() {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umuzi",
                "postgres", "password");
             Statement sqlStatement = connection.createStatement()) {

            // SQL Commands Return the MAXIMUM payment made on the PAYMENTS table.

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println("ERROR: Not connected to a database,Please connect to the umuzi database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
