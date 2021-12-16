package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {

    String db = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hotel_bd";
    String password = "hotel";

    Connection connection;
    Statement statement;
    ResultSet result;
    private String compte;

    //connect to the data base
    public void ConnectToDataBase() {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            System.out.println("Connection Had Worked");

        } catch (Exception e) {
            System.out.println("Data Base Connection Problem" + e);
        }
    }

    //login using data base information
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

    // return count of DashBoard
    public ResultSet ReturnCount(String Table){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT COUNT(*) FROM "+Table;
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
        return result;
    }

    // update admin profile
    public void UpdateProfile(String FULL_NAME , String EMAIL , String PASSWORD , String PHONE_NUMBER){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "UPDATE employee SET FULL_NAME = '"+FULL_NAME+"',EMAIL = '"+EMAIL+"',PASSWORD = '"+PASSWORD+"',PHONE_NUMBER = '"+PHONE_NUMBER+"'WHERE ID_EMP = 1";
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
    }

    //get all employers accounts
    public ResultSet GetAllEmployers(){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM EMPLOYEE";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
        return result;
    }

    //Add users to the table
    public void AddUsers(String Full_name , String Adresse , String Email , String Password , String Natio , int age , String Phone ,int salary , int commition , String type){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "INSERT INTO EMPLOYEE VALUES((SELECT COUNT(*) FROM EMPLOYEE) + 1 , '"+Full_name+"','"+Adresse+"','"+Email+"','"+Password+"','"+Natio+"','h',"+age+",'"+Phone+"',"+salary+","+commition+",'"+type+"')";    
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No"+e);
        }
    }


    // hamza functions



    // my functions
    public ResultSet Login_employ(String x){
        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select * from employee where lower(email)='" + x + "'";
            result = statement.executeQuery(rs);

        }catch (Exception e) {
            System.out.println("Aha ahmadi");
        }
        return result;
    }
    public ResultSet Login_employe(String x){
        try {

            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select * from employee where lower(email)='" + x + "'";
            result = statement.executeQuery(rs);

        }catch (Exception e) {
            System.out.println("Aha ahmadi");
        }
        return result;
    }

    public int adre_profile_change(String x,int y) throws Exception{
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set adresse='" + x + "'where id_emp='"  + y + "'";
        int res=statement.executeUpdate(rs);
        return res;
    }

    public int natio_profile_change(String x,int y) throws Exception{
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set nationnality='" + x + "'where id_emp='"  + y + "'";
        int res=statement.executeUpdate(rs);
        return res;
    }
    public int phone_profile_change(String x,int y) throws Exception{
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set phone_number='" + x + "'where id_emp='"  + y + "'";
        int res=statement.executeUpdate(rs);
        return res;
    }
    public int age_profile_change(int x,int y) throws Exception{
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set age='" + x + "'where id_emp='"  + y + "'";
        int res=statement.executeUpdate(rs);
        return res;
    }

    public int change_password(String x,int y) throws Exception{
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set password='"+ x + "'where id_emp='"  + y + "'";
        int res=statement.executeUpdate(rs);
        return res;
    }
    // arreter connexion
    public void dormir() throws Exception{
        this.connection.close();
        this.statement.close();
    } 
    public void setCompte(String d) {
        this.compte = d;
    }

    public String getCompte() {
        return compte;
    }
}
