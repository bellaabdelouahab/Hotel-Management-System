package Main;

import java.sql.Date;

public class info_reserve {

    private int cin;
    private String name;
    private int room;
    private int classe;
    private String contentroom;
    private int prix;
    private Date dateentre;
    private Date datesortir;
    private int id;
    

    public info_reserve(int client, String name, int rooms, int clase,String content, int prix,Date date_in,Date date_out ) {
        this.cin = client;
        this.name = name;
        this.room = rooms;
        this.classe = clase;
        this.contentroom=content;
        this.prix = prix;
        this.dateentre = date_in;
        this.datesortir = date_out;
      
    }

    // public void info_reserve(int c, String n, int r, int cl, Date d, int p) {
    // this.cin = c;
    // this.name = n;
    // this.room = r;
    // this.classe = cl;
    // this.date_entre = d;
    // this.prix = p;
    // }

    // public void affiche() {
    // System.out.println("test alah"+cin + name + room + classe + dateentre +
    // prix);
    // }

    public int getCin() {
        return cin;
    }

    public String getName() {
        return name;
    }

    
    public int getRoom() {
        return room;
    }

    public int getClasse() {
        return classe;
    }

    public String getContentroom(){
         return contentroom;
    }

    public int getPrix() {
        return prix;
    }

    public Date getDateentre() {
        return dateentre;
    }

    public Date getDatesortir(){
        return datesortir;
    }

    
}
