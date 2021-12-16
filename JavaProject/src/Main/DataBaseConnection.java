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
            String Sql = "SELECT * FROM EMPLOYEE WHERE ID_EMP <> 1";
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
            String Sql = "INSERT INTO EMPLOYEE VALUES(15 , '"+Full_name+"','"+Adresse+"','"+Email+"','"+Password+"','"+Natio+"','h',"+age+",'"+Phone+"',"+salary+","+commition+",'"+type+"')";    
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No"+e);
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

}
