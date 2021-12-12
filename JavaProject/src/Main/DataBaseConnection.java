package Main;

<<<<<<< HEAD
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

    public ResultSet LoginWithDataBase(String NAM){

        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM STUDENT WHERE LOWER(NOM) = LOWER('"+NAM+"')";
            result = statement.executeQuery(Sql);
        }catch (Exception e) {
            System.out.println("Not Working");
        }
        return result;
    }

}
=======
import java.sql.*;
public class DataBaseConnection {
    Connection DataBaseConnecter; 
    public DataBaseConnection(){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                this.DataBaseConnecter = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd","hotel");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
    public void Login(String Email){
        try {
            Statement st = this.DataBaseConnecter.createStatement();
            ResultSet rs = st.executeQuery(
                            "select * from employee where lower(email)='" + Email.toLowerCase() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
>>>>>>> e70f080041c049d91d783ed38c057c6c3920bbdb
