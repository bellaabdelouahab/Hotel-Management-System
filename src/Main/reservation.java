package Main;

import java.sql.Date;

public class reservation {
    private String Lastname;
     private Date dateentre;
    private Date datesortir;
    private String Cin;
    private int Id;
    private int Id_room;
    private String last_name;
    private Date date_de_sortir;
    private String id_client;
    private int id_emp;
    private Date date_de_reserver;

    public reservation( String lastname, int Id, int Id_room,String Cin,Date dateentre,Date datesortir ) {
        this.Lastname = last_name;
        this.dateentre =  date_de_reserver;
        this.datesortir =  date_de_sortir;
        this.Cin = id_client;
        this.Id=  id_emp;
        this.Id_room =  id_emp;

    }
    public reservation(String string, Date date, Date date2, String string2, int int1, int int2) {
    }
    public String getLastname() {
        return Lastname;
    }

    public Date getdateentre() {
        return  dateentre ;
    }


    public Date getdatesortir() {
        return datesortir;
    }

    public String getCin() {
        return Cin;
    }

    public int getId(){
         return Id;
    }

    public int getId_room() {
        return Id_room;
    }


}
