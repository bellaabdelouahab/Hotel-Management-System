
import java.sql.*;

public class DataBaseConnection {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // String server = "localhost";// "DESKTOP-SMO7HS9";
            // String server_port = "1521";
            //String sid = "orcl";
            //String url = "jdbc:oracle:thin:@" + server + ":" + server_port + ":orcl";
            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.192:1521/orcl","yassine", "yassine2002");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from e");
            while (rs.next()) {
                System.out.println("no_etude \t" + rs.getInt(1));
                System.out.println("sigle \t" + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("dor tqwd2 " + e);
        }
    }

}
