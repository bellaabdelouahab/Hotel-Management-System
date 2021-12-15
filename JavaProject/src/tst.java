import java.sql.*;

public class tst {
    public static void main(String[] args) throws Exception {
        // String[] x = {
        // "insert into employee
        // values(1,'admin',null,'test@gmail.com','admin',null,null,null,null,null,null,'admin')",
        // "insert into employee values
        // (2,'yassineboujrada','casa','yassine@gmail.com','yassine2','marocaine','h',18,null,1000.00,2,'reserve')",
        // "insert into employee values
        // (3,'bellaabdelwahab','taroudanet','abdo@gmail.com','abdelwahab','marocaine','h',21,'0765432847',1100.00,1.7,'reserve')",
        // "insert into employee values
        // (4,'bousslamahamza','khouribga','hamza@gmail.com','hamza2002','marocaine','h',18,'0645739874',1500.00,3,'reserve')",
        // "insert into employee values (5,'el_bazzi
        // hiba','essaouira','hiba@gmail.com','hiiba2002','marocaine','f',18,'0765342310',1500.00,2,'reserve')",
        // "insert into employee values (6,'test
        // omar','essaouira','omar@gmail.com','test2002','tunisiene','h',20,'0645789374',5000,1.2,'menage')",
        // "insert into employee values (7,'test
        // khadija','agadir','khadija@gmail.com','khadija2','france','f',25,'0719738492',4500,0,'menage')"
        // };

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                "hotel_bd",
                "hotel");
        Statement st = con.createStatement();

        // for (int i = 0; i < x.length; i++) {
        // int rs = st.executeUpdate(x[i]);
        // if (rs > 0) {
        // System.out.println("oh boy");
        // } else {
        // System.out.println("ooh noo");
        // }
        // }
        String s = "create table client("+
            "cin Varchar2(8) CONSTRAINT client_pk primary key,"+
            "first_name varchar2(12),"+
            "last_name  varchar2(17),"+
            "nationality varchar2(10),"+
            "gender varchar2(3),"+
            "etat_civil varchar2(10),"+
            "age number(2),"+
            "id_reserv Number(3) CONSTRAINT reserver_fk REFERENCES reservation)";
        st.execute(s);
        System.out.println("oh yeah");
        // ResultSet rs = st.executeQuery("select count(*) as co from employee");
        // while (rs.next()) {System.out.println(rs.getInt("co"));}
        // for (int i = 0; i < x.length; i++) {
        // int rs = st.executeUpdate(x[i]);
        // if (rs > 0) {
        // System.out.println("oh boy");
        // } else {
        // System.out.println("ooh noo");
        // }
        // }

    }
}
