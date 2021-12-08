import java.sql.*;

public class DataBaseConnection {
    public static void main(String[] args) {
        // Information About Login 
        String db = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "hotel_bd";
        String password = "hotel";

        // Inisialisation of Connection
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(db, username, password);
            String sql = "INSERT INTO STUDENT VALUES(7 , 'HELLO' , 30)";
            Statement statement = connection.createStatement();
            int test = statement.executeUpdate(sql);

            // Test The connection
            if (test > 0) {
                System.out.println("Connected Succesfuly");
            }
            statement.close();
            connection.close();

        // catch Error 
        }catch(Exception e) {

            System.out.println("Connexion Not Working");

        }
    }
}