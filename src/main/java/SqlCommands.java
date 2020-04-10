import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlCommands {


    static void customer() {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umuzi",
                "postgres", "password");
             Statement sqlStatement = connection.createStatement()) {

            connection.setAutoCommit(false);

            //SQL Commands Show all Records on Tables
            ResultSet resultShowCustomerTable = sqlStatement.executeQuery("select * from customer;");
            result(resultShowCustomerTable);

            // SQL Commands SELECT records only from the name column in the Customers table.
            System.out.println("\n" + "\nSELECT records only from the name column in the Customers table.");
            System.out.printf("%-20.30s", "First Name");
            ResultSet resultSetFullname = sqlStatement.executeQuery("select first_name from customer");
            while (resultSetFullname.next()) {
                System.out.printf("\n%-20.30s", resultSetFullname.getString("first_name"));
            }

            // SQL Commands Show the name of the Customer whose CustomerID is 1.
            System.out.println("\n" + "\nShow the name of the Customer whose CustomerID is 1");
            ResultSet resultSelectById = sqlStatement.executeQuery("select * from customer where id = 1");
            result(resultSelectById);

            // SQL Commands UPDATE the record for CustomerID = 1 on the Customer table so that the name is “Lerato Mabitso”.
            sqlStatement.executeUpdate("update customer set first_name = 'Lerato' , last_name = 'Mabitso' where id = 1");

           //SQL Commands  DELETE the record from the Customers table for customer 2 (CustomerID = 2).
            sqlStatement.executeUpdate("delete from customer where id = 2");

            //SQL Commands  Show updated Customer Table.
            System.out.println("\n"+"\n Updated Customer Table ");
            ResultSet resultShowCustomerTableDelete = sqlStatement.executeQuery(" select * from customer;");
            result(resultShowCustomerTableDelete);

            //SQL Commands Select all unique statuses from the Orders table and get a count of the number of orders for each unique status.
            sqlStatement.executeUpdate("select distinct count(*) from orders");
            ResultSet resultUniquesStatements = sqlStatement.executeQuery("select distinct count(*) from orders");
            while (resultUniquesStatements.next()) {
                System.out.printf("\n%-20.30s", resultUniquesStatements.getString(""));
            }

            //SQL Commands Return the MAXIMUM payment made on the PAYMENTS table.
            ResultSet resultMaxAmonut = sqlStatement.executeQuery("select max(amount) from payments");
            while (resultMaxAmonut.next()) {
                System.out.printf("\n%-20.30s", resultMaxAmonut.getString("amount"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.err.println(" Failed to make connection!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
         // Table Row Mapper
    private static void result(ResultSet resultformat) throws SQLException {
        System.out.printf("%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                "id","First Name", "Last Name", "Gender", "Address", "Phone", "Email", "City", "Country");
        while (resultformat.next()) {
            System.out.printf("\n%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                    resultformat.getString("id"),
                    resultformat.getString("first_name"),
                    resultformat.getString("last_name"),
                    resultformat.getString("gender"),
                    resultformat.getString("address"),
                    resultformat.getString("phone"),
                    resultformat.getString("email"),
                    resultformat.getString("city"),
                    resultformat.getString("country"));
        }
    }
}
