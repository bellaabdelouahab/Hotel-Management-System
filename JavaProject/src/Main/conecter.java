package Main;

import java.sql.*;

public class conecter {
    Statement st;
    Connection con;

    public conecter() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hotel_bd",
                "hotel");
    }

    public Statement getSte() throws Exception{
        
        return this.st=con.createStatement();
    }
}
