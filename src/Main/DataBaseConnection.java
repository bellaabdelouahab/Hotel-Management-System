package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseConnection {

    String db = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hotel_bd";
    String password = "hotel";

    Connection connection;
    Statement statement;
    ResultSet result;
    private String compte;

    // connect to the data base
    public void ConnectToDataBase() {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            System.out.println("Connection Had Worked");

        } catch (Exception e) {
            System.out.println("Data Base Connection Problem" + e);
        }
    }

    // login using data base information
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
    public ArrayList<String[]> GetSearchedRoom(int[] INTData ,String[] StringData) {
        try {
            statement = connection.createStatement();
            //String Sql ="SELECT * FROM rooms WHERE NUM_ADUL = "+INTData[0]+"AND NUM_CHILD = "+INTData[1] +"AND CLASSE="+INTData[2]+" AND (PRIX BETWEEN "+INTData[3]+" AND "+INTData[4]+")"+"and DATE_ENTRE between to_date("+StringData[1]+",'MM/DD/YYYY') and to_date("+StringData[1]+",'MM/DD/YYYY'))";
            String Sql="select id_room,num_adul,num_child,prix from rooms where (PRIX between "+INTData[3]+" and "+INTData[4]+") and classe="+INTData[2]+" and num_child between 0 and "+INTData[1] +" and num_adul between 1 and "+INTData[0];
            result = statement.executeQuery(Sql);
            ArrayList<String[]> RoomData = new ArrayList<String[]>();
            while (result.next()) {
                String[] Line = new String[4];
                Line[0]=(String.valueOf(result.getInt("id_room")));
                Line[1]=(String.valueOf(result.getInt("num_adul")));
                Line[2]=(String.valueOf(result.getInt("num_child")));
                Line[3]=(String.valueOf(result.getInt("prix")));
                RoomData.add(Line);
            }   
            return RoomData;
        } catch (Exception e) {
            System.out.println("ach ahda ahmadi"+e);
            return null ;
        }
    }
    // return count of DashBoard
    public ResultSet ReturnCount(String Table) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT COUNT(*) FROM " + Table+" WHERE ID_EMP <> 1";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
        return result;
    }

    // update admin profile
    public void UpdateProfile(String FULL_NAME, String EMAIL, String PASSWORD, String PHONE_NUMBER) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "UPDATE employee SET FULL_NAME = '" + FULL_NAME + "',EMAIL = '" + EMAIL + "',PASSWORD = '"
                    + PASSWORD + "',PHONE_NUMBER = '" + PHONE_NUMBER + "'WHERE ID_EMP = 1";
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
    }
    //Get emailes History
    public String[] GetEmailesHistory() throws SQLException{
        statement = connection.createStatement();
        String rs = "select * from LOGINLOG";
        result = statement.executeQuery(rs);
        ArrayList<String> EmailesHistory = new ArrayList<String>();
        while (result.next()) {
        EmailesHistory.add(result.getString("Email"));
        }
        for(String Email : EmailesHistory){
            System.out.println("Email: " + Email);
        }
        return EmailesHistory.toArray(new String[EmailesHistory.size()]);
    }
    //Add to Emailes History
    public void AddEmailToHistory(String Email) throws SQLException{
        statement = connection.createStatement();
        String[] EmailesHistory = GetEmailesHistory();
        for (int i = 0; i < EmailesHistory.length;i++){
            if(EmailesHistory[i].equals(Email))
            return ;
        }
        statement.executeUpdate("INSERT INTO LOGINLOG VALUES('"+ Email+"')");
    }
    // get all employers accounts
    public ResultSet GetAllEmployers() {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM EMPLOYEE WHERE ID_EMP <> 1";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
        return result;
    }

    // Add users to the table
    public void AddUsers(String Full_name, String Adresse, String Email, String Password, String Natio, int age,
            String Phone, int salary, int commition, String type) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "INSERT INTO EMPLOYEE VALUES((SELECT COUNT(*) FROM EMPLOYEE) + 1 , '" + Full_name + "','"
                    + Adresse + "','" + Email + "','" + Password + "','" + Natio + "','h'," + age + ",'" + Phone + "',"
                    + salary + "," + commition + ",'" + type + "')";
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }


    //Delete User From Table
    public void DeleteUser(int ID_EMP){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "DELETE FROM EMPLOYEE WHERE ID_EMP = "+ID_EMP;
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No"+e);
        }
    }

    //Modify User From Table
    public void ModifyUser(String FULL_NAME , String ADRESSE , String EMAIL ,String PASSWORD , String NATIO , int AGE , String PHONE_NUMBER , int SAL , int COMM , String TYPE , int ID){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "UPDATE employee SET FULL_NAME = '"+FULL_NAME+"',ADRESSE = '"+ADRESSE+"',EMAIL = '"+EMAIL+"',PASSWORD = '"+PASSWORD+"',NATIONNALITY = '"+NATIO+"',SEX = 'h',AGE = '"+AGE+"',PHONE_NUMBER = '"+PHONE_NUMBER+"',SALAIRE = "+SAL+",COMMISSION = "+COMM+",TYPE_TRAVAILLE = '"+TYPE+"'WHERE ID_EMP = "+ID;
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No"+e);
        }
    }

    //Disconnect from the Data Base
    public void Disconnect(){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Problem");
        }   
    }

    // hamza functions

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

    // arreter connexion
    public void dormir() throws Exception {
        this.connection.close();
        this.statement.close();
    }

    public void setCompte(String d) {
        this.compte = d;
    }

    public String getCompte() {
        return compte;
    }

    public ResultSet reserv(String x) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select Distinct B.cin,B.last_name||b.first_name,C.ID_ROOM,C.CLASSE,C.DATE_ENTRE,C.prix from reservation A,client B,rooms C, employee D where  C.id_reserv in (select id_reserv from reservation where id_emp=(select id_emp from employee where lower(email)='"
                    + x
                    + "')) and B.id_reserv in (select id_reserv from reservation where id_emp=(select id_emp from employee where lower(email)='"
                    + x + "')) and A.id_emp= (select id_emp from employee where lower(email)='" + x + "')";
            result = statement.executeQuery(rs);
            // while (result.next()) {
            // System.out.println(result.getInt(1) + "\n" + result.getString(2) + "\n" +
            // result.getInt(3));
            // }
        } catch (Exception e) {
            System.out.println("Aha ahmadi" + e);
        }
        return result;
    }
}
