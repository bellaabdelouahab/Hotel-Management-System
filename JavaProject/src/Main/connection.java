package Main;

import java.sql.*;

public class connection {

    String db = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "hotel_bd";
    String password = "hotel";

    Connection connection;
    Statement statement;
    ResultSet result;

    public void ConnectToDataBase() {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            System.out.println("Connection Had Worked");

        } catch (Exception e) {
            System.out.println("Data Base Connection Problem" + e);
        }
    }

    // hamza functions
    public ResultSet LoginWithDataBase(String EMAIL, String PASSWORD) {

        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM EMPLOYEE WHERE LOWER(EMAIL) = LOWER('" + EMAIL
                    + "') AND LOWER(PASSWORD) = LOWER('" + PASSWORD + "')";
            result = statement.executeQuery(Sql);

        } catch (Exception e) {
            System.out.println("Not Working");
        }

        return result;
    }

    // my functions
    public ResultSet Login_employ(String x) {
        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select * from employee where lower(email)='" + x + "'";
            result = statement.executeQuery(rs);

        } catch (Exception e) {
            System.out.println("Aha ahmadi");
        }
        return result;
    }

    public ResultSet Login_employe(String x) {
        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select * from employee where lower(email)='" + x + "'";
            result = statement.executeQuery(rs);

        } catch (Exception e) {
            System.out.println("Aha ahmadi");
        }
        return result;
    }

    public int adre_profile_change(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set adresse='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }

    public int natio_profile_change(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set nationnality='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }

    public int phone_profile_change(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set phone_number='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }

    public int age_profile_change(int x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set age='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }

    public int change_password(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set password='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }

    // reservation
    public ResultSet reserv(String x) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select Distinct B.cin,B.last_name||b.first_name,C.ID_ROOM,C.CLASSE,C.DATE_ENTRE,C.prix from reservation A,client B,rooms C, employee D where  C.id_reserv in (select id_reserv from reservation where id_emp=(select id_emp from employee where lower(email)='"+x+"')) and B.id_reserv in (select id_reserv from reservation where id_emp=(select id_emp from employee where lower(email)='"+x+"')) and A.id_emp= (select id_emp from employee where lower(email)='"+x+"')";
            result = statement.executeQuery(rs);
            // while (result.next()) {
            //     System.out.println(result.getInt(1) + "\n" + result.getString(2) + "\n" + result.getInt(3));
            // }
        } catch (Exception e) {
            System.out.println("Aha ahmadi"+e);
        }
        return result;
    }

    // arreter connexion
    public void dormir() throws Exception {
        this.connection.close();
        this.statement.close();
    }
}
