import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class tst {
    public static void main(String[] args) throws Exception {
        String db = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "hotel_bd";
        String password = "hotel";

        Connection connection;
        Statement statement;
        connection = DriverManager.getConnection(db, username, password);
        statement = connection.createStatement();
        // Date d=java.sql.Date.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
        // Date s = java.sql.Date.valueOf(LocalDate.of(2021, 12, 22).format(DateTimeFormatter.ofPattern("dd-MMM-yy")));

        LocalDate d = LocalDate.now(); 
        LocalDate s=LocalDate.of(2021, 12, 22);
        String DATE_FORMATTER= "dd-MM-YYYY";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = d.format(formatter);
        String formatDateTime2 = s.format(formatter);
        System.out.println("Formatted Time :" +formatDateTime+"\n dat 2"+formatDateTime2);

        // System.out.println(d + "\t" + s);
        String requt = "insert into reservation values ((select count(*) as co from reservation)+1,to_date('" + formatDateTime+ "','DD/MM/YYYY'),to_date('" + formatDateTime2+ "','DD/MM/YYYY'),(select count(*) as co from client),(select id_emp from employee where lower(email)='yassine@gmail.com'),"+ 3 + ")";
        int y = statement.executeUpdate(requt);
        if (y > 0) {
            System.out.println("oh yeah");
        } else {
            System.out.println("oh non");
        }
    }
}
