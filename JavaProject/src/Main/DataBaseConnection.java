package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {

    String db = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "system";
    String password = "oracle";

    Connection connection;
    Statement statement;
    ResultSet result;

    public void ConnectToDataBase(){
        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            System.out.println("Connection Had Worked");

        } catch (Exception e) {
            System.out.println("Data Base Connection Problem");
        }

    }

    public ResultSet LoginWithDataBase(String EMAIL , String PASSWORD){

        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM EMPLOYEE WHERE LOWER(EMAIL) = LOWER('"+EMAIL+"') AND LOWER(PASSWORD) = LOWER('"+PASSWORD+"')";
            result = statement.executeQuery(Sql);

        }catch (Exception e) {
            System.out.println("Not Working");
        }

        return result;
    }
}
