package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

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
            statement  = connection.createStatement();
            String Sql =  "SELECT * FROM EMPLOYEE WHERE LOWER(EMAIL) = LOWER('" + EMAIL.toLowerCase()
                        + "') AND LOWER(PASSWORD) = LOWER('" + PASSWORD.toLowerCase() + "')";
            result     = statement.executeQuery(Sql);
        }
        catch (Exception e) {
            System.out.println("Not Working");
        }
        return result;
    }
    //GetSearchedRoom
    public ArrayList<String[]> GetSearchedRoom(int[] INTData, String[] StringData) {
        try {
            statement  = connection.createStatement();
            String Sql =  "select id_room,num_adul,num_child,prix from rooms where (PRIX between " + INTData[3] + " and "
                        + INTData[4] + ") and classe=" + INTData[2] + " and (num_child between 0 and " + INTData[1]
                        + ") and (num_adul between 1 and " + INTData[0] + ")";
            result     = statement.executeQuery(Sql);
            ArrayList<String[]> RoomData = new ArrayList<String[]>();
            while (result.next()) {
                String[] Line = new String[4];
                Line[0] = (String.valueOf(result.getInt("id_room")));
                Line[1] = (String.valueOf(result.getInt("num_adul")));
                Line[2] = (String.valueOf(result.getInt("num_child")));
                Line[3] = (String.valueOf(result.getInt("prix")));
                RoomData.add(Line);
                System.out.println(Arrays.toString(Line));
            }
            return RoomData;
        } catch (Exception e) {
            System.out.println("ach ahda ahmadi\t" + e);
            return null;
        }
    }
    // return count of DashBoard
    public ResultSet ReturnCount(String Table) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement  = connection.createStatement();
            String Sql = "SELECT COUNT(*) FROM " + Table;
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
            statement  = connection.createStatement();
            String Sql = "UPDATE employee SET FULL_NAME = '" + FULL_NAME + "',EMAIL = '" + EMAIL + "',PASSWORD = '"
                        + PASSWORD + "',PHONE_NUMBER = '" + PHONE_NUMBER + "'WHERE ID_EMP = 1";
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("Not Working");
        }
    }
    // Get emailes History
    public String[] GetEmailesHistory() throws SQLException {
        statement = connection.createStatement();
        String rs = "select * from LOGINLOG";
        result    = statement.executeQuery(rs);
        ArrayList<String> EmailesHistory = new ArrayList<String>();
        while (result.next()) {
            EmailesHistory.add(result.getString("Email"));
        }
        return EmailesHistory.toArray(new String[EmailesHistory.size()]);
    }
    // Add to Emailes History
    public void AddEmailToHistory(String Email) throws SQLException {
        statement = connection.createStatement();
        String[] EmailesHistory = GetEmailesHistory();
        for (int i = 0; i < EmailesHistory.length; i++) {
            if (EmailesHistory[i].equals(Email))
                return;
        }
        statement.executeUpdate("INSERT INTO LOGINLOG VALUES('" + Email + "')");
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
    public void AddUsers(String Full_name, String Adresse, String Email, String Password, String Natio, String Se,
            int age, String Phone, int salary, int commition, String type) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "INSERT INTO EMPLOYEE VALUES((SELECT COUNT(*)+30 FROM EMPLOYEE) , '" + Full_name + "','"
                    + Adresse + "','" + Email + "','" + Password + "','" + Natio + "','" + Se + "'," + age + ",'"
                    + Phone + "',"
                    + salary + "," + commition + ",'" + type + "')";
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // Delete User From Table
    public void DeleteUser(int ID_EMP) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql1 = "DELETE FROM RESERVATION WHERE ID_EMP = (SELECT ID_EMP FROM EMPLOYEE WHERE ID_EMP = "+ID_EMP+")";
            String Sql2 = "DELETE FROM EMPLOYEE WHERE ID_EMP = " + ID_EMP;
            statement.executeUpdate(Sql1);
            statement.executeUpdate(Sql2);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // GET ALL THE ROOMS INFORMATION
    public ResultSet GetRoomsInformation(){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM ROOMS";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
        return result;
    }
      //GET ALL THE CLIENTS INFORMATIONS
    public ResultSet GetClientInformation(){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM Client";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
        return result;

    }
    //GET ALL THE reservation INFORMATIONS
    public ResultSet GetReservationInformation(){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM reservation";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
        return result;
    }
    //Get all sign up information
    public ResultSet GetSignUpInformation(){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM sign_up";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
        return result;
    }
    // Delete SignUp Information
    public void DeleteReservation(int ID_SIGNUP){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "DELETE FROM sign_up WHERE id = " + ID_SIGNUP;
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // Modify User From Table
    public void ModifyUser(String FULL_NAME, String ADRESSE, String EMAIL, String PASSWORD, String NATIO, String SE,
            int AGE, String PHONE_NUMBER, int SAL, int COMM, String TYPE, int ID) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement  = connection.createStatement();
            String Sql = "UPDATE employee SET FULL_NAME = '" + FULL_NAME + "',ADRESSE = '" + ADRESSE + "',EMAIL = '"
                    + EMAIL + "',PASSWORD = '" + PASSWORD + "',NATIONNALITY = '" + NATIO + "',SEX = '" + SE
                    + "',AGE = '" + AGE + "',PHONE_NUMBER = '" + PHONE_NUMBER + "',SALAIRE = " + SAL + ",COMMISSION = "
                    + COMM + ",TYPE_TRAVAILLE = '" + TYPE + "'WHERE ID_EMP = " + ID;
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // get the modify information
    public ResultSet ModifyInfo(int ID) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT * FROM EMPLOYEE WHERE ID_EMP = " + ID;
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
        return result;
    }
    // return DashBoard Data
    public ResultSet DashBoardData() {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "SELECT R.DATE_DE_RESERVER , P.PRIX FROM RESERVATION R , ROOMS P WHERE R.ID_ROOM = P.ID_ROOM ORDER BY R.DATE_DE_RESERVER DESC";
            result = statement.executeQuery(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
        return result;
    }
    // add room function 
    public void AddRoom(int ADULT , int CHILD , int CLASS , int PRIC , String MORE ){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "INSERT INTO ROOMS VALUES((SELECT COUNT(*) FROM ROOMS) + 10 , "+ADULT+" , "+CHILD+", "+CLASS+" , "+PRIC+" , '"+MORE+"')"; 
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // modify a room
    public void ModifyRoom(int ADUL , int CHILD , int CLASS , int PRIX , String MORE,  int ID){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql = "UPDATE ROOMS SET NUM_ADUL = "+ADUL+", NUM_CHILD = "+CHILD+" , CLASSE = "+CLASS+" , PRIX = "+PRIX+" , contents_of_room = '"+MORE+"'  WHERE ID_ROOM = "+ID; 
            statement.executeUpdate(Sql);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // Delete A room
    public void DeleteRoom(int ID_ROOM){
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String Sql1 = "DELETE FROM RESERVATION WHERE ID_ROOM = (SELECT ID_ROOM FROM ROOMS WHERE ID_ROOM = "+ID_ROOM+")";
            String Sql2 = "DELETE FROM ROOMS WHERE ID_ROOM = " + ID_ROOM;
            statement.executeUpdate(Sql1);
            statement.executeUpdate(Sql2);
        } catch (Exception e) {
            System.out.println("No" + e);
        }
    }
    // Disconnect from the Data Base
    public void Disconnect() {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Problem");
        }
    }
    // hamzas functions
    public ResultSet Login_employ(String x) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select * from employee where lower(email)='" + x.toLowerCase() + "'";
            result = statement.executeQuery(rs);
        } catch (Exception e) {
            System.out.println("Aha ahmadi");
        }
        return result;
    }
    // Changing Address
    public int adre_profile_change(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set adresse='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }
    // Changing Nationality
    public int natio_profile_change(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set nationnality='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }
    // Changing Phonenumber
    public int phone_profile_change(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set phone_number='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }
    //Changing Age
    public int age_profile_change(int x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set age='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }
    //Changing Client Password
    public int change_password(String x, int y) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String rs = "update employee set password='" + x + "'where id_emp='" + y + "'";
        int res = statement.executeUpdate(rs);
        return res;
    }
    // Close connexion
    public void dormir() throws Exception {
        this.connection.close();
        this.statement.close();
    }
    // Keep track of user Account
    public void setCompte(String d) {
        this.compte = d;
    }
    // Get Tracked Account
    public String getCompte() {
        return compte;
    }
    // Get List of reserved Rooms
    public ResultSet reserv(String x) {
        try {
            connection = DriverManager.getConnection(db, username, password);
            statement = connection.createStatement();
            String rs = "select Distinct A.id_client ,A.first_name||A.last_name as full_name, D.ID_ROOM,D.CLASSE,D.contents_of_room,D.prix,B.date_de_reserver,B.date_de_sortir from client A,rooms D,reservation B,employee C where B.id_room = D.id_room and B.id_client = A.id_client and B.id_emp=C.id_emp and lower(C.email)='"
                    + x.toLowerCase() + "' order by A.id_client";
            result = statement.executeQuery(rs);
        } catch (Exception e) {
            System.out.println("Aha ahmadi" + e);
        }
        return result;
    }
    // reserver room
    public int reserverRoom(LocalDate date_entrer, LocalDate date_sortir, String emp, int room, String cin) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String SQL="insert into reservation values ((select count(id_reserv)+1 as co from reservation),TO_DATE('"+date_entrer.format(formatter)+"', 'dd-mm-yyyy'),TO_DATE('"+date_sortir.format(formatter)+"', 'dd-mm-yyyy'),"+Integer.parseInt(cin)+",(select id_emp from employee where lower(email)='"+emp.toLowerCase()+"'),"+room+")";
        int y = statement.executeUpdate(SQL);
        return y;
    }
    // add client
    public int addClient(String cin, String f_name, String l_name, String natio, String gender, String etat, String age) throws Exception {
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        int y = statement.executeUpdate("insert into client values (" + Integer.parseInt(cin) + ",'"+ f_name.toLowerCase() + "','" + l_name.toLowerCase() + "','" + natio.toLowerCase() + "','" + gender+ "','" + etat + "'," + Integer.parseInt(age) + ")");
        return y;
    }
    // notiication pour admin
    public int insertdb(String f_name,String l_name,String adr,String email,String sex,int age,String phone,String natio) throws Exception{
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        String v1="insert into sign_up values ((select count(*) from sign_up)+1,'"+f_name+"','"+l_name+"','"+adr+"','"+email+"','"+sex+"',"+age+",'"+phone+"','"+natio+"')";
        // "insert into sign_up values ((select count(*) from sign_up)+1,'"+adr+"','"+email+"','"+sex+"',"+age+",'"+phone+"','"+natio+"','"+f_name+"','"+l_name+"')");
        int y = statement.executeUpdate(v1);
        return y;
    }
    //Drop
    public void droped() throws Exception{
        statement = connection.createStatement();
        String v1="delete from client where id_client=(select count(*) from client)";
        int y=statement.executeUpdate(v1);
        if (y>0) {
            System.out.println("COOOOOL");
        } else {
            System.out.println("OH shit");
        }
    }
}
