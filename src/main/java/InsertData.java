import java.sql.*;

public class InsertData {
    static void insertDataToTable () {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umuzi",
                "postgres", "password");
             Statement sqlStatement = connection.createStatement()) {

            sqlStatement.execute(sqlInsertIntoCustomerTable(1,"John", "Hibert", "Male", "284 chaucer st", "084789657", "john@gmail.com", "Johannesburg", "South Africa"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(2,"Thando", "Sithole", "Female", "240 Sect 1", "0794445584", "thando@gmail.com", "Cape Town", "South Africa"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(3,"Leon", "Glen", "Male", "81 Everton Rd,Gillits", "0820832830", "Leon@gmail.com", "Durban", "South Africa"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(4,"Charl", "Muller", "Male", "290A Dorset Ecke", "+44856872553", "Charl.muller@yahoo.com", "Berlin", "Germany"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(5,"Julia", "Stein", "Female", "2 Wernerring", "+448672445058", "Js234@yahoo.com", "Frankfurt", "Germany"));

            sqlStatement.execute(sqlInsertIntoOrdersTable(1,1,2,Date.valueOf("05-09-2018"),Date.valueOf(""),"Not Shipped"));
            sqlStatement.execute(sqlInsertIntoOrdersTable(1,2,2,Date.valueOf("04-09-2018"),Date.valueOf("04-09-2018"),"Shipped"));
            sqlStatement.execute(sqlInsertIntoOrdersTable(3,3,3,Date.valueOf("05-09-2018"),Date.valueOf(""),"Not Shipped"));

            sqlStatement.execute(sqlInsertIntoPaymentsTable(1,1,Date.valueOf("03-09-2018"),150.75));
            sqlStatement.execute(sqlInsertIntoPaymentsTable(5,2,Date.valueOf("03-09-2018"),150.75));
            sqlStatement.execute(sqlInsertIntoPaymentsTable(4,3,Date.valueOf("03-09-2018"),700.60));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println("ERROR: Not connected to a database,Please connect to the umuzi database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sqlInsertIntoCustomerTable(int id,String firstName, String lastName, String gender, String address, String phone, String email, String city, String country) {
        return "insert into customer (id,first_name,last_name,gender,address,phone,email,city,country)" +
                "values ('"+id+"','" + firstName + "','" + lastName + "','" +
                gender + "','" + address + "','" + phone + "','" + email + "','" + city + "','" + country + "')";
    }

    private static String sqlInsertIntoOrdersTable(int product_id, int payments_id, int fulfiiledByEmployeeId, Date dateRequired, Date dateShipped, String status) {
        return "insert into customer (product_id,payments_id,fulfiiled_by_employee_id,date_required,date_shipped,status)" +
                "values ('"+product_id+"','" +payments_id+ "','" +fulfiiledByEmployeeId+ "','" +
                dateRequired+ "','" + dateShipped + "','" +status+ "')";
    }

    private static String sqlInsertIntoPaymentsTable(int customerId, int paymentsId, Date paymentsDate, double amount) {
        return "insert into customer (customer_id,payments_id,payments_date,amount)" +
                "values ('"+customerId+"','" +paymentsId+ "','" +paymentsDate+ "','" + amount+ "')";

    }

}
