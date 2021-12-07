import java.sql.*;

public class DataBaseConnection {
    public static void main(String[] args) {
        String db = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "hotel_bd";

        String password = "hotel";// "insert into employee values (1,'admin','hotel',null,null,null,'admin')",
        // String[] j = {
        //         "insert into compte_employee values (1,'yassine@gmail.com','yassine',2)",
        //         "insert into compte_employee values (2,'bella@gmail.com','abdelwahab',3)",
        //         "insert into compte_employee values (3,'bousslama@gmail.com','hamza',4)",
        //         "insert into compte_employee values (4,'el_bazzi@gmail.com','hiba',5)"
        // };

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(db, username, password);
            Statement statement = connection.createStatement();

            int rest = statement
                    .executeUpdate("insert into compte_employee values (4,'el_bazzi@gmail.com','hiba',5)");
            if (rest > 0) {
                System.out.println("its working");
            }

            // ResultSet rs = st.executeQuery(query);
            // try {
            // while (rs.next()) {
            // System.out.println("id \t" + rs.getInt(1));
            // System.out.println("no_etude \t" + rs.getString(2));
            // System.out.println("sigle \t" + rs.getString(3));
            // System.out.println("sigle \t" + rs.getString(4));
            // System.out.println("sigle \t" + rs.getInt(5));
            // System.out.println("sigle \t" + rs.getInt(6));
            // System.out.println("sigle \t" + rs.getString(7));
            // }
            // } catch (Exception e) {
            // System.out.println("wtffffffffffffffff");
            // }}

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("dor tqwd2 " + e);
        }
    }

}
