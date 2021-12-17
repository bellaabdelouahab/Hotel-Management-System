package Main;

import java.sql.Date;

public class info_reserve {

    private int cin;
    private String name;
    private int room;
    private int classe;
    private Date dateentre;
    private int prix;

    public info_reserve(int int1, String string, int int2, int int3, Date date, int int4) {
        this.cin = int1;
        this.name = string;
        this.room = int2;
        this.classe = int3;
        this.dateentre = date;
        this.prix = int4;
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

    public Date getDateentre() {
        return dateentre;
    }

    public int getPrix() {
        return prix;
    }
}
