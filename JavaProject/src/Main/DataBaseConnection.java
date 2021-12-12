package Main;

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
