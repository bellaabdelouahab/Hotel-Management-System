package Main;

public class reservation {

    private int Id_reservation;
    private String dateentre;
    private String datesortir;
    private int Id_client;
    private int Id_room;
    private int Id_emp;

    public reservation(int Id_reservation, String dateentre, String datesortir , int Id_client , int Id_room , int Id_emp) {
        this.Id_reservation = Id_reservation;
        this.dateentre =  dateentre;
        this.datesortir =  datesortir;
        this.Id_client = Id_client;
        this.Id_room=  Id_room;
        this.Id_emp =  Id_emp;

    }
    
    public int getId_reservation() {
        return Id_reservation;
    }

    public String getDateentre() {
        return  dateentre ;
    }

    public String getDatesortir() {
        return datesortir;
    }

    public int getId_client(){
         return Id_client;
    }

    public int getId_room() {
        return Id_room;
    }

    public int getId_emp() {
        return Id_emp;
    }

}
