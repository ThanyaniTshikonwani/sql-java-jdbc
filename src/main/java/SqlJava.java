import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlJava {

    private final String url = "jdbc:postgresql://localhost:5432/umuziDb";
    private final String user = "postgres";
    private final String password = "<add your password>";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        SqlJava app = new SqlJava();
        app.connect();
//        String driver ="org.postgresql.Driver";
//        String db = "jdbc:postgresql://localhost:5432/umuziDb";
//        try {
//            Class.forName(driver);
//            Connection connection = DriverManager.getConnection(db,"postgres","pass");
//
////            Statement statement = connection.createStatement();
////            statement.executeUpdate("select * from customer");
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");
//            preparedStatement.executeUpdate();
//
//            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from employees");
//            preparedStatement1.executeUpdate();
//
//            PreparedStatement preparedStatement2 = connection.prepareStatement("select first_name from customer");
//            preparedStatement2.executeUpdate();
//
//
//            PreparedStatement preparedStatement3 = connection.prepareStatement("select * from customer where id = 1");
//            preparedStatement3.executeUpdate();
//
//            PreparedStatement preparedStatement4 = connection.prepareStatement("update customer set first_name = 'Lerato' , last_name = 'Mabitso' where id = 1");
//            preparedStatement4.executeUpdate();
//
//            PreparedStatement preparedStatement5 = connection.prepareStatement("select * from customer");
//            preparedStatement5.executeUpdate();
//
//            PreparedStatement preparedStatement6= connection.prepareStatement("delete from customer where id = 2");
//            preparedStatement6.executeUpdate();
//
//            PreparedStatement preparedStatement7= connection.prepareStatement("delete from customer where id = 2");
//            preparedStatement7.executeUpdate();
//
//
//
//
//        } catch (ClassNotFoundException |  SQLException ex) {
//            Logger.getLogger(SqlJava.class.getName()).log(Level.SEVERE,null,ex);
//        }
//
//
//

  }

}
