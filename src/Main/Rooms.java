package Main;

public class Rooms {
    
    private int Id_room;
    private int Adulte;
    private int Children;
    private int Classe;
    private int Price;

    public Rooms(int Id_room , int Adulte , int Children , int Classe , int Price){
        this.Id_room = Id_room;
        this.Adulte = Adulte;
        this.Children = Children;
        this.Classe = Classe;
        this.Price = Price;
    }

    public int getId_room(){
        return Id_room;
    }

    public int getAdulte(){
        return Adulte;
    }

    public int getChildren(){
        return Children;
    }

    public int getClasse(){
        return Classe;
    }

    public int getPrice(){
        return Price;
    }
}
