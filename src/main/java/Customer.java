import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {


    static void customer() {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umuzi",
                "postgres", "password");
             Statement sqlStatement = connection.createStatement()) {



            connection.setAutoCommit(false);

        //  Adding table to database
            sqlStatement.execute(sqlCreateCustomerTable);

            sqlStatement.execute(sqlInsertIntoCustomerTable(1,"John", "Hibert", "Male", "284 chaucer st", "084789657", "john@gmail.com", "Johannesburg", "South Africa"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(2,"Thando", "Sithole", "Female", "240 Sect 1", "0794445584", "thando@gmail.com", "Cape Town", "South Africa"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(3,"Leon", "Glen", "Male", "81 Everton Rd,Gillits", "0820832830", "Leon@gmail.com", "Durban", "South Africa"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(4,"Charl", "Muller", "Male", "290A Dorset Ecke", "+44856872553", "Charl.muller@yahoo.com", "Berlin", "Germany"));
            sqlStatement.execute(sqlInsertIntoCustomerTable(5,"Julia", "Stein", "Female", "2 Wernerring", "+448672445058", "Js234@yahoo.com", "Frankfurt", "Germany"));

            System.out.println("Connected to PostgreSQL database!");

            // SQL Commands SELECT ALL records from table Customers.

            System.out.println("\nSELECT ALL records from table Customers.");
            System.out.printf("%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                    "id","First Name", "Last Name", "Gender", "Address", "Phone", "Email", "City", "Country");
            ResultSet resultSet = sqlStatement.executeQuery("select * from customer");
            while (resultSet.next()) {
                System.out.printf("\n%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                        resultSet.getString("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("city"),
                        resultSet.getString("country"));
            }

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
            System.out.printf("%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                    "id","First Name", "Last Name", "Gender", "Address", "Phone", "Email", "City", "Country");
            while (resultSelectById.next()) {
                System.out.printf("\n%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                        resultSelectById.getString("id"),
                        resultSelectById.getString("first_name"),
                        resultSelectById.getString("last_name"),
                        resultSelectById.getString("gender"),
                        resultSelectById.getString("address"),
                        resultSelectById.getString("phone"),
                        resultSelectById.getString("email"),
                        resultSelectById.getString("city"),
                        resultSelectById.getString("country"));
            }


            // SQL Commands UPDATE the record for CustomerID = 1 on the Customer table so that the name is “Lerato Mabitso”.

            System.out.println("\n" + "\nUPDATE the record for CustomerID = 1 on the Customer table so that the name is “Lerato Mabits");
            ResultSet resultUpdateById = sqlStatement.executeQuery("update customer set first_name = 'Lerato' , last_name = 'Mabitso' where id = 1");
            System.out.printf("%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                    "id","First Name", "Last Name", "Gender", "Address", "Phone", "Email", "City", "Country");
            while (resultUpdateById.next()) {
                System.out.printf("\n%-20.30s %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s  %-20.30s",
                        resultUpdateById.getString("id"),
                        resultUpdateById.getString("first_name"),
                        resultUpdateById.getString("last_name"),
                        resultUpdateById.getString("gender"),
                        resultUpdateById.getString("address"),
                        resultUpdateById.getString("phone"),
                        resultUpdateById.getString("email"),
                        resultUpdateById.getString("city"),
                        resultUpdateById.getString("country"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.err.println(" Failed to make connection!");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Opened database successfully");

    }


    private static String sqlInsertIntoCustomerTable(int id,String firstName, String lastName, String gender, String address, String phone, String email, String city, String country) {
        return "insert into customer (id,first_name,last_name,gender,address,phone,email,city,country)values ('"+id+"','" + firstName + "','" + lastName + "','" +
                gender + "','" + address + "','" + phone + "','" + email + "','" + city + "','" + country + "')";

    }

    private static String sqlSelectById(int id){
        return "select * from customer  where = '"+id+"'";
    }
    private static String sqlUpdateRecord(int id,String firstName,String lastname){
        return "update customer set first_name = '"+firstName+"' , last_name = '"+lastname+"' where id = '"+id+"'";
    }
    private static final String selectAllCustomer = "select * from customer";
//    private static final String sqlInsertIntoCustomerTable = "insert into customer (first_name,last_name,gender,address,phone,email,city,country)" +
//            " values (?,?,?,?,?,?,?,?)";


    private static final String sqlCreateCustomerTable = "create table if not exists customer (\n" +
            "id serial not null primary key,\n" +
            "first_name varchar(50) not null,\n" +
            "last_name varchar(50) not null,\n" +
            "gender varchar(6) not null,\n" +
            "address varchar(200) not null,\n" +
            "phone varchar(20) not null,\n" +
            "email varchar(100),\n" +
            "city varchar(20) not null,\n" +
            "country varchar(50) not null\n" +
            ")";
}
